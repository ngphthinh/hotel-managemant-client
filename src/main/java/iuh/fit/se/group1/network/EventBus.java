package iuh.fit.se.group1.network;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class EventBus<T> {
    private final List<Consumer<T>> listeners = new ArrayList<>();

    public void subscribe(Consumer<T> listener) {
        listeners.add(listener);
    }

    public void publish(T event) {
        for (Consumer<T> l : listeners) {
            l.accept(event);
        }
    }
}