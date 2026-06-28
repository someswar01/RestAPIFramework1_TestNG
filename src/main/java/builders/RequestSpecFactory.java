package builders;
import config.ConfigReader;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
public final class RequestSpecFactory {
    private RequestSpecFactory() {}
    public static RequestSpecification getJsonRequestSpec() {

        return new RequestSpecBuilder()
                .setBaseUri(ConfigReader.get("baseUrl"))
                .setContentType(ContentType.JSON)
                .build();
    }

    public static RequestSpecification getMultipartRequestSpec() {

        return new RequestSpecBuilder()
                .setBaseUri(ConfigReader.get("baseUrl"))
                .build();
    }
}