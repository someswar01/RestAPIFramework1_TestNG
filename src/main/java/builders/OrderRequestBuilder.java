package builders;

import managers.ProductManager;
import pojo.order.CreateOrderRequest;
import pojo.order.Order;

import java.util.List;

public final class OrderRequestBuilder {

    private OrderRequestBuilder(){}

    public static CreateOrderRequest build(){

        Order order = Order.builder()
                .country("India")
                .productOrderedId(ProductManager.getProductId())
                .build();

        return CreateOrderRequest.builder()
                .orders(List.of(order))
                .build();
    }
}
