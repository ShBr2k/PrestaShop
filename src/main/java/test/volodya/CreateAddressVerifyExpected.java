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
import main.java.data.AddressRepository;
import main.java.pages.addresses.Addresses;
import main.java.pages.user.UserPage;
import main.java.test.BasicTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

// Listeners are waiting for the error and if it occurs - make a screenshot of error page
@Listeners(BasicTest.class)

// CreateAddressVerifyExpected class
public class CreateAddressVerifyExpected extends BasicTest {

    // Severity and description for Allure report
    @Severity(SeverityLevel.MINOR)
    @Description("Verify that new address entry match expected")
    @Test
    public void createAddressVerifyExpected() {
        // Arrange
        // Log In to PrestaShop
        UserPage userPage = new main.java.helperinstrument.LogInHelper().getUserPage();

        // Act
        // Click 'Add new address' card-link
        Addresses addresses = new UserPage().getUserPageContainer().clickAddresses();

        // Assert
        // Verify, that new address alias, is as we expected
        String actualAlias = new Addresses().getAddressesContainer().get(0).getAlias().getText();
        String expectedAlias = new AddressRepository().getAddress1().getAlias();
        assertEquals ( actualAlias, expectedAlias );
    }
}
