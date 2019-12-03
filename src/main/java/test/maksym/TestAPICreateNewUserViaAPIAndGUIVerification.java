package main.java.test.maksym;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import main.java.data.User;
import main.java.pages.user.UserPage;
import main.java.pages.user.YourPersonalInformationPage;
import main.java.test.BasicTest;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static main.java.helperinstrument.PageNavigationHelper.openLoginPage;
import static main.java.helperinstrument.PageNavigationHelper.openYourPersonalInformationPage;
import static main.java.helperinstrument.UserOperationHelper.*;



@Listeners(BasicTest.class)
public class TestAPICreateNewUserViaAPIAndGUIVerification extends BasicTest {

    @Severity(SeverityLevel.CRITICAL)
    @Description("Create new user and API verification Test")
    @Test
    public void testCreateNewUserApiVerification() throws InterruptedException, JsonProcessingException {

        // ******* ARRANGE *******

        int usersBeforeCreation = GetNumberOfCustomersViaApi();

        // ******* ACT *******

        User newUser = createAccountForNewUniqueUserViaAPI();

        int usersAfterCreation = GetNumberOfCustomersViaApi();

        // ******* ASSERT *******

        Assert.assertNotEquals(usersAfterCreation, usersBeforeCreation, "The amount of users shouldn't be same");

        // Assert that new user may Sign in
        UserPage userPage = openLoginPage()
                .getLoginForm()
                .logIn(newUser.getEmail(), newUser.getPassword());

        // Verification that all user details are as expected
        YourPersonalInformationPage ypiPage = openYourPersonalInformationPage();
        ypiPage.checkUserDetailsFor(newUser);

    }
}
