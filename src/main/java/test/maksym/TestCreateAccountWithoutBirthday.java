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
import static org.testng.Assert.assertTrue;

@Listeners(BasicTest.class)
public class TestCreateAccountWithoutBirthday extends BasicTest {

    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that new account can be created without setting user's birthday")
    @Test
    public void TestCreateAccountWithoutBirthday() throws InterruptedException {


        // ******* ARRANGE *******

        // create unique User and remove birthday data from it
        UserRepository userRepository = new UserRepository();
        User user = userRepository.getUniqueUser();
        user.setBirthday("");

        // go to register page using helper
        RegisterPage registerPage = openRegisterPage();

        // ******* ACT *******

        // create new account according to Users' details
        MainPage mainPageUserRegistered = registerPage
                .createAccountFor(user);

        // ******* ASSERT *******

        // Assert SignOut button is present on the page, which means User is signed in
        assertTrue(mainPageUserRegistered
                        .initHeaderFull()
                        .getLogUserInformation()
                        .getLogUserInfo()
                        .findSignOut()
                , "User is not signed in");
    }
}
