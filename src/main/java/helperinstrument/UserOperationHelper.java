package main.java.helperinstrument;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import io.qameta.allure.Step;
import main.java.data.Customer;
import main.java.data.User;
import main.java.data.UserRepository;
import main.java.pages.register.RegisterPage;

import java.util.List;

import static io.restassured.RestAssured.given;
import static main.java.helperinstrument.PageNavigationHelper.openRegisterPage;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertNotNull;

/**
 * This helper contains methods related to User Account
 */
public class UserOperationHelper {

    /**
     * Create new user via GUI
     */
    @Step ("Creating new unique user...")
    public static User createAccountForNewUniqueUser() throws InterruptedException {

        UserRepository userRepository = new UserRepository();
        User user = userRepository.getUniqueUser();

        RegisterPage registerPage = openRegisterPage();

        registerPage.createAccountFor(user);
        return user;
    }

    /**
     * Create new customer via API
     */
    @Step ("Creating new unique user via API")
    public static User createAccountForNewUniqueUserViaAPI() throws JsonProcessingException {

        //Generating new user object

        UserRepository userRepository = new UserRepository();
        User user = userRepository.getUniqueUser();
        System.out.println(user);

        //Creating new customer object out of needed fields of User object

        Customer customer = new Customer(user);

        //Preparing body for POST request using Jackson

        XmlMapper xmlMapper = new XmlMapper();
        String xmlCustomer = xmlMapper.writeValueAsString(customer);
        assertNotNull(xmlCustomer);

        String bodyRequest = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> <prestashop xmlns:xlink=\"http://www.w3.org/1999/xlink\">" +
                xmlCustomer + "</prestashop>";

        //Making POST request to create new user

        given().
                auth().basic(EnviromentHelper.getPrestaKey(), "").
        when().
                body(bodyRequest).
                post(EnviromentHelper.getPrestaUrl() + "/api/customers/").
        then().
                statusCode(201).
                body("prestashop.customer.firstname", equalTo(user.getFirstName())).
                body("prestashop.customer.lastname", equalTo(user.getLastName())).
                body("prestashop.customer.email",equalTo((user.getEmail()))).
                body("prestashop.customer.id_gender",equalTo((user.getIdGender())));

        return user;
    }


    /**
     * Veryfying that user's details, got from API are as expected, according to newly created
     */
    @Step ("Veryfying that user's details, got from API are as expected, according to newly created")
    public static void verifyUserViaApi(User user, int userId){

        given().
                auth().basic(EnviromentHelper.getPrestaKey(), "").
        when().
                get(EnviromentHelper.getPrestaUrl() + "/api/customers/" + userId).
        then().
                statusCode(200).
                body("prestashop.customer.firstname", equalTo(user.getFirstName())).
                body("prestashop.customer.lastname", equalTo(user.getLastName())).
                body("prestashop.customer.email",equalTo((user.getEmail()))).
                body("prestashop.customer.id_gender",equalTo((user.getIdGender())));
    }


    /**
     * Getting number of customers of Prestashop store via API
     */
    @Step("Getting number of Users via API")
    public static int GetNumberOfCustomersViaApi() {

        int count = given().
                auth().basic(EnviromentHelper.getPrestaKey(), "").
                when().
                get(EnviromentHelper.getPrestaUrl() + "/api/customers/").
                then().
                statusCode(200).
                extract().xmlPath().getInt("prestashop.customers.customer.size()");

        System.out.printf("\nCustomers in the system: %d \n", count);

        return count;
    }


    /**
     * Getting the last customer's ID via API
     */
    @Step("Getting the last customer's ID via API")
    public static int getIdOflastCustomerViaApi() throws InterruptedException {

        int count = GetNumberOfCustomersViaApi();

        List list = given().
                auth().basic(EnviromentHelper.getPrestaKey(), "").
                when().
                get(EnviromentHelper.getPrestaUrl() + "/api/customers/").
                then().
                statusCode(200).
                extract().xmlPath().getList("prestashop.customers.customer.@id");

        int idOfLastCustomer = Integer.parseInt(list.get(list.size() - 1).toString());
        System.out.println("\nThe last customer's ID is " + idOfLastCustomer);

        return idOfLastCustomer;
    }
}
