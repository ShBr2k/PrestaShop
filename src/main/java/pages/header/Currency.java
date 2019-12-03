
package main.java.pages.header;

import io.qameta.allure.Step;
import main.java.tools.OurWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


/**
 * Class Currency, allows to change currency for UAH, EUR, USD.
 */
public class Currency {


    /**
     * locator for currencyElement webElement
     */
    private final By currencyElementLocator = By.cssSelector("#currency-selector-label");

    /**
     * locator for certainItem webElement
     */
    private final By certainItemLocator =
            By.xpath("//*[@id='_desktop_currency_selector']/div/button/span");


    /**
     * locator for EUR webElement
     */
    private final By EURLocator = By.xpath("//*[@id='_desktop_currency_selector']/div/ul/li[1]/a");

    /**
     * locator for UAH webElement
     */
    private final By UAHLocator = By.xpath("//*[@id='_desktop_currency_selector']/div/ul/li[2]/a");

    /**
     * locator for USD webElement
     */
    private final By USDLocator = By.xpath("//*[@id='_desktop_currency_selector']/div/ul/li[3]/a");

    /**
     * Constructor with CurrencyItem field
     */
    public Currency() {
        initCurrency();
    }

    public void initCurrency() {
        getCurrencyItem();
    }

    /**
     * getter to currencyItem field
     */

    public WebElement getCurrencyItem() {
        return OurWebDriver.driver.findElement(certainItemLocator);
    }

    /**
     * Method shows value of the currency item.
     *
     * @return value of the item.
     */

    @Step("shows value of the currency item ")
    public String showValueOfTheCurrencyItem() {
        OurWebDriver.getWait().until(ExpectedConditions.elementToBeClickable(certainItemLocator));
        return getCurrencyItem().getText();
    }

    /**
     * getter to currencyElement field
     */
    public WebElement getCurrencyElement() {

        return OurWebDriver.driver.findElement(currencyElementLocator);
    }

    /**
     * Method opens dropDown list od currency items.
     *
     * @return new Currenc
     */
    @Step("click on currency item on the horizontal menu")

    public Currency openDropDownList() {
        clickCertainItem();
        return new Currency();
    }

    /**
     * method clicks to the certain item on the horizontal menu.
     */
    @Step("click open dropDown list")
    private void clickCertainItem() {

        getCurrencyItem().click();
    }

    /**
     * getter to EUR field
     */
    public WebElement getEUR() {
        return OurWebDriver.driver.findElement(EURLocator);
    }

    /**
     * getter to UAH field
     */
    public WebElement getUAH() {
        return OurWebDriver.driver.findElement(UAHLocator);
    }

    /**
     * getter to USD field
     */
    public WebElement getUSD() {
        return OurWebDriver.driver.findElement(USDLocator);
    }


    /**
     * method clicks on the EUR webElement in dropDown list
     */
    private void clickEUR() {
        getEUR().click();
    }

    /**
     * method clicks on the UAH webElement in dropDown list
     */
    private void clickUAH() {
        getUAH().click();
    }

    /**
     * method clicks on the USD webElement in dropDown list
     */
    private void clickUSD() {
        getUSD().click();
    }

    /**
     * Method uses openDropDownList and clickEUR() to choose EUR from the dropDown list.
     *
     * @return new instance of Currency.
     */
    @Step("choose EUR in list")
    public Currency chooseEUR() {
        openDropDownList();
        clickEUR();
        return new Currency();
    }

    /**
     * Method uses openDropDownList and clickUSD() to choose USD from the dropDown list.
     *
     * @return new instance of Currency.
     */
    @Step("choose USD in dropDown")
    public Currency chooseUSD() {
        openDropDownList();
        clickUSD();
        return new Currency();
    }

    /**
     * Method uses openDropDownList and clickUAH  to choose UAH from the dropDown list.
     *
     * @return new instance of Currency.
     */

    @Step("choose UAH in the list")
    public Currency chooseUAH() {
        openDropDownList();
        clickUAH();
        return new Currency();
    }
}
