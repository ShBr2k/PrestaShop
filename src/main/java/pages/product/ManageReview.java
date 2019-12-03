package main.java.pages.product;

import io.qameta.allure.Step;
import main.java.tools.OurWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

/**
 *
 */
public class ManageReview {

    private WebElement modalWindow;
    private WebElement createRating;
    private WebElement updateRating;
    private WebElement editTitle;
    private WebElement editDetails;
    private WebElement createButton;
    private WebElement updateButton;
    private WebElement cancelButton;

    /**
     * Default constructor
     */
    public ManageReview(boolean isNewReview, String rating, String textTitleReview, String textDetailReview) {
        if (isNewReview) {
            createReview(rating, textTitleReview, textDetailReview);
        } else {
            updateReview(rating, textTitleReview, textDetailReview);
        }
    }


    private void initReview() {
        modalWindow = OurWebDriver.driver.findElement(By.xpath("//div[@role='document'][@tabindex='-1']"));
        cancelButton = OurWebDriver.driver.findElement(By.xpath("//button[@class]/span[contains(text(),'Cancel')]"));
    }


    private void initButtonsCreateReview(String rating) {
        createRating = OurWebDriver.driver.findElement(By.xpath("//div[@class='revws-grading']/div[@class='revws-grade-wrap'][" + rating + "]"));
        createButton = OurWebDriver.driver.findElement(By.xpath("//button[@class]/span[contains(text(),'Create review')]"));
    }


    private void initButtonsUpdateReview(String rating) {
        updateRating = OurWebDriver.driver.findElement(By.xpath("//div[@class='revws-grading']/div[@class='revws-grade-wrap'][" + rating + "]"));
        updateButton = OurWebDriver.driver.findElement(By.xpath("//button[@class]/span[contains(text(),'Update review')]"));
    }


    private void initEditsReview() {
        editTitle = OurWebDriver.driver.findElement(By.xpath("//input[@id='title']"));
        editDetails = OurWebDriver.driver.findElement(By.xpath("//textarea[@placeholder]"));
    }


    @Step("Create first review")
    private void createReview(String rating, String textTitleReview, String textDetailReview) {
        initReview();

        initButtonsCreateReview(rating);

        createRating(); //5

        initEditsReview();

        writeTitleReview(textTitleReview);
        writeDetailsReview(textDetailReview);

        clickCreateButton();

        OurWebDriver.getWait().until(ExpectedConditions.stalenessOf(modalWindow));
        OurWebDriver.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Step("Update existing review")
    private void updateReview(String rating, String textTitleReview, String textDetailReview) {
        initReview();
        initButtonsUpdateReview(rating);

        updateRating(); //3

        initEditsReview();

        writeTitleReview(textTitleReview);
        writeDetailsReview(textDetailReview);

        clickUpdateButton();

        OurWebDriver.getWait().until(ExpectedConditions.stalenessOf(modalWindow));//visibilityOfElementLocated(By.xpath("//a[contains(text(), 'Reviews')]")));
        OurWebDriver.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }


    private void createRating() {
        createRating.click();
    }


    private void updateRating() {
        updateRating.click();
    }


    private void writeTitleReview(String textTitleReview) {
        editTitle.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        editTitle.sendKeys(textTitleReview);
    }


    private void writeDetailsReview(String textDetailReview) {
        editDetails.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        editDetails.sendKeys(textDetailReview);
    }


    private void clickCreateButton() {
        createButton.click();
    }


    private void clickUpdateButton() {
        updateButton.click();
    }


    private void clickButtonCancel() {
        cancelButton.click();
    }

}