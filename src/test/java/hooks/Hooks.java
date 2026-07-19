package hooks;

import base.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import services.LoginService;

public class Hooks {

    private final TestContext context;
    private final LoginService loginService;

    public Hooks(TestContext context, LoginService loginService) {
        this.context = context;
        this.loginService = loginService;
    }

    @Before
    public void beforeScenario(Scenario scenario) {

        System.out.println("========================================");
        System.out.println("Scenario Started : " + scenario.getName());
        System.out.println("========================================");

        loginService.login();

    }

    @After
    public void afterScenario(Scenario scenario) {

        System.out.println("========================================");
        System.out.println("Scenario Status : " + scenario.getStatus());
        System.out.println("========================================");

    }
}