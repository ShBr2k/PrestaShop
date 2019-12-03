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
import main.java.helperinstrument.LogInHelper;
import main.java.pages.addresses.Addresses;
import main.java.pages.addresses.AddressesPage;
import main.java.pages.addresses.NewAddress;
import main.java.pages.header.CertainLanguage;
import main.java.pages.user.Address;
import main.java.pages.user.UserPage;
import main.java.test.BasicTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

// Listeners are waiting for the error and if it occurs - make a screenshot of error page
@Listeners(BasicTest.class)

// CreateAddress class
public class CreateAddress extends BasicTest {

    // Severity and description for Allure report
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that new address entry can be created")
    @Test
    public void createAddress() {
        // Arrange
        // Log In to PrestaShop
        UserPage userPage = new LogInHelper().getUserPage();

        // Change language to English
        CertainLanguage certainLanguage = new CertainLanguage().openListOfLanguages().chooseEnglishInDropDown();

        // Act
        // Click 'Add new address' card-link
        Addresses addresses = new UserPage().getUserPageContainer().clickAddresses();

        // Clear all the fields before filling in
        NewAddress newAddress = new NewAddress().clearField(
                "alias",
                "firstName",
                "lastName",
                "company",
                "vatNumber",
                "myAddress",
                "addressComplement",
                "zipPostalCode",
                "city",
                "phone");

        // Fill in all necessary fields from addresses repository.
        Address address = new AddressRepository().getAddress1();
        NewAddress newAddress1 = new NewAddress().fillInField(address);

        // Click 'SAVE' button
        Addresses addresses1 = new NewAddress().clickSaveButton();

        // Assert
        // Verify alert, that new address was successfully created
        String actualAlert = new AddressesPage().getAddressesList().getAlert().getText();
        String expectedAlert = "Address successfully added!";
        assertEquals ( actualAlert, expectedAlert, "Actual alert [ actualAlert ] did not match expected [ expectedAlert ]");
    }

}
