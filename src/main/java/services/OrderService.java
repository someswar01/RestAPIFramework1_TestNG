package services;

import builders.OrderRequestBuilder;
import builders.RequestBuilder;
import builders.ResponseSpecFactory;
import client.RestClient;
import constants.SchemaPaths;
import endpoints.Endpoints;
import io.restassured.response.Response;
import managers.AuthManager;
import managers.AuthenticationManager;
import managers.OrderManager;
import models.RequestData;
import pojo.order.CreateOrderRequest;
import pojo.order.CreateOrderResponse;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class OrderService extends BaseService {

//    public CreateOrderResponse createOrder() {
//
//        CreateOrderRequest request =
//                OrderRequestBuilder.build();
//
//        Map<String,String> headers = new HashMap<>();
//        headers.put("Authorization", AuthManager.getToken());
//
//        CreateOrderResponse response =
//                RestClient.postOrder(
//                        Endpoints.CREATE_ORDER,
//                        requestSpec,
//                        headers,
//                        request,
//                        CreateOrderResponse.class
//                );
//
//        OrderManager.setOrderId(
//                response.getOrders().get(0)
//        );
//
//        return response;
//    }

    public CreateOrderResponse createOrder() {

        CreateOrderRequest request = OrderRequestBuilder.build();

        RequestData requestData = RequestBuilder.builder()
                .header("Authorization", AuthenticationManager.getToken())
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

        OrderManager.setOrderId(response.getOrders().get(0));

        return response;
    }

//    public Response createOrder() {
//
//        CreateOrderRequest request = OrderRequestBuilder.build();
//
//        Map<String, String> headers = new HashMap<>();
//        headers.put("Authorization", AuthenticationManager.getToken());
//
//        Response response = given()
//                .spec(requestSpec)
//                .headers(headers)
//                .body(request)
//                .when()
//                .post(Endpoints.CREATE_ORDER);
//
//        System.out.println("Status Code : " + response.getStatusCode());
//        System.out.println(response.asPrettyString());
//
//        return response;
//    }


}