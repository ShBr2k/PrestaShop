package main.java.test.maksym;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import main.java.data.User;
import main.java.data.UserRepository;
import main.java.pages.main.MainPage;
import main.java.pages.register.RegisterPage;
import main.java.pages.user.YourPersonalInformationPage;
import main.java.test.BasicTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static main.java.helperinstrument.PageNavigationHelper.openRegisterPage;
import static main.java.helperinstrument.PageNavigationHelper.openYourPersonalInformationPage;

@Listeners(BasicTest.class)
public class TestUserDataIsCorrectAfterAccountCreation extends BasicTest {

    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that all User details were correctly saved after account creation")
    @Test
    public void TestUserDataIsCorrectAfterAccountCreation() throws InterruptedException {

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

        // Open 'Your Personal Information Page'
        YourPersonalInformationPage ypiPage = openYourPersonalInformationPage();

        // ******* ASSERT *******

        // Verification that all user details are as expected
        ypiPage.checkUserDetailsFor(user);
    }
}
