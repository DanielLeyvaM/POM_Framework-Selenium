package baseTest;

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
        ITestListener.super.onTestStart(result);
        test= extent.createTest(result.getMethod().getMethodName());
        extentTest.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
        extentTest.get().log(Status.PASS,"Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);

        //test.log(Status.FAIL,"Test Failed");
        extentTest.get().fail(result.getThrowable());

//        try {
//            driver=(WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }

        //Screenshots
        String path= null;
        try {
            path = takeScreenshot(result.getMethod().getMethodName(), driver);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(path);
        //test.addScreenCaptureFromPath(path, result.getMethod().getMethodName());
        extentTest.get().fail("Screenshot").addScreenCaptureFromPath(path);

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
        extentTest.get().log(Status.PASS,"Test Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
        extent.flush();
    }
}
