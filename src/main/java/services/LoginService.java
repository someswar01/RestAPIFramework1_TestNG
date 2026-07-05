package services;

import builders.RequestBuilder;
import builders.ResponseSpecFactory;
import builders.testdata.LoginRequestBuilder;
import client.RestClient;
import config.ConfigReader;
import constants.SchemaPaths;
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
                .schema(SchemaPaths.LOGIN)
                .build();

        LoginResponse response = RestClient.post3(
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
}
