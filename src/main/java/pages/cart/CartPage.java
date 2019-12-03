package main.java.pages.cart;

import io.qameta.allure.Step;
import main.java.pages.common.ParentPage;
import org.openqa.selenium.NoSuchElementException;

/**
 *describes Cart Page
 */
public class CartPage extends ParentPage {

    /**
     * variable to init Shopping Cart composition
     */
    private ShoppingCart shoppingCart;

    /**
     * Default constructor
     */
    public CartPage() {
        super();
        initShoppingPage();
    }

    /**
     * init Shopping Cart composition method
     */
    public void initShoppingPage() {
        shoppingCart = new ShoppingCart();
    }

    /**
     * init Alert pop-up aggregation method
     * @return
     */
    public AlertMessage getAlertMessage() {
        return new AlertMessage();
    }

    /**
     * getters
     */
    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    /**
     * method that checks present of alert pop-up at Cart Page
     * @return true/false of presents alert pop-up
     */
    @Step("Check thar alert message is present")
    public boolean isAlertMessagePresent() {
        try {
            if (new AlertMessage().getMessage().isDisplayed()) {
                return true;
            } else {
                return false;
            }
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}