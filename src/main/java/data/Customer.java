package main.java.data;

// This class is needed to serialize into XML in order to make POST API requests

public class Customer {

    private String id_gender;
    private String firstname;
    private String lastname;
    private String birthday;
    private String email;
    private String passwd;
    private String active;
    private String id_default_group;
    private String id_lang;
    private String newsletter;
    private String optin;


    public Customer() {
    }

    public Customer(User user) {

        this.id_gender = user.getIdGender();
        this.firstname = user.getFirstName();
        this.lastname = user.getLastName();
        this.email = user.getEmail();
        this.passwd = user.getPassword();
        this.birthday = getBirthdayValueInServersFormat(user.getBirthday());
        this.active = "1";
        this.id_default_group = "3";
        this.id_lang = "1";
        this.newsletter = newsletterConverted(user.getCheckboxSignUpNewsletter());
        this.optin = optinConverted(user.getCheckboxReceiveOffers());
    }

    public String getId_gender() {
        return id_gender;
    }

    public void setId_gender(String id_gender) {
        this.id_gender = id_gender;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getId_default_group() {
        return id_default_group;
    }

    public void setId_default_group(String id_default_group) {
        this.id_default_group = id_default_group;
    }

    public String getId_lang() {
        return id_lang;
    }

    public void setId_lang(String id_lang) {
        this.id_lang = id_lang;
    }

    public String getNewsletter() {
        return newsletter;
    }

    public void setNewsletter(String newsletter) {
        this.newsletter = newsletter;
    }

    public String getOptin() {
        return optin;
    }

    public void setOptin(String optin) {
        this.optin = optin;
    }


    private String getBirthdayValueInServersFormat(String birthday) {

        String[] arrayDate = birthday.split("/");
        return arrayDate[2] + "-" + arrayDate[0] + "-" + arrayDate[1];
    }

    private String newsletterConverted(Boolean bl) {
        String result = "";
        if (bl == true) {
            result = "1";
        } else if (bl == false) {
            result = "0";
        }
        return result;
    }

    private String optinConverted(Boolean bl) {
        String result = "";
        if (bl == true) {
            result = "1";
        } else if (bl == false) {
            result = "0";
        }
        return result;
    }

    @Override
    public String toString() {
        return "customer{" +
                "id_gender='" + id_gender + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", birthday='" + birthday + '\'' +
                ", email='" + email + '\'' +
                ", passwd='" + passwd + '\'' +
                ", active='" + active + '\'' +
                ", id_default_group='" + id_default_group + '\'' +
                ", id_lang='" + id_lang + '\'' +
                ", newsletter='" + newsletter + '\'' +
                ", optin='" + optin + '\'' +
                '}';
    }
}
