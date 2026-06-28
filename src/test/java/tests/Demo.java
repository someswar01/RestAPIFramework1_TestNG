package tests;

import config.ConfigReader;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import pojo.login.LoginRequest;

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

    @Test
    public void directLoginTest() {

        LoginRequest request = new LoginRequest();
        request.setUserEmail("Shanker@123.com");
        request.setUserPassword("Shanker@123");

        given()
                .baseUri("https://rahulshettyacademy.com")
                .contentType(ContentType.JSON)
                .body(request)
                .when()
                .post("/api/ecom/auth/login")
                .then()
                .log().all()
                .statusCode(200);
    }

}
