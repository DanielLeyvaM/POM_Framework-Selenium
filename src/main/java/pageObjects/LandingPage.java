package pageObjects;

import commonUtilities.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LandingPage extends Utilities {

    //----------------------- Using dataType By -----------------------

    //---------------------- Attributes ----------------------
    WebDriver driver;

    By loginLink = By.xpath("//a[@href='/login']");
    By cartLink = By.className("cart-label");
    By headerMenu = By.xpath("//ul[@class='top-menu']/li");


    //---------------------- Constructor ----------------------
    public LandingPage(WebDriver driver){
        super(driver);
        this.driver=driver;
    }

    //---------------------- Methods ----------------------
    public void clickLogin(){
        driver.findElement(loginLink).click();
    }

    public void selectMenuOption(String option){
        explicitWait(headerMenu);
        List<WebElement> menuList= driver.findElements(headerMenu);

        getElementFromList(menuList, option).click();
    }

    public void clickCart(){
        driver.findElement(cartLink).click();
    }
}
