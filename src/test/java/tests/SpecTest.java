package tests;

import builders.RequestSpecFactory;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class SpecTest {

    @Test
    public void testSpec() {

        given()
                .spec(RequestSpecFactory.getJsonRequestSpec())
                .when()
                .get("/maps/api/place/get/json?key=qaclick123&place_id=123")
                .then()
                .log().all();

    }
}
