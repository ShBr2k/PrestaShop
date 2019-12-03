package main.java.pages.product;

import io.qameta.allure.Step;
import main.java.tools.OurWebDriver;
import main.java.tools.RegexUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 *
 */
public class ProductTabs {

    private WebElement descriptionTab;
    private WebElement productDetailTab;
    private WebElement reviewTab;
    private int amountReview;

    /**
     * Default constructor
     */
    public ProductTabs() {
        initProductTabs();
    }


    @Step("Init tree tabs of product main tab")
    private void initProductTabs() {
        descriptionTab = OurWebDriver.driver.findElement(By.xpath("//a[contains(text(), 'Description')]"));
        productDetailTab = OurWebDriver.driver.findElement(By.xpath("//a[contains(text(), 'Product Details')]"));
        reviewTab = OurWebDriver.driver.findElement(By.xpath("//a[contains(text(), 'Reviews')]"));
    }


    @Step("Get amount of review")
    public int getAmountReview() {
        amountReview = RegexUtils.getNumber(reviewTab.getText());
        return amountReview;
    }


    @Step("Go to review tab")
    public ActionReviews clickReviewTab() {
        reviewTab.click();
        return new ActionReviews();
    }

}