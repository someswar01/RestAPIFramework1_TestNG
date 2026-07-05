package tests;

import builders.RequestSpecFactory;
import builders.testdata.LoginRequestBuilder;
import endpoints.Endpoints;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojo.login.LoginRequest;
import utilities.SchemaValidator;

import static io.restassured.RestAssured.given;

public class Demo {


//        public static void main(String[] args) {
//
//            System.out.println(ConfigReader.get("baseUrl"));
//
//            System.out.println(ConfigReader.get("userEmail"));
//            System.out.println(ConfigReader.get("userPassword"));
//
//            System.out.println(ConfigReader.get("apiKey"));
//
//        }

//    @Test
//    public void directLoginTest() {
//
//        LoginRequest request = new LoginRequest();
//        request.setUserEmail("Shanker@123.com");
//        request.setUserPassword("Shanker@123");
//
//        given()
//                .baseUri("https://rahulshettyacademy.com")
//                .contentType(ContentType.JSON)
//                .body(request)
//                .when()
//                .post("/api/ecom/auth/login")
//                .then()
//                .log().all()
//                .statusCode(200);
//    }
@Test
public void verifyLoginSchema() {

    LoginRequest request = LoginRequestBuilder.build();

    Response response = given()
            .spec(RequestSpecFactory.getJsonRequestSpec())
            .body(request)
            .when()
            .post(Endpoints.LOGIN);

    response.then().statusCode(200);

    SchemaValidator.validate(
            response,
            "schemas/login/login-schema.json"
    );
}
}
