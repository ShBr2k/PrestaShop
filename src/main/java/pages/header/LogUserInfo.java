package main.java.pages.header;

import io.qameta.allure.Step;
import main.java.pages.user.UserPage;
import main.java.tools.OurWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * LogUserInfo is a child class of LogUserInformation,
 * allows to open LogInPage, by pressing signOut and userPage by pressing userAccount.
 */
public class LogUserInfo extends LogUserInformation {

    /**
     * field shows user name
     */
    private String userName;
    /**
     * to sign out from the cabinet
     */
    private WebElement signOut;

    /**
     * shows name of the user on Header
     */
    private WebElement userAccount;

    /**
     * locator that contains address of signOut field in DOM
     */
    private final By signOutLocator = By.xpath("//div[@class='user-info']//a[@class='logout hidden-sm-down']");

    /**
     * locator that contains address of userAccount field in DOM
     */
    private final By userAccountLocator = By.cssSelector("#_desktop_user_info > div > a.account > span");

    /**
     * Default constructor
     */
    public LogUserInfo() {
        initLogUserInfo();
    }

    /**
     * method create put saves locators to fields signOut and userAccount
     */
    public void initLogUserInfo() {
        signOut = OurWebDriver.driver.findElement(signOutLocator);
        userAccount = OurWebDriver.driver.findElement(userAccountLocator);

    }
    /**
     * method create instance of LogUserInfo class;
     * @return instance of LogUserInfo.
     */

    /**
     * Method sign out from the cabinet
     */

    @Step("click signOut button, opens current page")

    public void clickSignOut() {
        signOut.click();
    }

    /**
     * method find signOut element
     */
    @Step("cheeck if button is enable")

    public boolean findSignOut() {
        return signOut.isEnabled();
    }

    /**
     * Method open 'Your Account'
     */
    @Step("click userAccount, opens UserPage")

    public UserPage clickUserAccount() {
        userAccount.click();
        return new UserPage();
    }

    /**
     * method shows User Name
     *
     * @return userAccount
     */
    @Step("shows name of the user")

    public String getUserNameFromHeader() {
        userName = userAccount.getText();
        return userName;
    }
}
