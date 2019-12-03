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

// EditAddress class
public class EditAddress extends BasicTest {

    // Severity and description for Allure report
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that address entry can be updated")
    @Test
    public void editAddress() {
        // Arrange
        // Log In to PrestaShop
        UserPage userPage = new LogInHelper().getUserPage();

        // Change language to English
        CertainLanguage certainLanguage = new CertainLanguage().openListOfLanguages().chooseEnglishInDropDown();

        // Act
        // Click 'Addresses' card-link
        Addresses addresses = new UserPage().getUserPageContainer().clickAddresses();

        // Press 'Update' button on the 1st item and return Addresses page
        System.err.println("\tATTENTION!\n\tUpdating address!_\n");
        Addresses addresses1 = new AddressesPage().getAddressesList().getAddressesContainer().get(0).clickUpdate();

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

        // Fill in all required fields from addresses repository from create address2.
        Address address = new AddressRepository().getAddress2();
        NewAddress newAddress2 = new NewAddress().fillInField(address);

        // Click 'SAVE' button
        Addresses addresses2 = new NewAddress().clickSaveButton();

        // Assert
        // Verification, that address was successfully updated
        String actualAlert = new Addresses().getAlert().getText();
        String expectedAlert = "Address successfully updated!";
        assertEquals ( actualAlert, expectedAlert );
    }

}
