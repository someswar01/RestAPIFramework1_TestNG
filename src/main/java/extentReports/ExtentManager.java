package extentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public final class ExtentManager {

    private static ExtentReports extent;

    private ExtentManager() {
    }

    public static ExtentReports getInstance() {

        if (extent == null) {

            ExtentSparkReporter spark =
                    new ExtentSparkReporter("reports/API-Automation-Report.html");

            spark.config().setReportName("REST API Automation");

            spark.config().setDocumentTitle("Automation Report");

            extent = new ExtentReports();

            extent.attachReporter(spark);

            extent.setSystemInfo("Framework", "REST Assured");

            extent.setSystemInfo("Author", "Somesh");

            extent.setSystemInfo("Environment", "QA");
        }

        return extent;
    }
}
