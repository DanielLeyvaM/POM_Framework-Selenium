package pageObjects;

import commonUtilities.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Utilities {

    //------------------ Using PageFactory Design Pattern --------------------
    //-- Creates WebElements that are not useful for locators "By"

    //---------------------- Attributes ----------------------
    WebDriver driver;

    //By email = By.id("Email");
    @FindBy(id="Email")
    WebElement emailInput;

    @FindBy(id="Password")
    WebElement passwordInput;

    @FindBy(name="RememberMe")
    WebElement rememberCheckbox;

    @FindBy(xpath="//input[@value='Log in']")
    WebElement loginButton;

    //Multiple Elements code:      = findElements
    //FindBy(xpath="//input[@value='Log in']")
    //List <WebElement> listName;

    //---------------------- Constructor ----------------------
    public LoginPage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);              //Init Elements in PageFactory !Important
    }

    //---------------------- Methods ----------------------
    public void doLogin(String email, String password){
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        rememberCheckbox.click();
        loginButton.click();
    }

}
