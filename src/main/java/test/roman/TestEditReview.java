package main.java.test.roman;


import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

import main.java.pages.header.LogCont;
import main.java.pages.product.ProductTabs;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import main.java.helperinstrument.LogInHelper;
import main.java.helperinstrument.ProductPageHelper;
import main.java.test.BasicTest;

@Listeners(BasicTest.class)


public class TestEditReview extends BasicTest {

    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify updating of existing review")
    @Test
    public void testEditReview() {

        String updateRating = "2";
        String updateReviewTitle = "Update title";
        String updateReviewDetail = "Update detail";

        new LogInHelper();
        new LogCont().goToMainPage();

        ProductTabs productTabs = new ProductPageHelper().getProductTabs();

        int amountReview = productTabs.getAmountReview();


        // Test amount amountProductReview
        int expectedAmountReview = 1;
        int actualAmountReview = amountReview;
        Assert.assertEquals(expectedAmountReview, actualAmountReview);
        System.out.println("Expected amount of reviews: " + expectedAmountReview);
        System.out.println("Actual amount of reviews: " + actualAmountReview);

        productTabs
                .clickReviewTab()
                .initReviewInfo()
                .clickButtonEditReview(false, updateRating, updateReviewTitle, updateReviewDetail);


        // Test ReviewTitleText
        String actualReviewTitleText = productTabs.clickReviewTab().initReviewInfo().getReviewTitleText();
        String expectedReviewTitleText = updateReviewTitle;
        Assert.assertEquals(expectedReviewTitleText, actualReviewTitleText);
        System.out.println("\nExpected title text reviews: " + expectedReviewTitleText);
        System.out.println("Actual title text reviews: " + actualReviewTitleText);

        // Test ReviewDetailText
        String actualReviewDetailText = productTabs.clickReviewTab().initReviewInfo().getReviewDetailText();
        String expectedReviewDetailText = updateReviewDetail;
        Assert.assertEquals(expectedReviewDetailText, actualReviewDetailText);
        System.out.println("\nExpected detail text reviews: " + expectedReviewDetailText);
        System.out.println("Actual detail text reviews: " + actualReviewDetailText);

    }

}