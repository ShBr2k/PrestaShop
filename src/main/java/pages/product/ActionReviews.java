package main.java.pages.product;

import io.qameta.allure.Step;
import main.java.tools.OurWebDriver;
import org.openqa.selenium.By;


public class ActionReviews {


    public ActionReviews() {
        initAction();
    }

    @Step("Init action of review. Logic in action")
    private void initAction() {

        if (OurWebDriver.driver.findElements(By.xpath("//a[@class='btn btn-primary'][contains(text(),'Be the first to write a review!')]")).size() != 0) {
            initReviews();
        }
        if (OurWebDriver.driver.findElements(By.xpath("//div[@class='revws-review-list']")).size() != 0) {
            initReviewInfo();
        }
    }

    @Step("Init class of first review")
    public Reviews initReviews() {
        return new Reviews();
    }

    @Step("Init class of existing reviews")
    public ReviewInfo initReviewInfo() {
        return new ReviewInfo();
    }

}




