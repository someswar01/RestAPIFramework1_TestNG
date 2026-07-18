package builders;

import pojo.order.CreateOrderRequest;
import pojo.order.Order;

import java.util.List;
public final class OrderRequestBuilder {

    private OrderRequestBuilder() {
    }

    public static CreateOrderRequest build(String productId) {

        Order order = Order.builder()
                .country("India")
                .productOrderedId(productId)
                .build();

        return CreateOrderRequest.builder()
                .orders(List.of(order))
                .build();
    }
}