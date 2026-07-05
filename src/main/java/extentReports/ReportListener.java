package extentReports;

import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ReportListener implements ITestListener {

    @Override
    public void onStart(ITestContext context) {

        ExtentManager.getInstance();
    }

    @Override
    public void onTestStart(ITestResult result) {

        ExtentTest test = ExtentManager.getInstance()
                .createTest(result.getMethod().getMethodName());

        ExtentTestManager.setTest(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        ExtentTestManager.getTest()
                .pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        ExtentTestManager.getTest()
                .fail(result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        ExtentTestManager.getTest()
                .skip("Test Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {

        ExtentManager.getInstance().flush();
        ExtentTestManager.unload();
    }
}
