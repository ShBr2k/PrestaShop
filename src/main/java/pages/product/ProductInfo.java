package main.java.pages.product;

import io.qameta.allure.Step;
import main.java.tools.OurWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 *
 */
public class ProductInfo {

    /**
     * fields
     */
    private WebElement addToCartButton;

    /**
     * Default constructor
     */

    public ProductInfo() {
        initProductInfo();
    }

    /**
     * init field Cart Button
     */
    public void initProductInfo() {
        addToCartButton = OurWebDriver.driver.findElement(By.cssSelector(".btn.btn-primary.add-to-cart"));
    }

    /**
     * getters
     */

    public WebElement getAddToCartButton() {
        return addToCartButton;
    }

    /**
     * click Cart Button and move to AddedToCart class
     */
    @Step("Click at add cart button")
    public AddedToCart setAddToCartButtonClick() {
        addToCartButton.click();
        return new AddedToCart();
    }
}


