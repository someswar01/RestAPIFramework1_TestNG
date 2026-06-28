package managers;

public final class ProductManager {

    private static String productId;

    private ProductManager() {}

    public static void setProductId(String id) {
        productId = id;
    }

    public static String getProductId() {
        return productId;
    }

    public static void clear() {
        productId = null;
    }
}
