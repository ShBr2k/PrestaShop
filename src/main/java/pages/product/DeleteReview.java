package main.java.pages.product;

import io.qameta.allure.Step;
import main.java.tools.OurWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DeleteReview {

    private WebElement buttonDelete;
    private WebElement buttonCancel;


    public DeleteReview() {
        initDeleteReview();
    }


    private void initDeleteReview() {
        buttonDelete = OurWebDriver.driver.findElement(By.xpath("//button[@type='button']//span[contains(text(),'Delete review')]"));
        buttonCancel = OurWebDriver.driver.findElement(By.xpath("//button[@type='button']//span[contains(text(),'Cancel')]"));
    }


    public Reviews clickButtonDeleteConfirm() {
        buttonDelete.click();
        return new Reviews();
    }

    @Step("Confirm to delete review")
    public void clickButtonCancelConfirm() {
        buttonCancel.click();
    }

}
