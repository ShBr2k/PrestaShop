package main.java.pages.product;

import io.qameta.allure.Step;
import main.java.tools.OurWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 *
 */
public class Reviews {

    private WebElement buttonCreateReview;

    /**
     * Default constructor
     */
    public Reviews() {
        initReviews();
    }


    private void initReviews() {
        buttonCreateReview = OurWebDriver.driver.findElement(By.xpath("//a[@class='btn btn-primary'][contains(text(),'Be the first to write a review!')]"));
    }


    public WebElement getButtonCreateReview() {
        return buttonCreateReview;
    }


    @Step("Go to manage new review")
    public ManageReview clickButtonCreateReview(boolean isNewReview, String rating, String textTitleReview, String textDetailReview) {
        buttonCreateReview.click();
        return new ManageReview(isNewReview, rating, textTitleReview, textDetailReview);
    }

}