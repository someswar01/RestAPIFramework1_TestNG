package base;


import extentReports.ReportListener;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Listeners;

@Listeners(ReportListener.class)
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
