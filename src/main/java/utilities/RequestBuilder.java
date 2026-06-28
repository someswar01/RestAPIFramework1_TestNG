package utilities;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public final class RequestBuilder {

    private RequestBuilder() {}

    public static RequestSpecification buildRequest(
            RequestSpecification requestSpec,
            Object requestBody,
            Map<String,String> headers,
            Map<String,Object> queryParams,
            Map<String,Object> pathParams) {

        RequestSpecification request =
                RestAssured
                        .given()
                        .spec(requestSpec);

        if(headers != null && !headers.isEmpty()) {
            request.headers(headers);
        }

        if(queryParams != null && !queryParams.isEmpty()) {
            request.queryParams(queryParams);
        }

        if(pathParams != null && !pathParams.isEmpty()) {
            request.pathParams(pathParams);
        }

        if(requestBody != null) {
            request.body(requestBody);
        }

        return request;
    }

}