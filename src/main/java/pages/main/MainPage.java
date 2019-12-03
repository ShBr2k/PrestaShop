package main.java.pages.main;

import io.qameta.allure.Step;
import main.java.pages.common.ParentPage;
import main.java.pages.login.LoginPage;

/**
 *describes home page
 */
public class MainPage extends ParentPage {

    /**
     * fields
     */
    private PopularProducts popularProducts;

    /**
     * Default constructor
     */
    public MainPage() {
        super();
        initPopularProducts();
    }

    /**
     * fields Popular Product composition
     */
    private void initPopularProducts() {
        popularProducts = new PopularProducts();
    }

    /**
     * getters
     */
    public PopularProducts getPopularProducts() {
        return popularProducts;
    }

    @Step("Clicking at 'sign in' button to get new LoginPage")
    public LoginPage clickSignIn() {
        return initHeaderFull().getLogUserInformation().getUnloggedUserInfo().clickSignInHeaderFull();
    }

    @Step("Clicking at 'sign out' button")
    public void signOut() {
        initHeaderFull().getLogUserInformation().getLogUserInfo().clickSignOut();
    }


}