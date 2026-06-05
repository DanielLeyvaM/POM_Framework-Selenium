package pageClasses;

import org.openqa.selenium.By;
import basePage.BasePage;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    //---------------------- Attributes ----------------------
    private final By emailInput = By.id("Email");
    private final By passwordInput = By.id("Password");
    private final By rememberCheckbox = By.id("RememberMe");
    private final By loginButton = By.xpath("//input[@value='Log in']");


    //---------------------- Constructor ----------------------
    public LoginPage(WebDriver driver){
        super(driver);
    }

    //---------------------- Methods ----------------------
    public LoginPage enterEmail(String email){
        driver.findElement(emailInput).sendKeys(email);
        return this;
    }

    public LoginPage enterPassword(String password){
        driver.findElement(passwordInput).sendKeys(password);
        return this;
    }

    public LoginPage clickRememberMeCheckbox(){
        driver.findElement(rememberCheckbox).click();
        return this;
    }

    public void clickLogin(){
        driver.findElement(loginButton).click();
    }

    public void doLogin(String email, String password){
        enterEmail(email)
                .enterPassword(password)
                .clickRememberMeCheckbox()
                .clickLogin();
    }

}