package testCases;

import baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageClasses.LoginPage;
import pageClasses.MainPage;

public class LoginTest extends BaseTest {
    @Test
    public void loginValidCredentials(){
        //------------------------ Main Page -----------------------
        MainPage mainPage = new MainPage(driver);
        mainPage.openUrl()
                .clickLogin();

        //----------------------- Login Page --------------------------
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("test-email@gmail.com")
                //.enterPassword("password")
                .enterPassword("password11")            //Failing test
                .clickLogin();

        Assert.assertEquals( mainPage.validateLoginText(), "test-email@gmail.com");
    }

    @Test
    public void loginInvalidEmail(){
        //------------------------ Main Page -----------------------
        MainPage mainPage = new MainPage(driver);
        mainPage.openUrl()
                .clickLogin();

        //----------------------- Login Page --------------------------
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("unexistant@gmail.com")
                .enterPassword("password")
                .clickLogin();

        Assert.assertEquals( loginPage.validateSpecificErrorMessage(), "No customer account found");
    }

    @Test
    public void loginInvalidPassword(){
        //------------------------ Main Page -----------------------
        MainPage mainPage = new MainPage(driver);
        mainPage.openUrl()
                .clickLogin();

        //----------------------- Login Page --------------------------
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("test-email@gmail.com")
                .enterPassword("wrong-password")
                .clickLogin();

        Assert.assertEquals( loginPage.validateSpecificErrorMessage(), "The credentials provided are incorrect");
    }

}