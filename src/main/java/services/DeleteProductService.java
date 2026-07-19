package services;

import base.TestContext;
import builders.RequestBuilder;
import builders.ResponseSpecFactory;
import client.RestClient;
import endpoints.Endpoints;
import models.RequestData;
import pojo.product.DeleteProductResponse;

public class DeleteProductService extends BaseService {

    private final TestContext context;

    public DeleteProductService(TestContext context) {
        this.context = context;
    }
    public DeleteProductResponse deleteProduct() {

        RequestData requestData = RequestBuilder.builder()
                .header("Authorization", context.getToken())
                .pathParam("productId", context.getProductId())
                .build();

        DeleteProductResponse response = RestClient.delete3(
                Endpoints.DELETE_PRODUCT,
                requestSpec,
                requestData,
                ResponseSpecFactory.success200(),
                DeleteProductResponse.class
        );

        return response;
    }
}