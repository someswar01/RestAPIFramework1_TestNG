package services;

import base.TestContext;
import builders.RequestBuilder;
import builders.ResponseSpecFactory;
import builders.testdata.LoginRequestBuilder;
import client.RestClient;
import constants.SchemaPaths;
import endpoints.Endpoints;

import models.RequestData;
import pojo.login.LoginRequest;
import pojo.login.LoginResponse;

public class LoginService extends BaseService {

    private final TestContext context;

    public LoginService(TestContext context) {
        this.context = context;
    }

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

        context.setToken(response.getToken());
        context.setUserId(response.getUserId());

        return response;
    }
}
