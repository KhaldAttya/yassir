package web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends WebBasePage {
    public LoginPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "user-name")
    WebElement userNameField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(id = "login-button")
    WebElement loginButton;

    @FindBy(xpath = "//*[contains(text(),'Epic sadface: Sorry, this user has been locked out.')]")
    WebElement lockedUserError;

    @FindBy(xpath = "//*[contains(text(),'Epic sadface: Username and password do not match any user in this service')]")
    WebElement wrongUserPasswordError;

    public void enterUserName(String userName){
        userNameField.sendKeys(userName);
    }
    public void enterPassword(String password){
        passwordField.sendKeys(password);
    }

    public void clickLogin(){
        loginButton.click();
    }

    public void verifyLockedUserError(){
        waitForElement(lockedUserError);
    }

    public void verifyWrongUsernameOrPasswordError(){
        waitForElement(wrongUserPasswordError);
    }

}
