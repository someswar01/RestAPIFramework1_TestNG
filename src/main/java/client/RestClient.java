package client;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import models.RequestData;
import pojo.login.LoginResponse;
import utilities.RequestBuilder;

import java.io.File;
import java.util.Map;

import static io.restassured.RestAssured.given;

public final class RestClient {

    private RestClient() {
    }

    // ==========================================================
    // GET
    // ==========================================================

    public static Response get(String endpoint,
                               RequestSpecification requestSpec) {

        return given()
                .spec(requestSpec)
                .when()
                .get(endpoint)
                .then()
                .extract()
                .response();
    }

    public static Response get(String endpoint,
                               RequestSpecification requestSpec,
                               ResponseSpecification responseSpec) {

        return given()
                .spec(requestSpec)
                .when()
                .get(endpoint)
                .then()
                .spec(responseSpec)
                .extract()
                .response();
    }
    public static Response get(
            String endpoint,
            RequestSpecification requestSpec,
            Map<String,String> headers,
            Map<String,Object> queryParams,
            Map<String,Object> pathParams) {

        return RequestBuilder
                .buildRequest(
                        requestSpec,
                        null,
                        headers,
                        queryParams,
                        pathParams)
                .when()
                .get(endpoint)
                .then()
                .extract()
                .response();
    }
    public static <T> T getOrder(String endpoint,
                            RequestSpecification requestSpec,
                            Map<String,String> headers,
                            Map<String,Object> queryParams,
                            Class<T> responseClass) {

        RequestSpecification spec = given()
                .spec(requestSpec);

        if(headers != null && !headers.isEmpty()) {
            spec.headers(headers);
        }

        if(queryParams != null && !queryParams.isEmpty()) {
            spec.queryParams(queryParams);
        }

        return spec
                .when()
                .get(endpoint)
                .then()
                .extract()
                .as(responseClass);
    }
    public static <T> T getOrderDetails1(
            String endpoint,
            RequestSpecification requestSpec,
            RequestData requestData,
            ResponseSpecification responseSpec,
            Class<T> responseClass) {

        RequestSpecification spec = given().spec(requestSpec);

        // Headers
        if (requestData.getHeaders() != null &&
                !requestData.getHeaders().isEmpty()) {
            spec.headers(requestData.getHeaders());
        }

        // Query Parameters
        if (requestData.getQueryParams() != null &&
                !requestData.getQueryParams().isEmpty()) {
            spec.queryParams(requestData.getQueryParams());
        }

        // Path Parameters
        if (requestData.getPathParams() != null &&
                !requestData.getPathParams().isEmpty()) {
            spec.pathParams(requestData.getPathParams());
        }

        return spec
                .when()
                .get(endpoint)
                .then()
                .extract()
                .as(responseClass);
    }

    public static Response getOrderDetails(String endpoint,
                               RequestSpecification requestSpec,
                               Map<String,String> headers,
                               Map<String,Object> queryParams) {

        RequestSpecification spec =
                given().spec(requestSpec);

        if(headers != null)
            spec.headers(headers);

        if(queryParams != null)
            spec.queryParams(queryParams);

        return spec
                .when()
                .get(endpoint)
                .then()
                .extract()
                .response();
    }
    // ==========================================================
    // POST
    // ==========================================================

//    public static Response post(String endpoint,
//                                RequestSpecification requestSpec) {
//
//        return RestAssured.given()
//                .spec(requestSpec)
//                .when()
//                .post(endpoint)
//                .then()
//                .extract()
//                .response();
//    }

//    public static Response post(String endpoint,
//                                RequestSpecification requestSpec,
//                                ResponseSpecification responseSpec) {
//
//        return RestAssured.given()
//                .spec(requestSpec)
//                .when()
//                .post(endpoint)
//                .then()
//                .spec(responseSpec)
//                .extract()
//                .response();
//    }

//    public static Response post(String endpoint,
//                                RequestSpecification requestSpec,
//                                Object requestBody, ResponseSpecification responseSpec, Class<LoginResponse> loginResponseClass) {
//
//        return RestAssured.given()
//                .spec(requestSpec)
//                .body(requestBody)
//                .when()
//                .post(endpoint)
//                .then()
//                .extract()
//                .response();
//    }
public static <T> T postCreateOrder(
        String endpoint,
        RequestSpecification requestSpec,
        RequestData requestData,
        ResponseSpecification responseSpec,
        Class<T> responseClass) {

    RequestSpecification spec = given().spec(requestSpec);

    // Headers
    if (requestData.getHeaders() != null &&
            !requestData.getHeaders().isEmpty()) {
        spec.headers(requestData.getHeaders());
    }

    // Query Params
    if (requestData.getQueryParams() != null &&
            !requestData.getQueryParams().isEmpty()) {
        spec.queryParams(requestData.getQueryParams());
    }

    // Path Params
    if (requestData.getPathParams() != null &&
            !requestData.getPathParams().isEmpty()) {
        spec.pathParams(requestData.getPathParams());
    }

    // Body
    if (requestData.getBody() != null) {
        spec.body(requestData.getBody());
    }

    return spec
            .when()
            .post(endpoint)
            .then()
            .spec(responseSpec)
            .extract()
            .as(responseClass);
}
    public static <T> T postLogin(
            String endpoint,
            RequestSpecification requestSpec,
            RequestData requestData,
            Class<T> responseClass) {

        RequestSpecification spec = given().spec(requestSpec);

        if (requestData.getHeaders() != null && !requestData.getHeaders().isEmpty()) {
            spec.headers(requestData.getHeaders());
        }

        if (requestData.getQueryParams() != null && !requestData.getQueryParams().isEmpty()) {
            spec.queryParams(requestData.getQueryParams());
        }

        if (requestData.getPathParams() != null && !requestData.getPathParams().isEmpty()) {
            spec.pathParams(requestData.getPathParams());
        }

        if (requestData.getBody() != null) {
            spec.body(requestData.getBody());
        }

        spec.log().all();   // Temporary for debugging

        return spec
                .when()
                .post(endpoint)
                .then()
                .extract()
                .as(responseClass);
    }

