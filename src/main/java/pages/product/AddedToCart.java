package main.java.pages.product;

import io.qameta.allure.Step;
import main.java.pages.cart.CartPage;
import main.java.tools.OurWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * 
 */
public class AddedToCart {
    /**
     * button proceed to checkout
     */
    private WebElement checkoutButton;
    /**
     * "x" button to close the pop-up
     */
    private WebElement closeAddedToCart;

   // WebDriverWait wait = new WebDriverWait(WebDriver.driver, 5);

    /**
     * Default constructor
     */
    public AddedToCart() {
        initAddedToCart();
    }

    /**
     * initialization method
     */

    public void initAddedToCart () {
        checkoutButton = OurWebDriver.driver.findElement(By.cssSelector(".cart-content-btn>.btn.btn-primary"));
        closeAddedToCart = OurWebDriver.driver.findElement(By.cssSelector(".close"));
    }

    /**
     * getters
     */
    public WebElement getCheckoutButton() {
        return checkoutButton;
    }

    public WebElement getCloseAddedToCart() {
        return closeAddedToCart;
    }

    /**
     *checkout button click method proceed to Cart Page
     */
    @Step("Click checkout button")
    public CartPage clickCheckoutButton () {
        OurWebDriver.getWait().until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector(".cart-content-btn>.btn.btn-primary")));
        checkoutButton.click();
        return new CartPage();
    }

    /**
     *close pop-up Added to Cart method
     */

    public void closeAddedToCartClick () {
        closeAddedToCart.click();
    }

}