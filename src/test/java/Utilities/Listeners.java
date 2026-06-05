package Utilities;

import baseTest.BaseTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listeners extends BaseTest implements ITestListener {

    ExtentReports extent = ExtentClass.createReport();
    ExtentTest test;
    ThreadLocal <ExtentTest> extentTest= new ThreadLocal<>();


    @Override
    public void onTestStart(ITestResult result) {
        test= extent.createTest(result.getMethod().getMethodName());
        extentTest.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.get().log(Status.PASS,"Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        extentTest.get().fail(result.getThrowable());

        BaseTest testClass = (BaseTest) result.getInstance();
        WebDriver driver = testClass.getDriver();

        String path = null;
        try {
            path = takeScreenshot( result.getMethod().getMethodName(), driver );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        extentTest.get().fail("Screenshot").addScreenCaptureFromPath(path);

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        extentTest.get().log(Status.PASS,"Test Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
