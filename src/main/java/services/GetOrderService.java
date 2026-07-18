package services;

import base.TestContext;
import builders.RequestBuilder;
import builders.ResponseSpecFactory;
import client.RestClient;
import constants.SchemaPaths;
import endpoints.Endpoints;
import models.RequestData;
import pojo.order.GetOrderDetailsResponse;

public class GetOrderService extends BaseService {

    private final TestContext context;

    public GetOrderService(TestContext context) {
        this.context = context;
    }
    public GetOrderDetailsResponse getOrderDetails() {

        RequestData requestData = RequestBuilder.builder()
                .header("Authorization", context.getToken())
                .queryParam("id", context.getOrderId())
                .schema(SchemaPaths.GET_ORDER_DETAILS)
                .build();

        return RestClient.get3(
                Endpoints.GET_ORDER_DETAILS,
                requestSpec,
                requestData,
                ResponseSpecFactory.success200(),
                GetOrderDetailsResponse.class
        );
    }
}
