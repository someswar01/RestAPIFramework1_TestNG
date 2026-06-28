package services;

import builders.RequestBuilder;
import builders.ResponseSpecFactory;
import client.RestClient;
import endpoints.Endpoints;
import io.restassured.response.Response;
import managers.AuthManager;
import managers.AuthenticationManager;
import managers.OrderManager;
import models.RequestData;
import pojo.order.GetOrderDetailsResponse;

import java.util.HashMap;
import java.util.Map;

public class GetOrderService extends BaseService{

//    public GetOrderDetailsResponse getOrderDetails() {
//
//        Map<String,String> headers = new HashMap<>();
//        headers.put("Authorization", AuthManager.getToken());
//
//        Map<String,Object> query = new HashMap<>();
//        query.put("id", OrderManager.getOrderId());
//
//        return RestClient.getOrder(
//                Endpoints.GET_ORDER_DETAILS,
//                requestSpec,
//                headers,
//                query,
//                GetOrderDetailsResponse.class
//        );

    public GetOrderDetailsResponse getOrderDetails() {

        RequestData requestData = RequestBuilder.builder()
                .header("Authorization", AuthenticationManager.getToken())
                .queryParam("id", OrderManager.getOrderId())
                .build();

        return RestClient.getOrderDetails1(
                Endpoints.GET_ORDER_DETAILS,
                requestSpec,
                requestData,
                ResponseSpecFactory.success200(),
                GetOrderDetailsResponse.class
        );
    }
}
