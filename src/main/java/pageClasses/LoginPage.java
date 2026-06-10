package pageClasses;

import org.openqa.selenium.By;
import basePage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    //---------------------- Attributes ----------------------
    //-- Login Section
    private final By loginButton = By.xpath("//input[@value='Log in']");
    private final By emailInput = By.id("Email");
    private final By passwordInput = By.id("Password");
    private final By rememberCheckbox = By.id("RememberMe");

    //-- Error messages
    private final By errorMessage= By.xpath("//div[@class='validation-summary-errors']//li");

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

    public String validateSpecificErrorMessage(){
        longWait.until(ExpectedConditions.presenceOfElementLocated(errorMessage));
        return driver.findElement(errorMessage).getText();
    }
}