    public static Response postOr(String endpoint,
                                RequestSpecification requestSpec,
                                Map<String, String> headers,
                                Object requestBody) {

        RequestSpecification spec = given().spec(requestSpec);

        if (headers != null && !headers.isEmpty()) {
            spec.headers(headers);
        }

        if (requestBody != null) {
            spec.body(requestBody);
        }

        return spec
                .when()
                .post(endpoint)
                .then()
                .extract()
                .response();
    }

    public static <T> T postLogin(
            String endpoint,
            RequestSpecification requestSpec,
            RequestData requestData,
            ResponseSpecification responseSpec,
            Class<T> responseClass) {

        RequestSpecification spec = given().spec(requestSpec);

        // Headers
        if (requestData.getHeaders() != null &&
                !requestData.getHeaders().isEmpty()) {
            spec.headers(requestData.getHeaders());
        }

        // Query Params
        if (requestData.getQueryParams() != null &&
                !requestData.getQueryParams().isEmpty()) {
            spec.queryParams(requestData.getQueryParams());
        }

        // Path Params
        if (requestData.getPathParams() != null &&
                !requestData.getPathParams().isEmpty()) {
            spec.pathParams(requestData.getPathParams());
        }

        // Body
        if (requestData.getBody() != null) {
            spec.body(requestData.getBody());
        }

        Response response = spec
                .when()
                .post(endpoint);

        response.then().spec(responseSpec);

        return response.as(responseClass);
    }
    public static <T> T postMultipart(String endpoint,
                                      RequestSpecification requestSpec,
                                      Map<String, String> formParams,
                                      File file,
                                      String fileParamName,
                                      Class<T> responseClass) {

        RequestSpecification spec =
                given().spec(requestSpec);

        if (formParams != null && !formParams.isEmpty()) {
            spec.formParams(formParams);
        }

        if (file != null) {
            spec.multiPart(fileParamName, file);
        }

        return spec
                .when()
                .post(endpoint)
                .then()
                .extract()
                .as(responseClass);
    }
    public static <T> T executeMultipart(
            String endpoint,
            RequestSpecification requestSpec,
            RequestData requestData,
            ResponseSpecification responseSpec,
            Class<T> responseClass) {

        RequestSpecification spec = given().spec(requestSpec);

        // headers
        if (requestData.getHeaders() != null && !requestData.getHeaders().isEmpty()) {
            spec.headers(requestData.getHeaders());
        }

        // form params
        if (requestData.getFormParams() != null && !requestData.getFormParams().isEmpty()) {
            spec.formParams(requestData.getFormParams());
        }

        // multipart
        if (requestData.getMultipartFile() != null) {
            spec.multiPart(
                    requestData.getMultipartName(),
                    requestData.getMultipartFile());
        }

        return spec
                .when()
                .post(endpoint)
                .then()
                .spec(responseSpec)
                .extract()
                .as(responseClass);
    }

    public static <T> T postOrder(String endpoint,
                             RequestSpecification requestSpec,
                             Map<String, String> headers,
                             Object requestBody,
                             Class<T> responseClass) {

        RequestSpecification spec = given().spec(requestSpec);

        if (headers != null && !headers.isEmpty()) {
            spec.headers(headers);
        }

        if (requestBody != null) {
            spec.body(requestBody);
        }

        return spec
                .when()
                .post(endpoint)
                .then()
                .extract()
                .as(responseClass);
    }
    // ==========================================================
    // PUT
    // ==========================================================

