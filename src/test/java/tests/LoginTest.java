package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void validLogin() {

        LoginPage login = new LoginPage(getDriver());
        login.login("standard_user", "secret_sauce");

        Assert.assertTrue(
                getDriver().getCurrentUrl().contains("inventory"),
                "Login failed - Inventory page not loaded"
        );
    }
}