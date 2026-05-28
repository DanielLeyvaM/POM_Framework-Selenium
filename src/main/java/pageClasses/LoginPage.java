package pageClasses;

import org.openqa.selenium.By;
import basePage.BasePage;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    //------------------ Using PageFactory Design Pattern --------------------
    //-- Creates WebElements that are not useful for locators "By"

    //---------------------- Attributes ----------------------
//    WebDriver driver;
//
//    //By email = By.id("Email");
//    @FindBy(id="Email")
//    WebElement emailInput;
//
//    @FindBy(id="Password")
//    WebElement passwordInput;
//
//    @FindBy(name="RememberMe")
//    WebElement rememberCheckbox;
//
//    @FindBy(xpath="//input[@value='Log in']")
//    WebElement loginButton;

    //Multiple Elements code:      = findElements
    //FindBy(xpath="//input[@value='Log in']")
    //List <WebElement> listName;

    //---------------------- Constructor ----------------------
//    public LoginPage(WebDriver driver){
//        super(driver);
//        this.driver=driver;
//        PageFactory.initElements(driver,this);              //Init Elements in PageFactory !Important
//    }

    //---------------------- Methods ----------------------
//    public void doLogin(String email, String password){
//        emailInput.sendKeys(email);
//        passwordInput.sendKeys(password);
//        rememberCheckbox.click();
//        loginButton.click();
//    }


    //------------------------------ REFACTORING ----------------------------
    public LoginPage(WebDriver driver){
        super(driver);
    }

    private final By emailInput = By.id("Email");
    private final By passwordInput = By.id("Password");
    private final By rememberCheckbox = By.id("RememberMe");
    private final By loginButton = By.xpath("//input[@value='Log in']");


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

    public ProductsPage clickLogin(){
        driver.findElement(loginButton).click();
        return new ProductsPage(driver);
    }


    public ProductsPage doLogin(String email, String password){
        enterEmail(email)
                .enterPassword(password)
                .clickRememberMeCheckbox()
                .clickLogin();
        return new ProductsPage(driver);
    }
}
