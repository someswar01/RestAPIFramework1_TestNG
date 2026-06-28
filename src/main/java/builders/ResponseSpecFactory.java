package builders;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;
public final class ResponseSpecFactory {
    private ResponseSpecFactory() {}
    public static ResponseSpecification getResponseSpec(int statusCode) {
        return new ResponseSpecBuilder()
                .expectStatusCode(statusCode)
                .expectContentType(ContentType.JSON)
                .build();
    }

    public static ResponseSpecification success200() {

        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();
    }

    public static ResponseSpecification success201() {

        return new ResponseSpecBuilder()
                .expectStatusCode(201)
                .build();
    }

    public static ResponseSpecification badRequest400() {

        return new ResponseSpecBuilder()
                .expectStatusCode(400)
                .build();
    }

    public static ResponseSpecification unauthorized401() {

        return new ResponseSpecBuilder()
                .expectStatusCode(401)
                .build();
    }

    public static ResponseSpecification forbidden403() {

        return new ResponseSpecBuilder()
                .expectStatusCode(403)
                .build();
    }

    public static ResponseSpecification notFound404() {

        return new ResponseSpecBuilder()
                .expectStatusCode(404)
                .build();
    }

    public static ResponseSpecification serverError500() {

        return new ResponseSpecBuilder()
                .expectStatusCode(500)
                .build();
    }


}