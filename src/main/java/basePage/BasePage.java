package basePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class BasePage {

//    WebDriver driver;
//
//    public CommonFunctions(WebDriver driver){
//        this.driver= driver;
//    }

    public void explicitWaitPresenceOf(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }


    public WebElement getElementFromList(List<WebElement> list, String option){
        for(WebElement li : list){
            //System.out.println(li.getText());
            if( li.getText().equalsIgnoreCase(option) ){
                return li;
            }
        }
        return null;
    }


    //---------------------------- REFACTORING ----------------------------
    protected WebDriver driver;

    protected WebDriverWait shortWait;
    protected WebDriverWait longWait;

    public BasePage(WebDriver driver){
        this.driver=driver;

        shortWait= new WebDriverWait(driver, Duration.ofSeconds(10));
        longWait= new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void setURL(String endpoint){
        driver.get("https://demowebshop.tricentis.com/"+endpoint);
    }

}
