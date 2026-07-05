package services;

import builders.ProductRequestBuilder;

import builders.RequestBuilder;
import builders.ResponseSpecFactory;
import client.RestClient;
import constants.SchemaPaths;
import endpoints.Endpoints;

import managers.AuthenticationManager;
import managers.ProductManager;
import models.RequestData;
import pojo.product.AddProductResponse;
import pojo.product.ProductRequest;

import java.io.File;
import java.util.HashMap;
import java.util.Map;


public class ProductService extends BaseService {

    /**
     * Add Product
     */

//    public AddProductResponse addProduct() {
//
//        ProductRequest request = ProductRequestBuilder.build();
//
//        File image = new File("src/test/resources/images/HeadPhones1.jpg");
//
//        Map<String, String> headers = new HashMap<>();
//        headers.put("Authorization", AuthManager.getToken());
//
//        AddProductResponse response = RestClient.postMultipart1(
//                Endpoints.ADD_PRODUCT,
//                multiPartRequestSpec,
//                headers,
//                request.toFormParams(),
//                image,
//                "productImage",
//                AddProductResponse.class
//        );
//
//        ProductManager.setProductId(response.getProductId());
//
//        return response;
//    }



    public AddProductResponse addProduct() {

        ProductRequest request = ProductRequestBuilder.build();

        File image = new File("src/test/resources/images/HeadPhones1.jpg");

        RequestData requestData = RequestBuilder.builder()
                .header("Authorization", AuthenticationManager.getToken())
                .multiPart(image, "productImage")
                .schema(SchemaPaths.ADD_PRODUCT)
                .build();

        requestData.getFormParams().putAll(request.toFormParams());

        AddProductResponse response = RestClient.executeMultipart3(
                Endpoints.ADD_PRODUCT,
                multiPartRequestSpec,
                requestData,
                ResponseSpecFactory.success201(),
                AddProductResponse.class
        );

        ProductManager.setProductId(response.getProductId());

        return response;
    }


}
