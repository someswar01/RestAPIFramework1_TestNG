package base;


import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class BaseTest {

    @BeforeSuite
    public void beforeSuite() {

        System.out.println("========== API Framework Execution Started ==========");

    }

    @AfterSuite
    public void afterSuite() {

        System.out.println("========== API Framework Execution Completed ==========");

    }

}
