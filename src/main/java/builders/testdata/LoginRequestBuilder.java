package builders.testdata;

import config.ConfigReader;
import pojo.login.LoginRequest;

public final class LoginRequestBuilder {

    private LoginRequestBuilder() {}

    public static LoginRequest build() {

        LoginRequest request = new LoginRequest();

        request.setUserEmail(ConfigReader.get("userEmail"));
        request.setUserPassword(ConfigReader.get("userPassword"));

        return request;
    }
}