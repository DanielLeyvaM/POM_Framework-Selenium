package baseTest;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BaseTest {

//    public WebDriver driver;
//
//    private final String URL="https://demowebshop.tricentis.com/";
//
//    public WebDriver setBrowser(String webBrowser) throws IOException {
//
//          //-------------------- Load Properties File ----------------------
////        Properties prop= new Properties();
////        FileInputStream file= new FileInputStream(System.getProperty("user.dir")+"\\Data.properties");
////        prop.load(file);
////
////        if(prop.getProperty("browser").equalsIgnoreCase("chrome")){
////            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\1-Drivers\\chromedriver.exe");
////            driver= new ChromeDriver();
////        }
//
//        //-- Read parameter from TESTNG.xml
//        if(webBrowser.equalsIgnoreCase("chrome")) {
//            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\1-Drivers\\chromedriver.exe");
//            return new ChromeDriver();
//        } else if (webBrowser.equalsIgnoreCase("edge")) {
//            System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"\\1-Drivers\\msedgedriver.exe");
//            return new EdgeDriver();
//        }
//        return new ChromeDriver();
//    }
//
//    @Parameters({"browser"})
//    @BeforeMethod
//    public void initDriver(String browser) throws IOException {
//        driver= setBrowser(browser);
//
//        //-------------------- Driver Configuration -----------------------
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.manage().window().maximize();
//
//        driver.get(URL);
//    }
//
//    @AfterMethod
//    public void closeDriver(){
//        if(driver != null){
//            driver.quit();
//        }
//    }

//    public String takeScreenshot(String testName, WebDriver driver) throws IOException {
//        TakesScreenshot ss= (TakesScreenshot) driver;
//        File src= ss.getScreenshotAs(OutputType.FILE);
//
//        String date= LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss"));
//        Files.createDirectories(Paths.get("reports\\screenshots"));
//
//        String filePath = System.getProperty("user.dir")+ "\\reports\\screenshots\\"+ testName + "_" +date+ ".png";
//        //System.out.println(filePath);
//        File name = new File(filePath);
//
//        Files.copy(src.toPath(), name.toPath());
//
//        return "screenshots/" +testName+ "_" +date+ ".png";
//    }


    //----------------------------- REFACTORING -----------------------------
    protected WebDriver driver;

    @Parameters({"browser"})
    @BeforeMethod
    public void initDriver(String browser) {
        driver= setBrowser(browser);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void closeDriver(){
        if(driver != null){
            driver.quit();
        }
    }

    public WebDriver setBrowser(String browser) {
        //String browser= System.getProperty("browser");           //Run in terminal using mvn clean test -Dbrowser=edge (No reports generated)

        if(browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\1-Drivers\\chromedriver.exe");
            return new ChromeDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"\\1-Drivers\\msedgedriver.exe");
            return new EdgeDriver();
        }

        return new ChromeDriver();      //Default option
    }


    public String takeScreenshot(String testName, WebDriver driver) throws IOException {
        TakesScreenshot ss= (TakesScreenshot) driver;
        File src= ss.getScreenshotAs(OutputType.FILE);

        String date= LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss"));
        Files.createDirectories(Paths.get("reports\\screenshots"));

        String filePath = System.getProperty("user.dir")+ "\\reports\\screenshots\\"+ testName + "_" +date+ ".png";
        //System.out.println(filePath);
        File name = new File(filePath);

        Files.copy(src.toPath(), name.toPath());

        return "screenshots/" +testName+ "_" +date+ ".png";
    }
}