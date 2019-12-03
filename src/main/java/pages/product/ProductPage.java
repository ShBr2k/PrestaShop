package main.java.pages.product;

import io.qameta.allure.Step;
import main.java.pages.common.ParentPage;
import main.java.tools.OurWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * class that describes product page
 */
public class ProductPage extends ParentPage {

    /**
     * fields
     */
    private ProductInfo productInfo;

    private By priceLocator = By.xpath("//span[@itemprop='price']");

    /**
     * Default constructor
     */
    public ProductPage() {
        super();
        initProductPage();
    }

    /**
     * initialisation of fields
     */
    public void initProductPage() {
        productInfo = new ProductInfo();
    }

    /**
     * getters
     */
    public ProductInfo getProductInfo() {
        return productInfo;
    }


    //Added by Roman Shamakhin
    @Step("Init main tab of product")
    public ProductTabs initProductTabs() {
        return new ProductTabs();
    }
    //Added by Roman Shamakhin

    /**
     * getter to price element
     *
     * @return price element
     */
    public WebElement getPrice() {
        return OurWebDriver.driver.findElement(priceLocator);
    }

    /**
     * method shows price of the product
     *
     * @return string value.
     */
    public String showPrice() {
        return getPrice().getText();
    }
}