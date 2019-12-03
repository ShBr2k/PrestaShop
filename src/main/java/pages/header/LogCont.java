package main.java.pages.header;

import io.qameta.allure.Step;
import main.java.pages.main.MainPage;
import main.java.tools.OurWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;



/**
 * Class contains webElement: logo and Contact Us,
 * allows to open main page and contactUs form
 */
public class LogCont {

    /**
     * element 'MyStore' on the pages.Header
     */
    private WebElement logo;

    /**
     * element 'ContactUS' on pages.Header
     */
    private WebElement contactUS;

    /**
     * locator that contains address of logo field in DOM
     */
    private final By logoLocator = By.xpath("//img[@class='logo img-responsive']");

    /**
     * locator that contains address of contactUs field in DOM
     */
    private final By contactUsLocator = By.xpath("//div[@class='row']//div[@id='_desktop_contact_link']");

    /**
     * Default constructor that bring up init method.
     */
    public LogCont() {
        initLogCont();
    }

    /**
     * method that bring up logo and contactUs webElements.
     */
    public void initLogCont() {
        logo = OurWebDriver.driver.findElement(logoLocator);
        contactUS = OurWebDriver.driver.findElement(contactUsLocator);

    }


    /**
     * getter to logo field
     */
    public WebElement getLogo() {
        return logo;
    }

    /**
     * getter to contactUs field
     */
    public WebElement getContactUS() {
        return contactUS;
    }

    /**
     * click logo atomic method
     */
    private void clickLogo() {
        logo.click();
    }

    /**
     * method opens homePage
     */
    @Step("click logo, opens MainPage")
    public MainPage goToMainPage() {
        clickLogo();
        return new MainPage();
    }

    /**
     * method opens Contact Us form  change for method that returns contactUs page
     */
    @Step("click contactUs")

    public void clickContactUS() {
        contactUS.click();
    }
}