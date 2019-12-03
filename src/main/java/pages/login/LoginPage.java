package main.java.pages.login;

import main.java.pages.common.ParentPage;

/**
 * 
 */
public class LoginPage extends ParentPage {
    /**
     * Default constructor
     */
    public LoginPage() {
        getLoginForm ();
    }
    
    public LoginForm getLoginForm () {
        return new LoginForm ();
    }
}