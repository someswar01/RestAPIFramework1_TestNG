package services;


import builders.RequestSpecFactory;
import io.restassured.specification.RequestSpecification;

public class BaseService {

    protected RequestSpecification requestSpec;
    protected RequestSpecification multiPartRequestSpec;

    public BaseService() {

        requestSpec = RequestSpecFactory.getJsonRequestSpec();
        multiPartRequestSpec = RequestSpecFactory.getMultipartRequestSpec();
    }

}
