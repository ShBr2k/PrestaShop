package main.java.pages.main;

import io.qameta.allure.Step;
import main.java.pages.search.Product;
import main.java.pages.search.SearchPage;
import main.java.tools.OurWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 *Class that describes composition of main page and includes list of products
 */
public class PopularProducts {

    /**
     * List with product items, uses class Product from package search (it`s the same class we use in main page)
     */
    private List<Product> products;

    /**
     * fields
     */
    private WebElement allProducts;

    /**
     * Default constructor uses init method for initialization of fields
     */
    public PopularProducts() {
        initPopularProducts();
    }

    /**
     * method for initialization of fields
     */
    private void initPopularProducts() {
        allProducts = OurWebDriver.driver.findElement(By.cssSelector
                (".all-product-link.float-xs-left.float-md-right.h4"));
        products = new ArrayList<Product>();
        for (WebElement current : OurWebDriver.driver.findElements(By.cssSelector(".thumbnail-container"))) {
            products.add(new Product(current));
        }
    }

    /**
     * getters
     */
    public List<Product> getProducts() {
        return products;
    }

    public WebElement getAllProducts() {
        return allProducts;
    }

    /**
     * Method shows text on top of container Popular Products
     * @return
     */
    @Step("shows text of all products")
    public String showTextOfAllProducts(){
     return  getAllProducts().getText();
    }
    /**
     * method to get product by part of name
     * @return product item
     */
    @Step("Search product by part of name at popular products")
    public Product getProductByPartialName(String partialProductName) {
        Product result = null;
        for (Product current : getProducts()) {
            if (current.getNameProductText().toLowerCase()
                    .contains(partialProductName.toLowerCase())) {
                result = current;
                break;
            }
        }
        return result;
    }


    /**
     * Go to search page
     * @return SearchPage
     */
    public SearchPage clickAllProducts(){
        allProducts.click();
        return new SearchPage();
    }
}
