package endpoints;

public final class Endpoints {

    private Endpoints() {
    }

    public static final String LOGIN = "/api/ecom/auth/login";

    public static final String ADD_PRODUCT = "/api/ecom/product/add-product";

    public static final String DELETE_PRODUCT = "/api/ecom/product/delete-product/{productId}";

    public static final String CREATE_ORDER = "/api/ecom/order/create-order";

    public static final String GET_ORDER_DETAILS = "/api/ecom/order/get-orders-details";

}
