package commonUtilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public abstract class Utilities {

    WebDriver driver;

    public Utilities(WebDriver driver){
        this.driver= driver;
    }


    public void explicitWait(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public WebElement getElementFromList(List<WebElement> list, String option){
        for(WebElement li : list){
            System.out.println(li.getText());
            if( li.getText().equalsIgnoreCase(option) ){
                return li;
            }
        }
        return null;
    }

}
