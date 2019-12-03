package main.java.data;


import io.qameta.allure.Step;
import main.java.helperinstrument.EnviromentHelper;

import java.util.Random;

public class UserRepository {

    private static User petro;
    private static User maria;
    private static User admin;
    private static User uniqueUser;

    public UserRepository() {

        petro = new User(
                Title.MR,
                "Petro",
                "Shevchenko",
                EnviromentHelper.getPetroEmail (),
                EnviromentHelper.getMasterPass (),
                "01/06/2000",
                Boolean.TRUE,
                Boolean.FALSE);

        maria = new User(
                Title.MS,
                "Maria",
                "Kvitka",
                EnviromentHelper.getMariaEmail (),
                EnviromentHelper.getMasterPass (),
                "03/03/2001",
                Boolean.TRUE,
                Boolean.TRUE);

        admin = new User();
        admin.setEmail(EnviromentHelper.getAdminEmail ());
        admin.setPassword(EnviromentHelper.getMasterPass ());

        uniqueUser = createUniqueUser();

    }

    private User createUniqueUser() {
        User uniqueUser = new User();

        uniqueUser.setTitle(Title.MR);
        uniqueUser.setFirstName("FirstName");
        uniqueUser.setLastName("LastName");
        uniqueUser.setPassword(EnviromentHelper.getMasterPass ());
        uniqueUser.setBirthday("04/04/1999");
        uniqueUser.setCheckboxReceiveOffers(Boolean.TRUE);
        uniqueUser.setCheckboxSignUpNewsletter(Boolean.TRUE);

        //setting random email like test1642@test.com
        Random random = new Random();
        Integer randomNumber = random.nextInt(9999);

        String uniqueEmail = EnviromentHelper.getUniqueTest () + randomNumber + EnviromentHelper.getUniqueGmail ();

        uniqueUser.setEmail(uniqueEmail);

        return uniqueUser;
    }

    public User getPetro() {
        return petro;
    }

    public User getMaria() {
        return maria;
    }

    public User getAdmin() { return admin; }

    @Step ("Taking User with unique email...")
    public User getUniqueUser() {
        return uniqueUser;
    }
}



