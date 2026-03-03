package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SearchPage;

public class SearchTest extends BaseTest {

    @Test
    public void verifyProductSearchAndAddToCart() {

        // Step 1: Login
        LoginPage login = new LoginPage(getDriver());
        login.login("standard_user", "secret_sauce");

        // Verify login successful
        Assert.assertTrue(
                getDriver().getCurrentUrl().contains("inventory"),
                "Login failed - Inventory page not loaded"
        );

        // Step 2: Add first product to cart
        SearchPage search = new SearchPage(getDriver());
        search.addFirstProductToCart();

        // Step 3: Verify cart badge count
        String cartCount = search.getCartCount();

        Assert.assertEquals(cartCount, "1",
                "Product not added to cart successfully");
    }
}