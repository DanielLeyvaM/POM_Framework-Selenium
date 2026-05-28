package pageClasses;

import basePage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends BasePage {
    //------------------------ REFACTORING ---------------------------------

    //WebDriver driver;

    private final By cartProducts= By.className("product-name");

    public CartPage(WebDriver driver){
        super(driver);
        this.driver=driver;
    }

    public String getProductNameInCart(String option){
        explicitWaitPresenceOf(cartProducts);
        List<WebElement> productList= driver.findElements(cartProducts);

        return getElementFromList(productList, option).getText();
    }
}
