package services;

import base.TestContext;
import builders.OrderRequestBuilder;
import builders.RequestBuilder;
import builders.ResponseSpecFactory;
import client.RestClient;
import constants.SchemaPaths;
import endpoints.Endpoints;
import models.RequestData;
import pojo.order.CreateOrderRequest;
import pojo.order.CreateOrderResponse;


public class OrderService extends BaseService {

    private final TestContext context;

    public OrderService(TestContext context) {
        this.context = context;
    }

    public CreateOrderResponse createOrder() {

        CreateOrderRequest request = OrderRequestBuilder.build(context.getProductId());

        RequestData requestData = RequestBuilder.builder()
                .header("Authorization", context.getToken())
                .body(request)
                .schema(SchemaPaths.CREATE_ORDER)
                .build();

        CreateOrderResponse response = RestClient.post3(
                Endpoints.CREATE_ORDER,
                requestSpec,
                requestData,
                ResponseSpecFactory.success201(),
                CreateOrderResponse.class
        );

        context.setOrderId(response.getOrders().get(0));

        return response;
    }


}