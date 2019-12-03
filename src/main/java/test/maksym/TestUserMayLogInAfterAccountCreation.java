package main.java.test.maksym;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import main.java.data.User;
import main.java.data.UserRepository;
import main.java.pages.main.MainPage;
import main.java.pages.register.RegisterPage;
import main.java.pages.user.UserPage;
import main.java.test.BasicTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static main.java.helperinstrument.PageNavigationHelper.openLoginPage;
import static main.java.helperinstrument.PageNavigationHelper.openRegisterPage;
import static org.testng.Assert.assertTrue;

@Listeners(BasicTest.class)
public class TestUserMayLogInAfterAccountCreation extends BasicTest {

    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that user may login after account creation")
    @Test
    public void TestUserMayLogInAfterAccountCreation() throws InterruptedException {

        // ******* ARRANGE *******

        // create unique User
        UserRepository userRepository = new UserRepository();
        User user = userRepository.getUniqueUser();

        // go to register page using helper
        RegisterPage registerPage = openRegisterPage();

        // ******* ACT *******

        // create new account according to Users' details
        MainPage mainPageUserRegistered = registerPage
                .createAccountFor(user);

        // sign out
        mainPageUserRegistered.signOut();

        // Sign in with credentials of the newly created User,
        UserPage userPage = openLoginPage()
                .getLoginForm()
                .logIn(user.getEmail(), user.getPassword());

        // ******* ASSERT *******

        // Assert SignOut button is present on the page, which means User is signed in
        assertTrue(userPage
                        .initHeaderFull()
                        .getLogUserInformation()
                        .getLogUserInfo()
                        .findSignOut()
                , "User is not signed in");

    }
}
