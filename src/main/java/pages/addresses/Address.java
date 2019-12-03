/*
 * main.java.pages.addresses;
 *
 * Version 1.0
 *
 * 09.11.2019
 *
 * Copyright: Made by Volodymyr Zyhmund
 */

package main.java.pages.addresses;

// Additional packages
import io.qameta.allure.Step;
import main.java.tools.OurWebDriver;
import org.openqa.selenium.WebElement;

// Address class
public class Address {

    // Fields
    private WebElement addressContainer;
    private WebElement alias;
    private WebElement allFieldsAddress;
    private WebElement updateButton;
    private WebElement deleteButton;

    // Default constructor
    public Address(WebElement addressContainer) {
        this.addressContainer = addressContainer;
        initAddress();
        alias();
    }

    // Locators
    @Step("Initialize single address container")
    private void initAddress() {
        addressContainer = OurWebDriver.driver.findElementByXPath("//section[@id='content']/div");
        alias = OurWebDriver.driver.findElementByXPath("//section[@id='main']/section/div/article/div/h4");
        allFieldsAddress = OurWebDriver.driver
                .findElementByXPath("//section[@id='main']/section/div/article/div/address");
        updateButton = OurWebDriver.driver.findElementByCssSelector(".address-footer>a:nth-child(1)");
        deleteButton = OurWebDriver.driver.findElementByCssSelector(".address-footer>a:nth-child(2)");
    }

    // Initialise 'alias'
    @Step("Initialize 'alias'")
    private void alias() {
        alias = OurWebDriver.driver.findElementByXPath("//section[@id='main']/section/div/article/div/h4");
    }

    // Getters
    @Step("Return 'Alias'")
    public WebElement getAlias() { return alias; }

    @Step("Return 'Address body'")
    public WebElement getAllFieldsAddress() { return allFieldsAddress; }

    // Click 'Update' button
    @Step("Click 'Update' button")
    public Addresses clickUpdate() {
        updateButton.click();
        return new Addresses();
    }

    // Click 'Delete' button
    @Step("Click 'Delete' button")
    public Addresses clickDelete() {
        deleteButton.click();
        return new Addresses();
    }
}