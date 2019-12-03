package main.java.pages.header;


import io.qameta.allure.Step;
import main.java.pages.searchresult.SearchResultPage;
import main.java.tools.OurWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


/**
 * Class HeaderFull is a child class of pages.Header with it's own fields: clothes, accessories,
 * art, searchField, language, cart, currency, logUserInformation,
 * allows to open each of these pages.
 */
public class HeaderFull extends Header {

    /**
     * locator for searchField
     */
    private final By searchFieldLocator = By.cssSelector(".ui-autocomplete-input");

    /**
     * locator for searchButton
     */
    private final By searchButtonLocator = By.xpath("//button[@type='submit']");

    /**
     * locator for clothes
     */
    private final By clothesLocator = By.cssSelector("#category-3");

    /**
     * constructor with parent constructor and with method initHeaderFull
     */
    public HeaderFull() {
        super();
        initHeaderFull();
    }

    /**
     * method initHeader with getters getCertainLanguage();
     * getCurrency, getSearchField, getSearchButton, getClothes, getLogUserInformation();
     */
    public void initHeaderFull() {
        getCertainLanguage();
        getCurrency();
        getSearchField();
        getSearchButton();
        getClothes();
        getLogUserInformation();
    }


    /**
     * getter for certainLanguage
     * @return CertainLanguage
     */
    public CertainLanguage getCertainLanguage() {
        return new CertainLanguage();
    }

    /**
     * getter for clothes
     * @return webElement clothes
     */
    public WebElement getClothes() {
        return OurWebDriver.driver.findElement(clothesLocator);
    }

    /**
     * getter for searchField
     * @return webElement searchField
     */
    public WebElement getSearchField() {
        return OurWebDriver.driver.findElement(searchFieldLocator);
    }

    /**
     * getter for searchButton
     * @return webElement searchButton
     */
    public WebElement getSearchButton() {
        return OurWebDriver.driver.findElement(searchButtonLocator);
    }

    /**
     * method opens SearchPage
     *
     * @return SearchPage
     */
    @Step("click on search button, opens SearchPage")

    public SearchResultPage searchButtonClick() {
        getSearchButton().click();
        return new SearchResultPage();
    }

    /**
     * method clears SearchField
     * @return new HeaderFull
     */
    @Step("clear searchField")

    public HeaderFull clearSearchField() {
        getSearchField().clear();
        return new HeaderFull();
    }

    /**
     * Method enter text in searchField
     * @param searchingProduct
     * @return
     */
    @Step("entering data into searchField {searchingProduct}")

    public HeaderFull sendKeysToSearchField(String searchingProduct) {

        getSearchField().sendKeys(searchingProduct);
        return new HeaderFull();
    }

    /**
     * getter to cart
     * @return webElement cart
     */
    public WebElement getCart() {
        return OurWebDriver.driver.findElement(By.cssSelector(".header"));
    }

    /**
     * getter to LogUserInformation
     * @return new LogUserInformation
     */
    public LogUserInformation getLogUserInformation() {
        return new LogUserInformation();
    }

    /**
     * getter to Currency
     * @return new Currency
     */
    public Currency getCurrency() {
        return new Currency();
    }
}