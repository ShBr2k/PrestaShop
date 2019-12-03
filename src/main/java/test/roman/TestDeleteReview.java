package main.java.test.roman;


import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

import main.java.pages.header.LogCont;
import main.java.pages.product.ProductTabs;
import main.java.tools.OurWebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import main.java.helperinstrument.LogInHelper;
import main.java.helperinstrument.ProductPageHelper;
import main.java.test.BasicTest;

import java.util.concurrent.TimeUnit;

@Listeners(BasicTest.class)


public class TestDeleteReview extends BasicTest {

    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify deleting of existing reviews")
    @Test
    public void testDeleteReview() {

        OurWebDriver.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement buttonCreateReview;

        new LogInHelper();
        new LogCont().goToMainPage();

        ProductTabs productTabs = new ProductPageHelper().getProductTabs();

        productTabs
                .clickReviewTab()
                .initReviewInfo()
                .clickButtonDeleteReview()
                .clickButtonDeleteConfirm();

        // Test deleted review
        buttonCreateReview = productTabs.clickReviewTab().initReviews().getButtonCreateReview();
        Assert.assertTrue(buttonCreateReview.isDisplayed());

    }

}