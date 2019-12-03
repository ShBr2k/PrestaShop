/*
 * main.java.pages.addresses;
 *
 * Version 1.0
 *
 * 09.11.2019
 *
 * Copyright: Made by Volodymyr Zyhmund
 */

package main.java.pages.addresses;

// Additional packages
import io.qameta.allure.Step;
import main.java.pages.user.Address;
import main.java.tools.OurWebDriver;
import org.openqa.selenium.WebElement;

// NewAddress class
public class NewAddress {

    // Fields
    private WebElement alias;
    private WebElement firstName;
    private WebElement lastName;
    private WebElement company;
    private WebElement vatNumber;
    private WebElement myAddress;
    private WebElement addressComplement;
    private WebElement zipPostalCode;
    private WebElement city;
    private WebElement country;
    private WebElement phone;
    private WebElement saveButton;

    // Default constructor
    public NewAddress() {
        initNewAddress();
    }

    // Init address locators
    private void initNewAddress() {
        alias = OurWebDriver.driver.findElementByXPath("//section[@id='content']/div/div/form/section/div[1]/div[1]/input");
        firstName = OurWebDriver.driver.findElementByXPath("//section[@id='content']/div/div/form/section/div[2]/div[1]/input");
        lastName = OurWebDriver.driver.findElementByXPath("//section[@id='content']/div/div/form/section/div[3]/div[1]/input");
        company = OurWebDriver.driver.findElementByXPath("//section[@id='content']/div/div/form/section/div[4]/div[1]/input");
        vatNumber = OurWebDriver.driver.findElementByXPath("//section[@id='content']/div/div/form/section/div[5]/div[1]/input");
        myAddress = OurWebDriver.driver.findElementByXPath("//section[@id='content']/div/div/form/section/div[6]/div[1]/input");
        addressComplement = OurWebDriver.driver.findElementByXPath("//section[@id='content']/div/div/form/section/div[7]/div[1]/input");
        zipPostalCode = OurWebDriver.driver.findElementByXPath("//section[@id='content']/div/div/form/section/div[8]/div[1]/input");
        city = OurWebDriver.driver.findElementByXPath("//section[@id='content']/div/div/form/section/div[9]/div[1]/input");
        country = OurWebDriver.driver.findElementByXPath("//section[@id='content']/div/div/form/section/div[10]/div[1]/select");
        phone = OurWebDriver.driver.findElementByXPath("//section[@id='content']/div/div/form/section/div[11]/div[1]/input");
        saveButton = OurWebDriver.driver.findElementByCssSelector("button.btn");
    }

    // Getters and setters
    private WebElement getAlias() { return alias; }
    private WebElement getFirstName() { return firstName; }
    private WebElement getLastName() { return lastName; }
    private WebElement getCompany() { return company; }
    private WebElement getVatNumber() { return vatNumber; }
    private WebElement getMyAddress() { return myAddress; }
    private WebElement getAddressComplement() { return addressComplement; }
    private WebElement getZipPostalCode() { return zipPostalCode; }
    private WebElement getCity() { return city; }
    private WebElement getCountry() { return country; }
    private WebElement getPhone() { return phone; }

    @Step("Clear field(s) on 'New address' page")
    public NewAddress clearField(String ... field) {
        try {

             // Read fields one-by-one from the parameters
            for (String n : field) {
                switch (n) {
                    case ("alias"): alias.clear(); break;
                    case ("firstName"): firstName.clear(); break;
                    case ("lastName"): lastName.clear(); break;
                    case ("company"): company.clear(); break;
                    case ("vatNumber"): vatNumber.clear(); break;
                    case ("myAddress"): myAddress.clear(); break;
                    case ("addressComplement"): addressComplement.clear(); break;
                    case ("zipPostalCode"): zipPostalCode.clear(); break;
                    case ("city"): city.clear(); break;
                    case ("country"): country.clear(); break;
                    case ("phone"): phone.clear(); break;
                    default: System.err.println("\tWrong field is entered!" +
                                " Please, check input clear data and try again!"); break;
                }
            }
        } catch (Exception e) {

             // If there is exception - show it
            System.err.println(e.getMessage());
        }
        return new NewAddress();

    }

    @Step("Fill in field(s) on 'New address' page")
    public NewAddress fillInField(Address address) {
        new NewAddress().getAlias().sendKeys(address.getAlias());
        new NewAddress().getFirstName().sendKeys(address.getFirstName());
        new NewAddress().getLastName().sendKeys(address.getLastName());
        new NewAddress().getCompany().sendKeys(address.getCompany());
        new NewAddress().getVatNumber().sendKeys(address.getVatNumber().toString());
        new NewAddress().getMyAddress().sendKeys(address.getMyAddress());
        new NewAddress().getAddressComplement().sendKeys(address.getAddressComplement());
        new NewAddress().getZipPostalCode().sendKeys(address.getZipPostalCode().toString());
        new NewAddress().getCity().sendKeys(address.getCity());
        new NewAddress().getCountry().sendKeys(address.getCountry());
        new NewAddress().getPhone().sendKeys(address.getPhone().toString());

        return new NewAddress();
    }

    @Step("Click 'SAVE' button")
    public Addresses clickSaveButton() {
        saveButton.click();
        return new Addresses();
    }
}