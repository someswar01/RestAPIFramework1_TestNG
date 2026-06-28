package services;

import builders.RequestBuilder;
import builders.ResponseSpecFactory;
import client.RestClient;
import endpoints.Endpoints;
import managers.AuthManager;
import managers.AuthenticationManager;
import managers.ProductManager;
import models.RequestData;
import pojo.product.DeleteProductResponse;

import java.util.HashMap;
import java.util.Map;

public class DeleteProductService extends BaseService {

    //    public DeleteProductResponse deleteProduct() {
//
//        Map<String,String> headers = new HashMap<>();
//        headers.put("Authorization", AuthManager.getToken());
//
//        Map<String,Object> pathParams = new HashMap<>();
//        pathParams.put("productId", ProductManager.getProductId());
//
//        return RestClient.delete(
//                Endpoints.DELETE_PRODUCT,
//                requestSpec,
//                headers,
//                pathParams,
//                DeleteProductResponse.class
//        );
//    }
    public DeleteProductResponse deleteProduct() {

        RequestData requestData = RequestBuilder.builder()
                .header("Authorization", AuthenticationManager.getToken())
                .pathParam("productId", ProductManager.getProductId())
                .build();

        DeleteProductResponse response = RestClient.delete1(
                Endpoints.DELETE_PRODUCT,
                requestSpec,
                requestData,
                ResponseSpecFactory.success200(),
                DeleteProductResponse.class
        );

        ProductManager.clear();

        return response;
    }
}