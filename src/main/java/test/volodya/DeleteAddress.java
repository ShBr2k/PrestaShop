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
import main.java.pages.addresses.AddressesPage;
import main.java.pages.header.CertainLanguage;
import main.java.pages.user.UserPage;
import main.java.test.BasicTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

// Listeners are waiting for the error and if it occurs - make a screenshot of error page
@Listeners(BasicTest.class)

// CreateAddress class
public class DeleteAddress extends BasicTest {

    // Severity and description for Allure report
    @Severity(SeverityLevel.MINOR)
    @Description("Verify that address entry can be deleted")
    @Test
    public void deleteAddress() {
        // Arrange
        // Log In to PrestaShop
        UserPage userPage = new LogInHelper().getUserPage();

        // Change language to English
        CertainLanguage certainLanguage = new CertainLanguage().openListOfLanguages().chooseEnglishInDropDown();

        // Act
        // Click 'Add new address' card-link
        Addresses addresses = new UserPage().getUserPageContainer().clickAddresses();

        // Click 'Delete' button
        System.err.println("\tATTENTION!\n\tDeleting address!_\n");
        Addresses emptyAddressesPage = new AddressesPage().getAddressesList().getAddressesContainer().get(0).clickDelete();

        // Assert
        // Verification, that address was successfully deleted
        String actualAlert = new AddressesPage().getAddressesList().getAlert().getText();
        String expectedAlert = "Address successfully deleted!";
        assertEquals ( actualAlert, expectedAlert );
    }

}
