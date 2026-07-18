package services;

import base.TestContext;
import builders.ProductRequestBuilder;

import builders.RequestBuilder;
import builders.ResponseSpecFactory;
import client.RestClient;
import constants.SchemaPaths;
import endpoints.Endpoints;

import models.RequestData;
import pojo.product.AddProductResponse;
import pojo.product.ProductRequest;

import java.io.File;


public class ProductService extends BaseService {

    private final TestContext context;

    public ProductService(TestContext context) {
        this.context = context;
    }

    public AddProductResponse addProduct() {

        ProductRequest request =
                ProductRequestBuilder.build(context.getUserId());
        File image = new File("src/test/resources/images/HeadPhones1.jpg");

        RequestData requestData = RequestBuilder.builder()
                .header("Authorization", context.getToken())
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

        context.setProductId(response.getProductId());

        return response;
    }
}
