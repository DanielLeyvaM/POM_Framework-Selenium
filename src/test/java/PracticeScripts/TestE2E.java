package PracticeScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class TestE2E {

    @Test
    public void login() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\DANIEL\\Documents\\Java\\Selenium\\1-Drivers\\chromedriver.exe");
        WebDriver driver= new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demowebshop.tricentis.com/");


        //------------------ Login -------------------
        driver.findElement(By.xpath("//a[@href='/login']")).click();

        driver.findElement(By.id("Email")).sendKeys("test-email@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("password");
        driver.findElement(By.name("RememberMe")).click();

        driver.findElement(By.xpath("//input[@value='Log in']")).click();


        //--------------------- Navigate to section ------------------------
        List<WebElement> menu= driver.findElements(By.xpath("//ul[@class='top-menu']/li"));
        for(WebElement li : menu){
            System.out.println(li.getText());
            if(li.getText().trim().equalsIgnoreCase("Apparel & Shoes") ){
                li.click();
                break;
            }
        }

        //--------------------- Add item to cart ----------------------------
        List<WebElement> items= driver.findElements(By.xpath("//div[@class='item-box']//h2//a"));
        for(WebElement product : items){
            System.out.println(product.getText());
            if(product.getText().equalsIgnoreCase("Blue Jeans") ){
                product.click();
                break;
            }
        }

        driver.findElement(By.className("add-to-cart-button")).click();
        System.out.println( driver.findElement(By.xpath("//div[@id='bar-notification']/p")).getText() );


        //----------------------- Cart section -----------------------------
        driver.findElement(By.className("cart-label")).click();
        List <WebElement> cartList= driver.findElements(By.xpath("//td[@class='product']/a"));
        for (WebElement cartProduct : cartList){
            if(cartProduct.getText().equalsIgnoreCase("Blue Jeans")){
                System.out.println("Found Product in cart list");
            }
        }
    }


}
