/*
 * main.java.pages.addresses;
 *
 * Version 1.0
 *
 * 09.11.2019
 *
 * Copyright: Made by Volodymyr Zyhmund
 */

package main.java.pages.user;

import io.qameta.allure.Step;
import main.java.test.BasicTest;
import org.testng.annotations.Listeners;

// Listeners are waiting for the error and if it occurs - make a screenshot of error page
@Listeners(BasicTest.class)

// Address class
public class Address {

    // Fields
    private String alias;
    private String firstName;
    private String lastName;
    private String company;
    private Integer vatNumber;
    private String myAddress;
    private String addressComplement;
    private Integer zipPostalCode;
    private String city;
    private String country;
    private Integer phone;

    // Default empty method
    public Address(){}

    // Default constructor
    public Address(String alias,
                   String firstName,
                   String lastName,
                   String company,
                   Integer vatNumber,
                   String myAddress,
                   String addressComplement,
                   Integer zipPostalCode,
                   String city,
                   String country,
                   Integer phone) {

        this.alias = alias;
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
        this.vatNumber = vatNumber;
        this.myAddress = myAddress;
        this.addressComplement = addressComplement;
        this.zipPostalCode = zipPostalCode;
        this.city = city;
        this.country = country;
        this.phone = phone;
    }

    // Getters
    @Step("Fill in 'Alias' field")
    public String getAlias() {
        return alias;
    }

    @Step("Fill in 'First name' field")
    public String getFirstName() {
        return firstName;
    }

    @Step("Fill in 'Last name' field")
    public String getLastName() {
        return lastName;
    }

    @Step("Fill in 'Company' field")
    public String getCompany() {
        return company;
    }

    @Step("Fill in 'VAT number' field")
    public Integer getVatNumber() { return vatNumber; }

    @Step("Fill in 'Address' field")
    public String getMyAddress() {
        return myAddress;
    }

    @Step("Fill in 'Address Complement' field")
    public String getAddressComplement() {
        return addressComplement;
    }

    @Step("Fill in 'Zip/Postal Code' field")
    public Integer getZipPostalCode() {
        return zipPostalCode;
    }

    @Step("Fill in 'City' field")
    public String getCity() {
        return city;
    }

    @Step("Fill in 'Country' field")
    public String getCountry() {
        return country;
    }

    @Step("Fill in 'Phone' field")
    public Integer getPhone() {
        return phone;
    }

    // Override
    @Override
    public String toString() { return super.toString(); }
}
