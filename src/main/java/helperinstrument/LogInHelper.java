package main.java.helperinstrument;


import main.java.data.UserRepository;
import main.java.pages.header.LogUserInformation;
import main.java.pages.user.UserPage;


/**
 * class LogInHelper  has method that opens logIn form, pass credentials. and
 */
public class LogInHelper {
    //  private  UserPage userPage;
    private UserPage userPage;


    public LogInHelper() { initLogUserInfo (); }

    public void initLogUserInfo() {

        userPage = new LogUserInformation()
                .getUnloggedUserInfo()
                .clickSignInHeaderFull()
                .getLoginForm()
                .logIn( new UserRepository().getAdmin ().getEmail (), new UserRepository ().getAdmin ().getPassword () );
    }

    public UserPage getUserPage() {
        return userPage;
    }
}

