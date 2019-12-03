/*
 * main.java.pages.addresses;
 *
 * Version 1.0
 *
 * 09.11.2019
 *
 * Copyright: Made by Volodymyr Zyhmund
 */

package main.java.test.volodya;

// Additional packages
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import main.java.helperinstrument.LogInHelper;
import main.java.pages.addresses.Addresses;
import main.java.pages.user.UserPage;
import main.java.test.BasicTest;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

// Listeners are waiting for the error and if it occurs - make a screenshot of error page
@Listeners(BasicTest.class)

// Create2Addresses class
public class VerifyAddressData extends BasicTest {

    // Severity and description for Allure report
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that address body data contains expected data")
    @Test
    public void verifyAddressData() {
        // Arrange
        // Log In to PrestaShop
        UserPage userPage = new LogInHelper().getUserPage();

        // Act
        // Click 'Addresses' card-link
        Addresses addresses = new UserPage().getUserPageContainer().clickAddresses();

        // Assert
        // Verify, that there are 2 addresses on the 'Your addresses' page
        String actualAllFieldsAddress = new Addresses().getAddressesContainer().get(0).getAllFieldsAddress().getText();
        String expectedAllFieldsAddress = "Marta";
        Assert.assertTrue(actualAllFieldsAddress.contains(expectedAllFieldsAddress));
    }

}