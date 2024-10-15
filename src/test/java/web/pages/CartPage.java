package web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends WebBasePage {
    public CartPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "checkout")
    WebElement checkout;

    @FindBy(id = "continue")
    WebElement continueButton;

    @FindBy(id = "finish")
    WebElement finish;

    @FindBy(id = "first-name")
    WebElement firstNameField;

    @FindBy(id = "last-name")
    WebElement lastNameField;

    @FindBy(id = "postal-code")
    WebElement postalCodeField;

    @FindBy(xpath = "//*[contains(text(),'Thank you for your order!')]")
    WebElement orderSuccess;

    public void clickCheckout(){
        checkout.click();
    }

    public void clickContinue(){
        continueButton.click();
    }

    public void clickFinish(){
        finish.click();
    }

    public void enterUserInfo(String firstName, String lastName, String postalCode){
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        postalCodeField.sendKeys(postalCode);
    }

    public void verifyOrderSuccess(){
        waitForElement(orderSuccess);
    }

}
