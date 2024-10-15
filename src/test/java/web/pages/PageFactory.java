package web.pages;

import org.openqa.selenium.WebDriver;

public class PageFactory {
    private final WebDriver driver;
    public PageFactory(WebDriver driver){
        this.driver=driver;
    }
    public LoginPage loginPage(){
        return new LoginPage(driver);
    }

    public HomePage homePage(){
        return new HomePage(driver);
    }
    public CartPage cartPage(){
        return new CartPage(driver);
    }
}
