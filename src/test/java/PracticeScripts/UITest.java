package PracticeScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.sql.Driver;
import java.time.Duration;
import java.util.List;

public class UITest {

    @Test
    public void exercise(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\DANIEL\\Documents\\Java\\Selenium\\1-Drivers\\chromedriver.exe");
        WebDriver driver= new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/angularpractice/");

        driver.findElement(By.name("name")).sendKeys("Daniel");
        driver.findElement(By.name("email")).sendKeys("test-email@gmail.com");
        driver.findElement(By.id("exampleInputPassword1")).sendKeys("password");
        driver.findElement(By.id("exampleCheck1")).click();

        Select dp= new Select(driver.findElement(By.id("exampleFormControlSelect1")));
        dp.selectByContainsVisibleText("Male");

        driver.findElement(By.id("inlineRadio1")).click();

        driver.findElement(By.name("bday")).sendKeys("13/05/2026");
        driver.findElement(By.cssSelector("input[value='Submit']")).click();

        System.out.println(driver.findElement(By.cssSelector(".alert-success")).getText());
        driver.quit();

    }
}
