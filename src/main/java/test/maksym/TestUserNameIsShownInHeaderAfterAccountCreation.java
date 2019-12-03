package main.java.test.maksym;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import main.java.data.User;
import main.java.data.UserRepository;
import main.java.pages.main.MainPage;
import main.java.pages.register.RegisterPage;
import main.java.test.BasicTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static main.java.helperinstrument.PageNavigationHelper.openRegisterPage;
import static org.testng.Assert.assertEquals;

@Listeners(BasicTest.class)
public class TestUserNameIsShownInHeaderAfterAccountCreation extends BasicTest {

    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that immediately after new user creation, User's name is shown in the header")
    @Test
    public void TestUserNameIsShownInHeaderAfterAccountCreation() throws InterruptedException {

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

        // ******* ASSERT *******

        // actual User name from the Page's header
        String userNameAtTheHeader = mainPageUserRegistered
                .initHeaderFull()
                .getLogUserInformation()
                .getLogUserInfo()
                .getUserNameFromHeader();

        // expected User name
        String userNameFromObjectUser = user.getFirstName() + " " + user.getLastName();

        assertEquals(userNameAtTheHeader, userNameFromObjectUser,
                "Expected user FirstName, LastName are not found in the main page's header after the User was created");
    }
}
