package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

    WebDriver driver;

    @FindBy(xpath = "(//button[text()='Add to cart'])[1]")
    WebElement addToCart;

    @FindBy(className = "shopping_cart_link")
    WebElement cartIcon;

    @FindBy(className = "shopping_cart_badge")
    WebElement cartBadge;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addFirstProductToCart() {
        addToCart.click();
    }

    public void openCart() {
        cartIcon.click();
    }

    public String getCartCount() {
        return cartBadge.getText();
    }
}