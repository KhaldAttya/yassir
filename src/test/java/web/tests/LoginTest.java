package web.tests;

import org.testng.annotations.Test;
import web.data.UserCredentials;

public class LoginTest extends WebTestBase {
    @Test()
    public void verifyLockedUserCannotLogin(){
        page.loginPage().enterUserName(UserCredentials.LOCKED_USER.getUsername());
        page.loginPage().enterPassword(configLoader.getProperty("password"));
        page.loginPage().clickLogin();
        page.loginPage().verifyLockedUserError();
    }

    @Test()
    public void verifyValidUserCannotLoginWithWrongPassword(){
        page.loginPage().enterUserName(UserCredentials.STANDARD_USER.getUsername());
        page.loginPage().enterPassword("WrongPassword");
        page.loginPage().clickLogin();
        page.loginPage().verifyWrongUsernameOrPasswordError();
    }
}
