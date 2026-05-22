package pageObjects;

import commonUtilities.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends Utilities {
    WebDriver driver;

    By cartProducts= By.className("product-name");

    public CartPage(WebDriver driver){
        super(driver);
        this.driver=driver;
    }


    public void searchElementInCart(String option){
        explicitWait(cartProducts);
        List<WebElement> productList= driver.findElements(cartProducts);

        System.out.println( getElementFromList(productList, option).getText() );

    }
}
