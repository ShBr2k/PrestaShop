package main.java.pages.header;


import io.qameta.allure.Step;
import main.java.tools.OurWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * CertainLanguage allows to find language and nearby arrow buttons, to open dropDown list of languages,
 * to choose one from the list.
 */
public class CertainLanguage {

    /**
     * locator that contains address of language field in DOM
     */
    private final By languageLocator = By.xpath("//div[@id='_desktop_language_selector']//span[@class='expand-more']");


    /**
     * locator that contains address of arrow field in DOM
     */
    private final By arrowLocator = By.xpath(
            "//div[@id='_desktop_language_selector']//i[@class='material-icons expand-more']");

    /**
     * locator that contains address of english field in dropDownList in DOM
     */
    private final By englishLocator = By.xpath("//ul[@class='dropdown-menu hidden-sm-down']//a[@data-iso-code='en']");

    /**
     * locator that contains address of ukrainian field in dropDownList in DOM
     */
    private final By ukrainianLocator = By.xpath("//ul[@class='dropdown-menu hidden-sm-down']//a[@data-iso-code='uk']");

    /**
     * locator that contains address of dropDownListLanguage field in DOM
     */
    private final By dropDownListLanguageLocator = By.xpath(
            "//div[@class='language-selector dropdown js-dropdown open']//ul[@class='dropdown-menu hidden-sm-down']");

    /**
     * constructor with method initCertainLanguage that bring up language and arrow values.
     */
    public CertainLanguage() {
        initCertainLanguage();
    }

    /**
     * Method that bring up language and arrow values
     */
    public void initCertainLanguage() {
        getLanguage();
        getArrow();
    }

    /**
     * method puts locator to the field language;
     *
     * @return language webElement.
     */
    public WebElement getLanguage() {

        return OurWebDriver.driver.findElement(languageLocator);
    }

    /**
     * method make click on language and opens dropDownList
     *
     * @return instance of CertainLanguage
     */
    @Step("open list of languages")
    public CertainLanguage openListOfLanguages() {
        getLanguage().click();
        return new CertainLanguage();
    }


    /**
     * method puts locator the field arrow;
     *
     * @return arrow.
     */
    public WebElement getArrow() {
        return OurWebDriver.driver.findElement(arrowLocator);
    }

    /**
     * method opens dropDown list of languages;
     */
    public void clickLanguageArrow() {
        getArrow().click();
    }

    /**
     * method puts locator to the field english;
     *
     * @return english webElement.
     */
    public WebElement getEnglish() {
        return OurWebDriver.driver.findElement(englishLocator);
    }

    /**
     * method find english webElement in dropDown list!
     * find only when arrow is pressed.
     *
     * @return language webElement.
     */
    @Step("choose English language in dropDown")
    public CertainLanguage chooseEnglishInDropDown() {
        getEnglish().click();
        return new CertainLanguage();
    }

    /**
     * method puts webElement value to the field ukrainian;
     *
     * @return ukrainian webElement.
     */
    public WebElement getUkrainian() {
        return OurWebDriver.driver.findElement(ukrainianLocator);
    }

    /**
     * method find ukrainian webElement in dropDown list!
     * find only when arrow is pressed.
     *
     * @return language webElement.
     */
    @Step("choose ukrainian language in dropDown")
    public HeaderFull chooseUkrainianInDropDown() {
        getUkrainian().click();
        return new HeaderFull();
    }

    @Step("shows content of the language element")
    public String showContentOfTheLanguageElement(){
        return getLanguage().getText();
    }

    /**
     * method puts webElement value to the dropDown list of Languages;
     *
     * @return dropDown element.
     */
    public WebElement getDropDownListLanguage() {
        return OurWebDriver.driver.findElement(dropDownListLanguageLocator);
    }

}

