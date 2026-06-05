package pageClasses;

import basePage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CartPage extends BasePage {

    //---------------------- Attributes ----------------------
    private final By cartProducts= By.className("product-name");


    //---------------------- Constructor ----------------------
    public CartPage(WebDriver driver){
        super(driver);
    }

    //---------------------- Methods ----------------------
    public String getProductNameInCart(String option){
        longWait.until(ExpectedConditions.presenceOfElementLocated(cartProducts));
        List<WebElement> productList= driver.findElements(cartProducts);

        return getElementFromList(productList, option).getText();
    }
}