    public static Response put(String endpoint,
                               RequestSpecification requestSpec) {

        return given()
                .spec(requestSpec)
                .when()
                .put(endpoint)
                .then()
                .extract()
                .response();
    }

    public static Response put(String endpoint,
                               RequestSpecification requestSpec,
                               ResponseSpecification responseSpec) {

        return given()
                .spec(requestSpec)
                .when()
                .put(endpoint)
                .then()
                .spec(responseSpec)
                .extract()
                .response();
    }

    public static Response put(String endpoint,
                               RequestSpecification requestSpec,
                               Object requestBody) {

        return given()
                .spec(requestSpec)
                .body(requestBody)
                .when()
                .put(endpoint)
                .then()
                .extract()
                .response();
    }

    public static Response put(String endpoint,
                               RequestSpecification requestSpec,
                               Object requestBody,
                               ResponseSpecification responseSpec) {

        return given()
                .spec(requestSpec)
                .body(requestBody)
                .when()
                .put(endpoint)
                .then()
                .spec(responseSpec)
                .extract()
                .response();
    }

    // ==========================================================
    // PATCH
    // ==========================================================

    public static Response patch(String endpoint,
                                 RequestSpecification requestSpec) {

        return given()
                .spec(requestSpec)
                .when()
                .patch(endpoint)
                .then()
                .extract()
                .response();
    }

    public static Response patch(String endpoint,
                                 RequestSpecification requestSpec,
                                 ResponseSpecification responseSpec) {

        return given()
                .spec(requestSpec)
                .when()
                .patch(endpoint)
                .then()
                .spec(responseSpec)
                .extract()
                .response();
    }

    public static Response patch(String endpoint,
                                 RequestSpecification requestSpec,
                                 Object requestBody) {

        return given()
                .spec(requestSpec)
                .body(requestBody)
                .when()
                .patch(endpoint)
                .then()
                .extract()
                .response();
    }

    public static Response patch(String endpoint,
                                 RequestSpecification requestSpec,
                                 Object requestBody,
                                 ResponseSpecification responseSpec) {

        return given()
                .spec(requestSpec)
                .body(requestBody)
                .when()
                .patch(endpoint)
                .then()
                .spec(responseSpec)
                .extract()
                .response();
    }

    // ==========================================================
    // DELETE
    // ==========================================================

    public static Response delete(String endpoint,
                                  RequestSpecification requestSpec) {

        return given()
                .spec(requestSpec)
                .when()
                .delete(endpoint)
                .then()
                .extract()
                .response();
    }

    public static Response delete(String endpoint,
                                  RequestSpecification requestSpec,
                                  ResponseSpecification responseSpec) {

        return given()
                .spec(requestSpec)
                .when()
                .delete(endpoint)
                .then()
                .spec(responseSpec)
                .extract()
                .response();
    }

    public static Response delete(String endpoint,
                                  RequestSpecification requestSpec,
                                  Object requestBody) {

        return given()
                .spec(requestSpec)
                .body(requestBody)
                .when()
                .delete(endpoint)
                .then()
                .extract()
                .response();
    }

    public static Response delete(String endpoint,
                                  RequestSpecification requestSpec,
                                  Object requestBody,
                                  ResponseSpecification responseSpec) {

        return given()
                .spec(requestSpec)
                .body(requestBody)
                .when()
                .delete(endpoint)
                .then()
                .spec(responseSpec)
                .extract()
                .response();
    }

    public static <T> T delete1(
            String endpoint,
            RequestSpecification requestSpec,
            RequestData requestData,
            ResponseSpecification responseSpec,
            Class<T> responseClass) {

        RequestSpecification spec = given().spec(requestSpec);

        // Headers
        if (requestData.getHeaders() != null &&
                !requestData.getHeaders().isEmpty()) {
            spec.headers(requestData.getHeaders());
        }

        // Query Params
        if (requestData.getQueryParams() != null &&
                !requestData.getQueryParams().isEmpty()) {
            spec.queryParams(requestData.getQueryParams());
        }

        // Path Params
        if (requestData.getPathParams() != null &&
                !requestData.getPathParams().isEmpty()) {
            spec.pathParams(requestData.getPathParams());
        }

        // Body (Optional)
        if (requestData.getBody() != null) {
            spec.body(requestData.getBody());
        }

        return spec
                .when()
                .delete(endpoint)
                .then()
                .spec(responseSpec)
                .extract()
                .as(responseClass);
    }
}