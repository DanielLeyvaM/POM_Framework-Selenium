package testCases;

import baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageClasses.CartPage;
import pageClasses.LandingPage;
import pageClasses.LoginPage;
import pageClasses.ProductsPage;

import java.io.IOException;
import java.util.HashMap;


public class TestE2E extends BaseTest {

    //----------------------- Data Provider Object ---------------------------
    @DataProvider
    public Object[][] getDataObject(){
        return new Object[][] {
                {"test-email@gmail.com", "password", "Apparel & Shoes", "Blue Jeans"},
                //{"test-email@gmail.com", "password", "Apparel & Shoes", "No product"},
                {"test-email@gmail.com", "password", "Jewelry", "Black & White Diamond Heart"}
        };
    }

//    @Test(dataProvider = "getDataObject")
//    public void addSingleProductToCart(String email, String password, String section, String product) {

//        driver.get("https://demowebshop.tricentis.com/");

//        //------------------ Landing Page -------------------
//        LandingPage mainPage= new LandingPage(driver);
//        mainPage.clickLogin();
//
//        //----------------- Login Page ----------------------
//        LoginPage login= new LoginPage(driver);
//        login.doLogin(email, password);
//
//        //--------------------- Navigate to section ------------------------
//        //mainPage.selectMenuOption("Apparel & Shoes");
//        mainPage.selectMenuOption(section);
//
//        //--------------------- Add item to cart ----------------------------
//        ProductsPage productP= new ProductsPage(driver);
//        //productP.selectProductToBuy("Blue Jeans");
//        productP.selectProductToBuy(product);
//
//        productP.clickAddToCartButton();
//        mainPage.clickCart();
//
//        //----------------------- Cart section -----------------------------
//        CartPage cart= new CartPage(driver);
//        //cart.searchElementInCart("Blue Jeans");
//        cart.searchElementInCart(product);
//    }


    @Test(dataProvider = "getDataObject")
    public void addSingleProductToCart(String email, String password, String section, String product) {
        //------------------------------- REFACTORING --------------------------
        //LoginData loginData= new LoginData(email,password);
        //ProductData productData= new ProductData(section,product);

        LandingPage landingObj= new LandingPage(driver);
        landingObj.openUrl();

        LoginPage loginObj= landingObj.clickLogin();

        loginObj.enterEmail(email)
                .enterPassword(password)
                .clickRememberMeCheckbox();

        ProductsPage productsObj= loginObj.clickLogin();

        landingObj.selectMenuOption(section);

        productsObj.selectProductToBuy(product)
                    .clickAddToCartButton();
        Assert.assertEquals(productsObj.getAddedToCartMessage(), "The product has been added to your shopping cart");

        CartPage cartObj= landingObj.clickCart();
        Assert.assertEquals(cartObj.getProductNameInCart(product),product);

    }




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
    public void addSingleProductToCart(HashMap<String,String> map) throws IOException {

        //------------------ Landing Page -------------------
//        LandingPage mainPage= new LandingPage(driver);
//        mainPage.clickLogin();
//
//        //----------------- Login Page ----------------------
//        LoginPage login= new LoginPage(driver);
//        login.doLogin(map.get("email"),map.get("password") );
//
//        //--------------------- Navigate to section ------------------------
//        //mainPage.selectMenuOption("Apparel & Shoes");
//        mainPage.selectMenuOption(map.get("section"));
//
//        //--------------------- Add item to cart ----------------------------
//        ProductsPage productP= new ProductsPage(driver);
//        //productP.selectProductToBuy("Blue Jeans");
//        productP.selectProductToBuy(map.get("product"));
//
//        productP.clickAddToCartButton();
//        mainPage.clickCart();
//
//        //----------------------- Cart section -----------------------------
//        CartPage cart= new CartPage(driver);
//        //cart.searchElementInCart("Blue Jeans");
//        cart.searchElementInCart(map.get("product"));

    }

}