package main.java.pages.cart;

import io.qameta.allure.Step;
import main.java.tools.OurWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 *describes list of product items and elements in composition to Cart Page
 */
public class ShoppingCart {

    /**
     * fields and list of product items
     */
    private WebElement continueShoppingButton;
    private List<ShoppingItem> shoppingItemsList;

    /**
     * Default constructor
     */
    public ShoppingCart() {
        initShoppingCart();
    }

    /**
     * initialization method
     */
    private void initShoppingCart() {
        continueShoppingButton = OurWebDriver.driver.findElement(By.cssSelector(".cart-grid-body>.label"));
        initShoppingItemsList();
    }

    /**
     * init of product items list
     */
    private void initShoppingItemsList() {
        shoppingItemsList = new ArrayList<ShoppingItem>();
        for (WebElement current : OurWebDriver.driver.findElements(By.cssSelector(".cart-item"))) {
            shoppingItemsList.add(new ShoppingItem(current));
        }
    }

    /**
     * getters
     */
    public WebElement getContinueShoppingButton() {
        return continueShoppingButton;
    }

    public List<ShoppingItem> getShoppingItemsList() {
        initShoppingItemsList();  //refreshing item list to have actual data
        return shoppingItemsList;
    }

    /**
     * click continue shopping method
     */
    private void clickContinueShoppingButton() {
        continueShoppingButton.click();
    }

    /**
     * deleting all product items from cart method
     * using explicitly wait to check that all items was deleted
     */
    @Step("Click basket to all product items")
    public void deleteAllFromCart() {
        OurWebDriver.driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        for (ShoppingItem current : shoppingItemsList) {
            if (current.getBasket().isEnabled()) {
                current.clickBasket();
            } else {
                break;
            }
        }
        OurWebDriver.getWait().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".no-items")));
        OurWebDriver.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
}
