package pageObjects;

import commonUtilities.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsPage extends Utilities {

    WebDriver driver;

    By products= By.xpath("//div[@class='item-box']//h2//a");
    By addToCartButton= By.className("add-to-cart-button");

    public ProductsPage(WebDriver driver){
        super(driver);
        this.driver=driver;
    }


    public void selectProductToBuy(String option){
        explicitWait(products);
        List<WebElement> productList= driver.findElements(products);

        getElementFromList(productList, option).click();
    }

    public void clickAddToCartButton(){
        driver.findElement(addToCartButton).click();

        System.out.println( driver.findElement(By.xpath("//div[@id='bar-notification']/p")).getText() );
    }

}
