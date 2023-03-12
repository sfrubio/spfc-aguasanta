package totalacesso.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {
    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
            String reportName = "Test-Report-" + System.currentTimeMillis() + ".html";
            ExtentSparkReporter htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/" + reportName);
            htmlReporter.config().setTheme(Theme.STANDARD);
            htmlReporter.config().setDocumentTitle("Test Report");
            htmlReporter.config().setEncoding("utf-8");
            htmlReporter.config().setReportName("Test Report");

            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);
            extent.setSystemInfo("Tester", "ChatGPT");
        }
        return extent;
    }

    public static void createTest(String testName) {
        ExtentTest test = extent.createTest(testName);
        ExtentTestManager.setTest(test);
    }

    public static void closeReport() {
        extent.flush();
    }
}
