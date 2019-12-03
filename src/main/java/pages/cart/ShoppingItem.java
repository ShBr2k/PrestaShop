package main.java.pages.cart;

import io.qameta.allure.Step;
import main.java.pages.product.ProductPage;
import main.java.tools.OurWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

/**
 * describes one product item in cart
 */
public class ShoppingItem {

    /**
     * container of one item
     */
    private WebElement shoppingItemContainer;

    /**
     * fields
     */
    private WebElement name;
    private WebElement increaseQuantity;
    private WebElement decreaseQuantity;
    private WebElement price;
    private WebElement totalPrice;
    private WebElement basket;
    private WebElement quantity;

    /**
     * constructor
     */
    public ShoppingItem(WebElement shoppingItemContainer) {
        initShoppingItem();
    }

    /**
     * initialization of variables
     */
    private void initShoppingItem () {
        name = OurWebDriver.driver.findElement(By.cssSelector(".product-line-info>.label"));
        increaseQuantity = OurWebDriver.driver.findElement(By.cssSelector(".material-icons.touchspin-up"));
        decreaseQuantity = OurWebDriver.driver.findElement(By.cssSelector(".material-icons.touchspin-down"));
        price = OurWebDriver.driver.findElement(By.cssSelector(".current-price>.price"));
        totalPrice = OurWebDriver.driver.findElement(By.cssSelector(".col-md-6.col-xs-2.price>.product-price"));
        basket = OurWebDriver.driver.findElement(By.cssSelector(".material-icons.float-xs-left"));
        quantity = OurWebDriver.driver.findElement(By.cssSelector(".js-cart-line-product-quantity.form-control"));
    }

    /**
     * getters
     */
    public WebElement getShoppingItemContainer() {
        return shoppingItemContainer;
    }

    public WebElement getName() {
        return name;
    }

    public WebElement getIncreaseQuantity() {
        return increaseQuantity;
    }

    public WebElement getDecreaseQuantity() {
        return decreaseQuantity;
    }

    public WebElement getPrice() {
        return price;
    }

    public WebElement getTotalPrice() {
        return totalPrice;
    }

    public WebElement getBasket() {
        return basket;
    }

    public WebElement getQuantity() {
        return quantity;
    }

    /**
     * click increase quantity atomic method
     */
    public void clickIncreaseQuantity() {
        increaseQuantity.click();
    }

    /**
     * click decrease quantity atomic method
     */
    public void clickDecreaseQuantity() {
        decreaseQuantity.click();
    }

    /**
     * increase quantity value
     * using explicitly wait to check the total price
     */
    @Step("Click up arrow to increase quantity of product")
    public void changeValueByIncreasing() {
        OurWebDriver.driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        clickIncreaseQuantity();
        OurWebDriver.getWait().until(ExpectedConditions.stalenessOf(quantity));
        OurWebDriver.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    /**
     * decrease quantity value
     * using explicitly wait to check the total price
     */
    @Step("Click down arrow to decrease quantity of product")
    public void changeValueByDecreasing() {
        OurWebDriver.driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        clickDecreaseQuantity();
        OurWebDriver.getWait().until(ExpectedConditions.stalenessOf(quantity));
        OurWebDriver.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    /**
     * click at name field atomic method
     */
    private void clickName () {
        name.click();
    }

    /**
     * click at basket field atomic method
     */
    protected void clickBasket () {
        basket.click();
    }

    /**
     * click at total price field atomic method
     */
    private void clickTotalPrice () {
        totalPrice.click();
    }

    /**
     * click at quantity field atomic method
     */
    private void quantityClick () {
        quantity.click();
    }

    /**
     * clear quantity field atomic method
     */
    private void quantityClear () {
        quantity.sendKeys(Keys.BACK_SPACE);
    }

    /**
     * get name of product item method
     * @return name of product item
     */
    @Step("Check added item by name")
    public String getNameText () {
       return getName().getText();
    }

    /**
     * get actual price of product item method
     * @return price of product item
     */
    @Step("Get actual price value of product")
    public double getPriceValue() {
        return Double.parseDouble(getPrice().getText().substring(1));
    }

    /**
     * get quantity of product item method
     * @return quantity of product item
     */
    @Step("Get quantity value of product")
    public int getQuantityValue() {
        return Integer.parseInt(quantity.getAttribute("value"));
    }

    /**
     * get total price of one product item method
     * @return total price of product item
     */
    @Step("Verify that total price meets the prerequisites")
    public double getTotalPriceValue () {
        return Double.parseDouble(getTotalPrice().getText().substring(1));
    }

    /**
     * go to Product Page by clicking name of product method
     * @return Product page
     */
    public ProductPage goToProductPageByName() {
        clickName();
        return new ProductPage();
    }

    /**
     * typing value at quantity field method
     * using explicitly wait to check the total price
     * @param value of quantity
     */
    private void quantitySetValue (String value) {
        OurWebDriver.driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        quantity.sendKeys(value);
        OurWebDriver.getWait().until(ExpectedConditions.visibilityOf(quantity));
        OurWebDriver.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    /**
     * change and confirmation value of quantity field method
     * @param value of quantity
     */
    @Step("Clear, set and confirm new value at quantity of selected item")
    public void quantityChangeValue (String value){
        quantityClick();
        quantityClear();
        quantitySetValue(value);
        quantity.sendKeys(Keys.ENTER);
    }
}