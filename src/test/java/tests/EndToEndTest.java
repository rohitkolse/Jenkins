package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.OrderConfirmationPage;
import pages.SearchPage;

public class EndToEndTest extends BaseTest {

    @Test
    public void completeOrderFlow() {

        // Login
        LoginPage login = new LoginPage(getDriver());
        login.login("standard_user", "secret_sauce");

        // Add product
        SearchPage search = new SearchPage(getDriver());
        search.addFirstProductToCart();
        search.openCart();

        // Checkout
        CartPage cart = new CartPage(getDriver());
        cart.clickCheckout();

        CheckoutPage checkout = new CheckoutPage(getDriver());
        checkout.enterDetails("Rohit", "Kolse", "411001");
        checkout.finishOrder();

        // Confirmation
        OrderConfirmationPage confirm =
                new OrderConfirmationPage(getDriver());

        Assert.assertTrue(confirm.isOrderSuccessful(),
                "Order was not completed successfully");
    }
}