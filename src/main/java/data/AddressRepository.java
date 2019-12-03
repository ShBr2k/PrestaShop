/*
 * main.java.pages.addresses;
 *
 * Version 1.0
 *
 * 09.11.2019
 *
 * Copyright: Made by Volodymyr Zyhmund
 */

package main.java.data;

// Additional packages
import io.qameta.allure.Step;
import main.java.pages.user.Address;
import main.java.test.BasicTest;
import org.testng.annotations.Listeners;

// Listeners are waiting for the error and if it occurs - make a screenshot of error page
@Listeners(BasicTest.class)

// AddressRepository class
public class AddressRepository {

    // Fields
    private static Address address1;
    private static Address address2;

    public AddressRepository() {

        // Repository addresses list for creating new form
        address1 = new Address(
                "My Address",
                "Volodymyr",
                "Zyhmund",
                "SoftServe",
                137778,
                "Lviv region, Lviv, Yaroslav Pasternak Street 5, SoftServe 2",
                "Home",
                79000,
                "Lviv",
                "Ukraine",
                931234567);

        address2 = new Address(
                "My Address Two",
                "Marta",
                "Zyhmund",
                "Private Enterprise",
                13,
                "Home address",
                "...",
                79002,
                "Lviv",
                "Ukraine",
                123456789);
    }

    // Getters
    @Step("Take address1 data from repository")
    public Address getAddress1() { return address1; }

    @Step("Take address2 data from repository")
    public Address getAddress2() { return address2; }
}



