package pageClasses;

import basePage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LandingPage extends BasePage {

//    //---------------------- Attributes ----------------------
//    WebDriver driver;

    private final By loginLink = By.xpath("//a[@href='/login']");
    private final By cartLink = By.className("cart-label");
    private final By headerMenu = By.xpath("//ul[@class='top-menu']/li");


//    //---------------------- Constructor ----------------------
//    public LandingPage(WebDriver driver){
//        super(driver);
//        this.driver=driver;
//    }

    //---------------------- Methods ----------------------
//    public void clickLogin(){
//        driver.findElement(loginLink).click();
//    }

//    public void selectMenuOption(String option){
//        explicitWait(headerMenu);
//        List<WebElement> menuList= driver.findElements(headerMenu);
//
//        getElementFromList(menuList, option).click();
//    }

//    public void clickCart(){
//        driver.findElement(cartLink).click();
//    }


    //--------------------------------- REFACTORING ---------------------------
    public LandingPage(WebDriver driver){
        super(driver);
    }

    public LandingPage openUrl(){
        setURL("");
        return this;
    }

    public LoginPage clickLogin(){
        driver.findElement(loginLink).click();
        return new LoginPage(driver);
    }

    public CartPage clickCart(){
        driver.findElement(cartLink).click();
        return new CartPage(driver);
    }

    public LandingPage selectMenuOption(String option){
        explicitWaitPresenceOf(headerMenu);
        List<WebElement> menuList= driver.findElements(headerMenu);

        getElementFromList(menuList, option).click();
        return this;
    }

}
