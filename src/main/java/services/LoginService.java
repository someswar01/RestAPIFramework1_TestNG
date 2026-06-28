package services;

import builders.RequestBuilder;
import builders.ResponseSpecFactory;
import builders.testdata.LoginRequestBuilder;
import client.RestClient;
import config.ConfigReader;
import endpoints.Endpoints;
import io.restassured.response.Response;
import managers.AuthManager;
import models.RequestData;
import pojo.login.LoginRequest;
import pojo.login.LoginResponse;

import static io.restassured.RestAssured.given;

public class LoginService extends BaseService {


    public LoginResponse login() {

        LoginRequest request = LoginRequestBuilder.build();

        RequestData requestData = RequestBuilder.builder()
                .body(request)
                .build();

        LoginResponse response = RestClient.postLogin(
                Endpoints.LOGIN,
                requestSpec,
                requestData,
                ResponseSpecFactory.success200(),
                LoginResponse.class
        );

        AuthManager.setToken(response.getToken());
        AuthManager.setUserId(response.getUserId());

        return response;
    }

//    public LoginResponse login() {
//
//        LoginRequest request = LoginRequestBuilder.build();
//
//        Response response = given()
//                .spec(requestSpec)
//                .body(request)
//                .when()
//                .post(Endpoints.LOGIN);
//
//        System.out.println("Status Code : " + response.getStatusCode());
//        System.out.println(response.asPrettyString());
//
//        LoginResponse loginResponse = response.as(LoginResponse.class);
//
//        AuthManager.setToken(loginResponse.getToken());
//        AuthManager.setUserId(loginResponse.getUserId());
//
//        return loginResponse;
//    }
}
