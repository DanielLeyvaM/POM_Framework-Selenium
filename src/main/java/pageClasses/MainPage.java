package pageClasses;

import basePage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class MainPage extends BasePage {

    //---------------------- Attributes ----------------------
    private final By loginLink = By.xpath("//a[@href='/login']");
    private final By cartLink = By.className("cart-label");
    private final By headerMenu = By.xpath("//ul[@class='top-menu']/li");


    //---------------------- Constructor ----------------------
    public MainPage(WebDriver driver){
        super(driver);
    }

    //---------------------- Methods ----------------------
    public MainPage openUrl(){
        setURL("");
        return this;
    }

    public MainPage selectMenuOption(String option){
        longWait.until(ExpectedConditions.presenceOfElementLocated(headerMenu));
        List<WebElement> menuList= driver.findElements(headerMenu);

        getElementFromList(menuList, option).click();
        return this;
    }


    public void clickLogin(){               //Creation of objects in TEST CASES
        driver.findElement(loginLink).click();
    }

    public void clickCart(){
        driver.findElement(cartLink).click();
    }

}