package main.java.helperinstrument;

import io.qameta.allure.Step;
import main.java.pages.common.ParentPage;
import main.java.pages.login.LoginPage;
import main.java.pages.register.RegisterPage;
import main.java.pages.user.UserPage;
import main.java.pages.user.YourPersonalInformationPage;

/**
 * This helper moves User to navigate needed pages
 */
public class PageNavigationHelper {

    /**
     * Navigate to 'Register new Account' page
     */
    @Step ("Navigating to open 'Register new Account' page")
    public static RegisterPage openRegisterPage() {
        return new ParentPage()
                .initHeaderFull()
                .getLogUserInformation()
                .getUnloggedUserInfo()
                .clickSignInHeaderFull()
                .getLoginForm()
                .noAccountClick();
    }

    /**
     * Navigate to 'LogIn' page
     */
    @Step ("Navigating to open 'LogIn' page")
    public static LoginPage openLoginPage() {
        return new ParentPage()
                .initHeaderFull()
                .getLogUserInformation()
                .getUnloggedUserInfo()
                .clickSignInHeaderFull();
    }

    /**
     * Navigate to 'User' page
     */
    @Step ("Navigating to open 'User' page")
    public static UserPage openUserPage() {
        return new ParentPage()
                .initHeaderFull()
                .getLogUserInformation()
                .getLogUserInfo()
                .clickUserAccount();
    }

    /**
     * Navigate to 'Your Personal Information' page
     */
    @Step ("Navigating to open 'Your Personal Information' page")
    public static YourPersonalInformationPage openYourPersonalInformationPage() {
        return new ParentPage()
                .initHeaderFull()
                .getLogUserInformation()
                .getLogUserInfo()
                .clickUserAccount()
                .getUserPageContainer()
                .clickUserInformation();
    }
}
