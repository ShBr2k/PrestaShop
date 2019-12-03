package main.java.pages.search;

import io.qameta.allure.Step;
import main.java.pages.product.ProductPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 *Class that describes one container of product
 */
public class Product {

    /**
     * container of one product
     */
    private WebElement productContainer;

    /**
     * name of product
     */
    private WebElement name;

    /**
     * price of product
     */
    private float price;

    /**
     *constructor with
     * @param productContainer
     */
    public Product(WebElement productContainer) {
        initProduct(productContainer);
    }

    /**
     * method to init product fields
     */

    private void initProduct(WebElement productContainer) {
        this.productContainer = productContainer;
        name = productContainer.findElement(By.cssSelector(".h3.product-title>a"));

        //get price
        WebElement priceElement = productContainer.findElement(By.cssSelector("span.price"));
        String priceString = priceElement.getText();
        priceString = priceString.substring(1,priceString.length()-1);
        price = Float.parseFloat(priceString);
    }

    /**
     * getters
     */
    public WebElement getProductContainer() {
        return productContainer;
    }
    public WebElement getName() {
        return name;
    }

    /**
     * atomic click at name method
     */
    private void clickName () {
        name.click();
    }

    /**
     * get name in String format
     * @return name of product
     */
    public String getNameProductText () {
        return getName().getText();
    }

    /**
     * get price of product
     * @return int price
     */
    public float getProductPrice(){return price;}

    /**
     * click name and go to Product Page
     * @return Product Page
     */
    @Step("Go to Product page by clicking at product name")
    public ProductPage goToProductPage() {
        clickName();
        return new ProductPage();
    }
}