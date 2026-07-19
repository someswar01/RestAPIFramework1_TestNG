package stepdefinitions;

import io.cucumber.java.en.Given;
import services.LoginService;

public class LoginSteps {

    private final LoginService loginService;

    public LoginSteps(LoginService loginService) {
        this.loginService = loginService;
    }

    @Given("User is logged into the application")
    public void userIsLoggedIntoTheApplication() {

        loginService.login();

    }
}
