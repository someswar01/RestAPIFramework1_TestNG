package tests;


import base.BaseTest;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import pojo.login.LoginResponse;
import services.LoginService;
import utilities.LoggerUtil;
import validators.ResponseValidator;

public class LoginTest extends BaseTest {

    private static final Logger logger =
            LoggerUtil.getLogger(LoginService.class);
    @Test
    public void verifyLogin() {

        System.out.println("==============================");
        System.out.println("Login API Started");
        System.out.println("==============================");

        LoginService loginService = new LoginService();

        logger.info("Login Started");
        LoginResponse response = loginService.login();

        ResponseValidator.validateEquals(
                response.getMessage(),
                "Login Successfully",
                "Login Message");

        ResponseValidator.validateNotNull(
                response.getToken(),
                "Token");

        ResponseValidator.validateNotNull(
                response.getUserId(),
                "User Id");

        logger.info("Login API Passed");

    }

}
