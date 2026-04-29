package iuh.fit.se.group1.network.client;

import iuh.fit.se.group1.network.ClientEventBus;
import iuh.fit.se.group1.network.CommandType;
import iuh.fit.se.group1.network.Request;
import iuh.fit.se.group1.network.Response;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class ClientSocketManager {

    private static ClientSocketManager instance;

    private Socket socket;
    private ObjectOutputStream out;
    private ObjectInputStream in;

    private volatile boolean connected;

    private final Map<String, CompletableFuture<Response>> pending = new ConcurrentHashMap<>();

    private ClientSocketManager() {
    }

    public static synchronized ClientSocketManager getInstance() {
        if (instance == null) {
            instance = new ClientSocketManager();
        }
        return instance;
    }

    public boolean connect(String host, int port) {
        try {
            socket = new Socket(host, port);
            out = new ObjectOutputStream(socket.getOutputStream());
            out.flush();
            in = new ObjectInputStream(socket.getInputStream());

            connected = true;
            startListener();

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public CompletableFuture<Response> send(Request request) throws IOException {
        if (!isConnected()) {
            throw new IOException("Socket not connected");
        }
        String requestId = UUID.randomUUID().toString();
        request.setRequestId(requestId);

        log.info("Sending request to server: " + request.getCommandType() + " with ID: " + requestId);

        CompletableFuture<Response> future = new CompletableFuture<>();
        pending.put(requestId, future);

        synchronized (out) {
            out.writeObject(request);
            out.flush();
            out.reset();
        }
        return future;
    }

    private void startListener() {
        Thread t = new Thread(() -> {
            while (connected) {
                try {
                    Response res = (Response) in.readObject();

                    String requestId = res.getRequestId();

                    if (requestId == null) {
                        handleResponse(res);
                    } else {
                        CompletableFuture<Response> f = pending.remove(requestId);
                        if (f != null)
                            f.complete(res);
                    }

                } catch (Exception e) {
                    log.error("Socket disconnected: {}", e.getMessage());

                    connected = false;

                    // fail tất cả request đang chờ
                    pending.forEach((id, future) ->
                            future.completeExceptionally(new IOException("Disconnected"))
                    );
                    pending.clear();

                    disconnect(); // đóng socket sạch

                    break; // thoát thread
                }
            }
        });
        t.setDaemon(true);
        t.start();
    }

    private void handleResponse(Response response) {
        CommandType type = response.getCommandType();
        log.info("Refreshing data for command: {} with message {}", type, response.getMessage());

        switch (type) {
            case ROOM_REFRESH -> ClientEventBus.roomEventBus.publish(response);
            case AMENITY_REFRESH -> ClientEventBus.amenityEventBus.publish(response);
            case PROMOTION_REFRESH -> ClientEventBus.promotionEventBus.publish(response);
            case SURCHARGE_REFRESH -> ClientEventBus.surchargeEventBus.publish(response);
            case ORDER_REFRESH -> ClientEventBus.orderEventBus.publish(response);
            default -> {
                log.warn("Received response with unhandled command type: " + type);
            }
        }
    }

    public void disconnect() {
        connected = false;

        try {
            if (out != null)
                out.close();
        } catch (Exception ignored) {
        }
        try {
            if (in != null)
                in.close();
        } catch (Exception ignored) {
        }
        try {
            if (socket != null)
                socket.close();
        } catch (Exception ignored) {
        }
    }

    public boolean isConnected() {
        return connected && socket != null && !socket.isClosed();
    }
}