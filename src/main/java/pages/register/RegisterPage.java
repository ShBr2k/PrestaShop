package main.java.pages.register;

import io.qameta.allure.Step;
import main.java.data.Title;
import main.java.data.User;
import main.java.pages.common.ParentPage;
import main.java.pages.main.MainPage;

public class RegisterPage extends ParentPage {

    public main.java.pages.register.RegisterForm regform;

    /**
     * Default constructor
     */
    public RegisterPage() {
        super();
        regform = new RegisterForm();
    }


    // Business logic
    @Step ("Creating new account for user")
    public MainPage createAccountFor(User user) throws InterruptedException {

        if (user.getTitle() == Title.MR) {
            regform.setTitleMr();
        }
        if (user.getTitle() == Title.MS) {
            regform.setTitleMrs();
        }

        regform.setFirstNameValue(user.getFirstName());
        regform.setLastNameValue(user.getLastName());
        regform.setEmailValue(user.getEmail());
        regform.setPasswordValue(user.getPassword());
        regform.setBirthdayValue(user.getBirthday());

        if (user.getCheckboxReceiveOffers() == Boolean.TRUE) {
            regform.selectCheckboxReceiveOffers();
        }
        if (user.getCheckboxSignUpNewsletter() == Boolean.TRUE) {
            regform.selectCheckboxSignUpNewsletter();
        }

        regform.selectCheckboxIAgree();
        regform.clickSaveButton();

        MainPage mainPage = new MainPage();

        return mainPage;
    }

}