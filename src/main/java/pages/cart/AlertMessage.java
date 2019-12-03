package main.java.pages.cart;

import io.qameta.allure.Step;
import main.java.tools.OurWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * aggregation of cart page that describes alert pop-up in case of invalid quantity of products in cart
 */
public class AlertMessage {
    /**
     * fields
     */
    private WebElement message;

    /**
     * default constructor
     */
    public AlertMessage() {
        message = OurWebDriver.driver.findElement(By.cssSelector(".alert.alert-danger"));
    }

    /**
     * getters
     */
    @Step("Verify of getting alert message")
    public WebElement getMessage() {
        return message;
    }
}
