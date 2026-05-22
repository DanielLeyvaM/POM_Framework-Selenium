package TestClass;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

public class BaseTest {

    public WebDriver driver;

    public WebDriver configDriver() throws IOException {

        //-------------------- Load Properties File ----------------------
        Properties prop= new Properties();
        FileInputStream file= new FileInputStream(System.getProperty("user.dir")+"\\Data.properties");
        prop.load(file);

        if(prop.getProperty("browser").equalsIgnoreCase("chrome")){
            //Auto Driver Manager
            //WebDriverManager.chromedriver().setup();

            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\1-Drivers\\chromedriver.exe");
            driver= new ChromeDriver();

        } else if(prop.getProperty("browser").equalsIgnoreCase("edge")){
            System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"\\1-Drivers\\msedgedriver.exe");
            driver= new EdgeDriver();

        }

        //-------------------- Driver Configuration -----------------------
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        return driver;
    }

    @BeforeMethod
    public void initDriver() throws IOException {
        driver= configDriver();
        driver.get("https://demowebshop.tricentis.com/");
    }

    @AfterMethod
    public void closeDriver(){
        if(driver != null){
            driver.quit();
        }
    }

    public String takeScreenshot(String testName, WebDriver driver) throws IOException {
        TakesScreenshot ss= (TakesScreenshot) driver;
        File src= ss.getScreenshotAs(OutputType.FILE);

        //Creates directory for Evidences
        //Files.createDirectories(Paths.get("Evidences"));

        String date= LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));
        Files.createDirectories(Paths.get("reports\\screenshots"));

        String filePath = System.getProperty("user.dir")+ "\\reports\\screenshots\\"+ testName + "_" + date + ".png";
        File name = new File(filePath);

        //File name= new File("Evidences\\"+testName+"_"+date+".png");

        Files.copy(src.toPath(), name.toPath());
        //System.out.println(filePath);

        return "screenshots/" + testName + "_" + date + ".png";
    }

}