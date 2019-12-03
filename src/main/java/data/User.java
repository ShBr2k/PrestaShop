package main.java.data;

public class User {

    private Title title;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String birthday;
    private Boolean checkboxReceiveOffers;
    private Boolean checkboxSignUpNewsletter;

    public User(){};

    public User(Title title,
                String firstName,
                String lastName,
                String email,
                String password,
                String birthday,
                Boolean checkboxReceiveOffers,
                Boolean checkboxSignUpNewsletter) {

        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.birthday = birthday;
        this.checkboxReceiveOffers = checkboxReceiveOffers;
        this.checkboxSignUpNewsletter = checkboxSignUpNewsletter;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Boolean getCheckboxReceiveOffers() {
        return checkboxReceiveOffers;
    }

    public void setCheckboxReceiveOffers(Boolean checkboxReceiveOffers) {
        this.checkboxReceiveOffers = checkboxReceiveOffers;
    }

    public Boolean getCheckboxSignUpNewsletter() {
        return checkboxSignUpNewsletter;
    }

    public void setCheckboxSignUpNewsletter(Boolean checkboxSignUpNewsletter) {
        this.checkboxSignUpNewsletter = checkboxSignUpNewsletter;
    }

    public String getIdGender() {
        String genderId = "";
        if (title == Title.MR) {
            genderId = "1";}
        else if (title == Title.MS) {
            genderId = "2";}
    return genderId;
    }

    @Override
    public String toString() {
        return "User{" +
                "title=" + title +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", birthday='" + birthday + '\'' +
                ", checkboxReceiveOffers=" + checkboxReceiveOffers +
                ", checkboxSignUpNewsletter=" + checkboxSignUpNewsletter +
                '}';
    }
}
