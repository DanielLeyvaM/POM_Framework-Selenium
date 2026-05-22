package PracticeScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class WebFormTest {

    @Test
    public void exercise(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\DANIEL\\Documents\\Java\\Selenium\\1-Drivers\\chromedriver.exe");
        WebDriver driver= new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");

        //------------ TXT INPUT ---------
        driver.findElement(By.id("my-text-id")).sendKeys("Victor Marquez");

        //------------ PASSWORD INPUT ---------
        driver.findElement(By.name("my-password")).sendKeys("Test_password");

        //------------ TXT AREA ---------
        driver.findElement(By.xpath("//textarea[@name='my-textarea']")).sendKeys("Example text...");

        //------------ SELECT DROPDOWN ---------
        WebElement dp_element= driver.findElement(By.cssSelector("select[class='form-select']"));
        Select dropdown= new Select(dp_element);
        dropdown.selectByIndex(2);

        //------------ DATALIST DROPDOWN ---------
//        WebElement dl_element= driver.findElement(By.xpath("//input[@list='my-options']"));
//        Select datalist= new Select(dl_element);
//        datalist.selectByValue("Seattle");

        //------------ FILE INPUT ---------
        driver.findElement(By.name("my-file")).sendKeys("C:\\Users\\DANIEL\\Documents\\Java\\Selenium\\1-Drivers\\TestFile.txt");

        //------------ CHECKBOX ---------
        driver.findElement(By.id("my-check-2")).click();

        //------------ RADIO BUTTON ---------
        driver.findElement(By.id("my-radio-2")).click();

        //------------ COLOR PICKER ---------
        driver.findElement(By.name("my-colors")).sendKeys("#ef3608");

        //------------ DATE PICKER ---------
        driver.findElement(By.name("my-date")).sendKeys("06/05/2026");

        //------------ SUBMIT BUTTON ---------
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        driver.quit();

    }

}
