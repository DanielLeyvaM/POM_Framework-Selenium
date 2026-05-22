package PracticeScripts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class SynchronizationTest {

    @Test
    public void exercise(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\DANIEL\\Documents\\Java\\Selenium\\1-Drivers\\chromedriver.exe");
        WebDriver driver= new EdgeDriver();

        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");

        driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
        driver.findElement(By.id("password")).sendKeys("Learning@830$3mK2");
        driver.findElement(By.xpath("//input[@value='user']")).click();

        WebDriverWait wait= new WebDriverWait (driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("modal-content"))));
        driver.findElement(By.id("okayBtn")).click();

        Select dp= new Select(driver.findElement(By.cssSelector("select[data-style='btn-info']")));
        dp.selectByContainsVisibleText("Consultant");

        driver.findElement(By.id("terms")).click();
        driver.findElement(By.id("signInBtn")).click();

        //-------------------------- Cart ---------------------------------
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Checkout")));

        List<WebElement> list= driver.findElements(By.xpath("//div[@class='card-footer']//button"));
        for(WebElement product: list){
            //wait.until(ExpectedConditions.elementToBeClickable(product));
            product.click();
        }

        driver.findElement(By.xpath("//a[@class='nav-link btn btn-primary']")).click();

        driver.quit();

    }
}
