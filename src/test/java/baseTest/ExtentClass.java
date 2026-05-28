package baseTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExtentClass {

    public static ExtentReports createReport() {
        String date= LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));
        String path= System.getProperty("user.dir")+"\\reports\\index_"+date+".html";

        ExtentSparkReporter reporter= new ExtentSparkReporter(path);
        reporter.config().setReportName("FRAMEWORK");
        reporter.config().setDocumentTitle("TEST RESULTS");   //Browser tab Name
        reporter.config().setTheme(Theme.DARK);

        ExtentReports extent= new ExtentReports();
        extent.attachReporter(reporter);
        return extent;
    }
}
