package managers;

public final class OrderManager {

    private static String orderId;

    private OrderManager() {}

    public static void setOrderId(String id) {
        orderId = id;
    }

    public static String getOrderId() {
        return orderId;
    }
}
