package main.java.helperinstrument;

import main.java.pages.cart.CartPage;
import main.java.pages.main.MainPage;

/**
 * describes reduplication actions of adding product to cart
 */
public class AddToCartHelper {

    /**
     * variable to init path of adding product to cart
     */
    private CartPage cartPage;

    /**
     * default constructor
     */
    public AddToCartHelper() {
        init();
    }

    /**
     * initialisation of path
     */
    public void init () {
        cartPage = new MainPage()
                .getPopularProducts()
                .getProductByPartialName("T-Shirt")
                .goToProductPage()
                .getProductInfo()
                .setAddToCartButtonClick()
                .clickCheckoutButton();
    }

    /**
     * getter
     */
    public CartPage getCartPage() {
        return cartPage;
    }
}
