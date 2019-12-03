package main.java.pages.user;

import io.qameta.allure.Step;
import main.java.data.Title;
import main.java.data.User;
import main.java.pages.header.HeaderFull;
import main.java.tools.OurWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.assertTrue;


public class YourPersonalInformationPage extends HeaderFull {

    private WebDriver driver = OurWebDriver.driver;

    private WebElement titleMr;
    private WebElement titleMrs;
    private WebElement firstName;
    private WebElement lastName;
    private WebElement email;
    private WebElement password;
    private WebElement newPassword;
    private WebElement birthday;
    private WebElement checkboxReceiveOffers;
    private WebElement checkboxSignUpNewsletter;
    private WebElement checkboxIAgree;
    private WebElement buttonSave;


    /**
     * Default constructor
     */
    public YourPersonalInformationPage() {
        initRegisterForm();
    }

    private void initRegisterForm() {
        this.titleMr = driver.findElement(By.cssSelector("input[name='id_gender'][value='1']"));
        this.titleMrs = driver.findElement(By.cssSelector("input[name='id_gender'][value='2']"));
        this.firstName = driver.findElement(By.cssSelector("input[name='firstname']"));
        this.lastName = driver.findElement(By.cssSelector("input[name='lastname']"));
        this.email = driver.findElement(By.cssSelector("input[name='email']"));
        this.password = driver.findElement(By.cssSelector("input[name='password']"));
        this.newPassword = driver.findElement(By.cssSelector("input[name='new_password']"));
        this.birthday = driver.findElement(By.cssSelector("input[name='birthday']"));
        this.checkboxReceiveOffers = driver.findElement(By.cssSelector("input[name='optin']"));
        this.checkboxSignUpNewsletter = driver.findElement(By.cssSelector("input[name='newsletter']"));
        this.checkboxIAgree = driver.findElement(By.cssSelector("input[name='psgdpr']"));
        this.buttonSave = driver.findElement(By.cssSelector("button.btn-primary"));
    }


    // Setters & getters

    public void setTitleMr() {
        titleMr.click();
    }

    public void setTitleMrs() {
        titleMrs.click();
    }

    public void selectCheckboxReceiveOffers() {
        if (!checkboxReceiveOffers.isSelected()) {
            checkboxReceiveOffers.click();
        }
    }

    public void unselectCheckboxReceiveOffers() {
        if (checkboxReceiveOffers.isSelected()) {
            checkboxReceiveOffers.click();
        }
    }

    public void selectCheckboxSignUpNewsletter() {
        if (!checkboxSignUpNewsletter.isSelected()) {
            checkboxSignUpNewsletter.click();
        }
    }

    public void unselectCheckboxSignUpNewsletter() {
        if (checkboxSignUpNewsletter.isSelected()) {
            checkboxSignUpNewsletter.click();
        }
    }

    public void selectCheckboxIAgree() {
        checkboxIAgree.click();
    }

    public String getFirstNameValue() {
        return firstName.getAttribute("value");
    }

    public void setFirstNameValue(String text) {
        firstName.sendKeys(text);
    }

    public String getLastNameValue() {
        return lastName.getAttribute("value");
    }

    public void setLastNameValue(String text) {
        lastName.sendKeys(text);
    }

    public String getEmailValue() {
        return email.getAttribute("value");
    }

    public void setEmailValue(String text) {
        email.sendKeys(text);
    }

    public void setPasswordValue(String text) {
        password.sendKeys(text);
        newPassword.sendKeys(text);
    }

    public String getBirthdayValue() {
        return birthday.getAttribute("value");
    }

    public void setBirthdayValue(String text) {
        birthday.sendKeys(text);
    }

    public Boolean isTitleMrSelected() {
        Boolean result = false;
        if (titleMr.isSelected()) {
            result = true;
        }
        return result;
    }

    public Boolean isTitleMrsSelected() {
        Boolean result = false;
        if (titleMrs.isSelected()) {
            result = true;
        }
        return result;
    }

    public Boolean isSignUpNewsLetterChecked() {
        Boolean result = false;
        if (checkboxSignUpNewsletter.isSelected()) {
            result = true;
        }
        return result;
    }

    public Boolean isReceiveOffersChecked() {
        Boolean result = false;
        if (checkboxReceiveOffers.isSelected()) {
            result = true;
        }
        return result;
    }


    // Cleaners

    public void clearFirstName() {
        firstName.clear();
    }

    public void clearLastName() {
        lastName.clear();
    }

    public void clearEmail() {
        email.clear();
    }

    public void clearBirthday() {
        birthday.clear();
    }

    //

    public void clickSaveButton() {
        buttonSave.click();
    }


    @Step ("Verification that all user details are as expected")
    public void checkUserDetailsFor(User user) throws InterruptedException {

        if (user.getTitle() == Title.MR) {
            assertTrue(isTitleMrSelected());
        }

        if (user.getTitle() == Title.MS) {
            assertTrue(isTitleMrsSelected());
        }

        assertTrue(getFirstNameValue().equals(user.getFirstName()));
        assertTrue(getLastNameValue().equals(user.getLastName()));
        assertTrue(getEmailValue().equals(user.getEmail()));
        assertTrue(getBirthdayValue().equals(user.getBirthday()));

        assertTrue(checkboxReceiveOffers.isSelected() == user.getCheckboxReceiveOffers());
        assertTrue(checkboxSignUpNewsletter.isSelected() == user.getCheckboxReceiveOffers());

    }
}


