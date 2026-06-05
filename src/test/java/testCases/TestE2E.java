package testCases;

import baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageClasses.CartPage;
import pageClasses.MainPage;
import pageClasses.LoginPage;
import pageClasses.ProductsPage;

import java.util.HashMap;

public class TestE2E extends BaseTest {

    //----------------------- Data Provider Object ---------------------------
    @DataProvider
    public Object[][] getDataObject(){
        return new Object[][] {
                //{"test-email@gmail.com", "password", "Apparel & Shoes", "Blue Jeans"},
                {"test-email@gmail.com", "password", "Apparel & Shoes", "No product"},
                {"test-email@gmail.com", "password", "Jewelry", "Black & White Diamond Heart"}
        };
    }

    @Test(dataProvider = "getDataObject")
    public void addSingleProductToCart(String email, String password, String section, String product) {

        //------------------------ Main Page -----------------------
        MainPage mainPage = new MainPage(driver);
        mainPage.openUrl()
                .clickLogin();

        //----------------------- Login Page --------------------------
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail(email)
                 .enterPassword(password)
                 .clickLogin();

        //--------------------- Navigate to section ------------------------
        mainPage.selectMenuOption(section);

        //--------------------- Add item to cart ----------------------------
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.selectProductToBuy(product)
                    .clickAddToCartButton();
        Assert.assertEquals(productsPage.getAddedToCartMessage(), "The product has been added to your shopping cart");

        mainPage.clickCart();

        //----------------------- Cart section -----------------------------
        CartPage cartPage = new CartPage(driver);
        Assert.assertEquals(cartPage.getProductNameInCart(product), product);

    }


    //-------------------------------------------------------------------------


    //------------------------- Data Provider Map -----------------------------
    @DataProvider
    public Object[][] getDataMap(){
        HashMap<String, String > map1= new HashMap<>();
        map1.put("email","test-email@gmail.com");
        map1.put("password","password");
        map1.put("section","Jewelry");
        map1.put("product","Black & White Diamond Heart");

        HashMap<String, String > map2= new HashMap<>();
        map2.put("email","test-email@gmail.com");
        map2.put("password","password");
        map2.put("section","Apparel & Shoes");
        map2.put("product","Blue Jeans");

        return new Object[][] {
                {map1},
                {map2}
        };
    }

    //@Test(dataProvider = "getDataMap")
    public void addSingleProductToCart(HashMap<String,String> map) {
        //------------------ Main Page -------------------
        MainPage mainPage = new MainPage(driver);
        mainPage.openUrl()
                .clickLogin();

        //----------------- Login Page ----------------------
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail(map.get("email"))
                .enterPassword(map.get("password"))
                .clickLogin();

        //--------------------- Navigate to section ------------------------
        mainPage.selectMenuOption(map.get("section"));

        //--------------------- Add item to cart ----------------------------
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.selectProductToBuy(map.get("product"))
                .clickAddToCartButton();
        Assert.assertEquals(productsPage.getAddedToCartMessage(), "The product has been added to your shopping cart");

        mainPage.clickCart();

        //----------------------- Cart section -----------------------------
        CartPage cartPage = new CartPage(driver);
        Assert.assertEquals(cartPage.getProductNameInCart(map.get("product")), map.get("product"));
    }

}