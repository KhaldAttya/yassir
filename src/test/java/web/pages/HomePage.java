package web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends WebBasePage {
    public HomePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath = "//*[@data-test='shopping-cart-link']")
    WebElement shoppingCart;

    public void addToCart(String item){
        WebElement webElement = driver.findElement(By.id("add-to-cart-" + item.toLowerCase().replace(" ", "-")));
        webElement.click();
    }

    public void verifyItemIsAdded(String item){
        WebElement webElement = driver.findElement(By.id("remove-" + item.toLowerCase().replace(" ", "-")));
        waitForElement(webElement);
    }

    public void goToCart(){
        shoppingCart.click();
    }

}
