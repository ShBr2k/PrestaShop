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
import main.java.pages.common.ParentPage;
import main.java.tools.OurWebDriver;
import org.openqa.selenium.WebElement;

// AddressesPage class, which extends APageParent class
public class AddressesPage extends ParentPage {

    // Fields
    private WebElement homeTopLink;
    private WebElement yourAccountLink;
    private WebElement actualPageName;
    private WebElement backToYourAccountLink;
    private WebElement homeLowerLink;
    private Addresses addressesList;

    // Default constructor
    public AddressesPage() {
        homeTopLink();
        yourAccountLink();
        actualPageName();
        initAddressesList();
        backToYourAccountLink();
        homeLowerLink();
    }

    private void homeTopLink() {
        homeTopLink = OurWebDriver.driver.findElementByXPath("//section[@id='wrapper']/div/nav/ol/li[1]/a/span");
    }

    private void yourAccountLink() {
        yourAccountLink = OurWebDriver.driver.findElementByXPath("//section[@id='wrapper']/div/nav/ol/li[2]/a/span");
    }

    private void actualPageName() {
        actualPageName = OurWebDriver.driver.findElementByXPath("//section[@id='main']/header/h1");
    }

    private void initAddressesList() {
        addressesList = new Addresses();
    }

    private void backToYourAccountLink() {
        backToYourAccountLink = OurWebDriver.driver.findElementByXPath("//section[@id='main']/footer/a[1]");
    }

    private void homeLowerLink() {
        homeLowerLink = OurWebDriver.driver.findElementByXPath("//section[@id='main']/footer/a[2]");
    }

    // Getters
    @Step("Return 'Home' top link")
    public WebElement getHomeTopLink() { return homeTopLink; }

    @Step("Return 'Your account' top link")
    public WebElement getYourAccountLink() { return yourAccountLink; }

    @Step("Return list of addresses")
    public Addresses getAddressesList() { return addressesList; }

    @Step("Return actual page name")
    public WebElement getActualPageName() { return actualPageName; }

    @Step("Return '< Back to your account' link")
    public WebElement getBackToYourAccountLink() { return backToYourAccountLink; }

    @Step("Return '^ Home' link")
    public WebElement getHomeLowerLink() { return homeLowerLink; }

    @Step("Click 'Home' top link")
    public void clickHomeTop() { homeTopLink.click(); }

    @Step("Click 'Your account' link")
    public void clickYourAccount() { yourAccountLink.click(); }

    @Step("Click '< Back to your account' link")
    public void clickBackToYourAccount() { backToYourAccountLink.click(); }

    @Step("Click '^ Home' lower link")
    public void clickHome() { homeLowerLink.click(); }
}