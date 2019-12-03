package main.java.test.roman;


import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

import main.java.pages.header.LogCont;
import main.java.pages.product.ProductTabs;
import main.java.tools.OurWebDriver;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import main.java.helperinstrument.LogInHelper;
import main.java.helperinstrument.ProductPageHelper;
import main.java.test.BasicTest;

import java.util.concurrent.TimeUnit;

@Listeners(BasicTest.class)


public class TestAddReview extends BasicTest {

    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify creating of new review")
    @Test
    public void testAddReview() {

        OurWebDriver.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        String newRating = "4";
        String newReviewTitle = "New title";
        String newReviewDetail = "New detail";

        new LogInHelper();
        new LogCont().goToMainPage();

        ProductTabs productTabs = new ProductPageHelper().getProductTabs();

        int amountReview = productTabs.getAmountReview();


        //test amount amountProductReview
        int expectedAmountReview = 0;
        int actualAmountReview = amountReview;
        Assert.assertEquals(expectedAmountReview, actualAmountReview);
        System.out.println("Expected amount of reviews: " + expectedAmountReview);
        System.out.println("Actual amount of reviews: " + actualAmountReview);

        productTabs
                .clickReviewTab()
                .initReviews()
                .clickButtonCreateReview(true, newRating, newReviewTitle, newReviewDetail);


        // Test ReviewTitleText
        String ReviewTitleText = productTabs.clickReviewTab().initReviewInfo().getReviewTitleText();
        String actualReviewTitleText = ReviewTitleText;
        String expectedReviewTitleText = newReviewTitle;
        Assert.assertEquals(expectedReviewTitleText, actualReviewTitleText);
        System.out.println("\nExpected title text reviews: " + expectedReviewTitleText);
        System.out.println("Actual title text reviews: " + actualReviewTitleText);


        // Test ReviewDetailText
        String ReviewDetailText = productTabs.clickReviewTab().initReviewInfo().getReviewDetailText();
        String actualReviewDetailText = ReviewDetailText;
        String expectedReviewDetailText = newReviewDetail;
        Assert.assertEquals(expectedReviewDetailText, actualReviewDetailText);
        System.out.println("\nExpected detail text reviews: " + expectedReviewDetailText);
        System.out.println("Actual detail text reviews: " + actualReviewDetailText);

    }

}