package testCases;

import baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageClasses.CartPage;
import pageClasses.LoginPage;
import pageClasses.MainPage;
import pageClasses.ProductsPage;

public class AddProductsTest extends BaseTest {

    @Test
    public void addSingleProductToCart() {
        String section= "Apparel & Shoes";
        String product= "Blue Jeans";

        //------------------------ Main Page -----------------------
        MainPage mainPage = new MainPage(driver);
        mainPage.openUrl()
                .clickLogin();

        //----------------------- Login Page --------------------------
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("test-email@gmail.com")
                .enterPassword("password")
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

    @Test
    public void addMultipleProductsToCart() {
        String section= "Apparel & Shoes";

        String product1= "Blue Jeans";
        String product2= "Casual Golf Belt";

        //------------------------ Main Page -----------------------
        MainPage mainPage = new MainPage(driver);
        mainPage.openUrl()
                .clickLogin();

        //----------------------- Login Page --------------------------
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("test-email@gmail.com")
                .enterPassword("password")
                .clickLogin();

        //--------------------- Navigate to section ------------------------
        mainPage.selectMenuOption(section);

        //--------------------- Add multiples items to cart ----------------------------
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.clickMultipleAddToCart(product1,product2);

        mainPage.clickCart();

        //----------------------- Cart section -----------------------------
        CartPage cartPage = new CartPage(driver);
        Assert.assertEquals(cartPage.getProductNameInCart(product1), product1);
        Assert.assertEquals(cartPage.getProductNameInCart(product2), product2);

    }
}
