package web.tests;

import org.testng.annotations.Test;
import web.data.UserCredentials;

public class OrderJourneyTest extends WebTestBase {
    @Test()
    public void verifyUserCanMakeSuccessfulOrder(){
        page.loginPage().enterUserName(UserCredentials.STANDARD_USER.getUsername());
        page.loginPage().enterPassword(configLoader.getProperty("password"));
        page.loginPage().clickLogin();
        page.homePage().addToCart("Sauce Labs Backpack");
        page.homePage().verifyItemIsAdded("Sauce Labs Backpack");
        page.homePage().goToCart();
        page.cartPage().clickCheckout();
        page.cartPage().enterUserInfo("Khaled","Attia","11235");
        page.cartPage().clickContinue();
        page.cartPage().clickFinish();
        page.cartPage().verifyOrderSuccess();
    }

}
