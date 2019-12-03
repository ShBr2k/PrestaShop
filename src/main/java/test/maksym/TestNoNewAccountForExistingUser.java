package main.java.test.maksym;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import main.java.data.User;
import main.java.data.UserRepository;
import main.java.pages.main.MainPage;
import main.java.pages.register.RegisterPage;
import main.java.test.BasicTest;
import main.java.tools.OurWebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static main.java.helperinstrument.PageNavigationHelper.openRegisterPage;

@Listeners(BasicTest.class)
public class TestNoNewAccountForExistingUser extends BasicTest {

    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that new account can not be created for existing user")
    @Test
    public void TestNoNewAccountForExistingUser() throws InterruptedException {

        // ******* ARRANGE *******

        // Get existing User Maria
        UserRepository userRepository = new UserRepository();
        User user = userRepository.getMaria();

        // go to register page using helper
        RegisterPage registerPage = openRegisterPage();

        // ******* ACT *******

        // Try to create new account with existing User's email. Check appropriate error message
        try {
            MainPage mainPageUserRegistered = registerPage
                    .createAccountFor(user);
        } catch (Exception e) {
            WebElement errorMessage = OurWebDriver.driver.findElementByCssSelector(".alert");

        // ******* ASSERT *******

            Assert.assertTrue(errorMessage.getText().contains("The email is already used"));
        }
    }
}

