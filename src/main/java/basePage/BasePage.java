package basePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {

    //----------------------- ATTRIBUTES ----------------------------
    protected WebDriver driver;

    protected WebDriverWait shortWait;
    protected WebDriverWait longWait;


    //----------------------- CONSTRUCTOR ----------------------------
    public BasePage(WebDriver driver){
        this.driver=driver;

        shortWait= new WebDriverWait(driver, Duration.ofSeconds(5));
        longWait= new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //----------------------- METHODS ------------------------------
    public void setURL(String endpoint){
        driver.get("https://demowebshop.tricentis.com/"+endpoint);
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

}