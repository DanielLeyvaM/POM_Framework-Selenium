package PracticeScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class CheckboxTest {

    @Test
    public void exercise(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\DANIEL\\Documents\\Java\\Selenium\\1-Drivers\\chromedriver.exe");
        WebDriver driver= new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        WebElement chkbox= driver.findElement(By.id("checkBoxOption1"));
        chkbox.click();
        System.out.println("First Checkbox is selected: " +chkbox.isSelected());

        chkbox.click();
        System.out.println("First Checkbox is selected: " +chkbox.isSelected());

        List<WebElement> list= driver.findElements(By.xpath("//div[@id='checkbox-example']//input"));
        System.out.println("Number of Checkboxes: " +list.size());

        driver.quit();

    }
}
