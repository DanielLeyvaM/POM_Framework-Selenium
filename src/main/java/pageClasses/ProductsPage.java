package pageClasses;

import basePage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ProductsPage extends BasePage {

    //--------------------------- Attributes ---------------------------------
    private final By products= By.xpath("//div[@class='item-box']//h2//a");
    private final By addToCartButton= By.className("add-to-cart-button");
    private final By addedToCartMessage= By.xpath("//div[@id='bar-notification']/p");


    //------------------------ Constructor --------------------------------
    public ProductsPage(WebDriver driver){
        super(driver);
    }

    //---------------------- Methods ----------------------
    public ProductsPage selectProductToBuy(String option){
        longWait.until(ExpectedConditions.presenceOfElementLocated(products));
        List<WebElement> productList= driver.findElements(products);

        getElementFromList(productList, option).click();
        return this;
    }

    public String getAddedToCartMessage(){                  //Assertion helper
        longWait.until(ExpectedConditions.presenceOfElementLocated(addedToCartMessage));
        return driver.findElement(addedToCartMessage).getText();
    }

    public ProductsPage clickAddToCartButton(){
        driver.findElement(addToCartButton).click();
        return this;
    }

}