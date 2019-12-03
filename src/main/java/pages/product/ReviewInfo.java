package main.java.pages.product;

import io.qameta.allure.Step;
import main.java.tools.OurWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;


/**
 *
 */
public class ReviewInfo {

    private WebElement reviewTitle;
    private WebElement reviewDetail;
    private WebElement editButton;
    private WebElement deleteButton;

    /**
     * Default constructor
     */
    public ReviewInfo() {
        initReviewInfo();
    }


    private void initReviewInfo() {

        reviewTitle = OurWebDriver.driver.findElement(By.xpath("//p[@class='revws-review-title']"));
        reviewDetail = OurWebDriver.driver.findElement(By.xpath("//p[@class='revws-review-content']"));
        editButton = OurWebDriver.driver.findElement(By.xpath("//a[text()='Edit review']"));
        deleteButton = OurWebDriver.driver.findElement(By.xpath("//a[text()='Delete review']"));
    }

    public String getReviewTitleText() {
        return reviewTitle.getText();
    }


    public String getReviewDetailText() {
        return reviewDetail.getText();
    }


    public WebElement getButtonEditReview() {
        return editButton;
    }


    public WebElement getButtonDelete() {
        return deleteButton;
    }


    @Step("Go to manage exist review")
    public ManageReview clickButtonEditReview(boolean isNewReview, String rating, String textTitleReview, String textDetailReview) {
        editButton.click();
        return new ManageReview(isNewReview, rating, textTitleReview, textDetailReview);
    }


    @Step("Go to delete exist review")
    public DeleteReview clickButtonDeleteReview() {
        deleteButton.click();
        return new DeleteReview();
    }

}