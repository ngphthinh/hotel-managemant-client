package iuh.fit.se.group1.network;

public class ClientEventBus {

    public static final EventBus<Response> roomEventBus = new EventBus<>();
    public static final EventBus<Response> bookingEventBus = new EventBus<>();
    public static final EventBus<Response> surchargeEventBus = new EventBus<>();
    public static final EventBus<Response> dashboardEventBus = new EventBus<>();
    public static final EventBus<Response> amenityEventBus = new EventBus<>();
    public static final EventBus<Response> promotionEventBus = new EventBus<>();
    public static final EventBus<Response> orderEventBus = new EventBus<>();
}
