package main.java.test.roman;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import main.java.helperinstrument.EnviromentHelper;
import org.hamcrest.CoreMatchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static main.java.test.roman.XMLConverter.*;


public class TestAPIPS {

    String PSUrl = EnviromentHelper.getPrestaUrl();
    String PSKey = EnviromentHelper.getPrestaKey();
    
    //private static final String PSUrl = "";
    //private static final String PSKey = "";
    private static final String xmlCorrectCust = "./src/main/java/test/roman/correctCust.xml";
    private static final String xmlExistingLoginCust = "./src/main/java/test/roman/existingLoginCust.xml";
    private static final String xmlWrongPassCust = "./src/main/java/test/roman/wrongPassCust.xml";

    private int CountCustBeforeAdding;
    private int CountCustAfterAdding;

    private String xmlResponseCust;
    private String strIDCust;


    @Severity(SeverityLevel.CRITICAL)
    @Description("Check API's status code after adding customer with correct values")
    @Test(priority = 1)
    public void checkAPIStatusCodeAfterAddCorrectCust() {
        int getStatusCode = xmlPostRequestAddCust(xmlCorrectCust);
        Assert.assertTrue(getStatusCode == 201);
        System.out.println("API return status code: " + getStatusCode + ". New customer added successfully.\n");
    }


    @Severity(SeverityLevel.CRITICAL)
    @Description("Check increase count of customers after after adding customer with correct values")
    @Test(priority = 2)
    public void checkCountCustomersAfterAddCorrCust() {
        Assert.assertTrue((CountCustBeforeAdding + 1) == CountCustAfterAdding);
        System.out.println("A count of customers is increased. New customer added successfully.\n");
    }


    @Severity(SeverityLevel.CRITICAL)
    @Description("Check values in DB (firstName, lastName, email, birthDay) of added customer with correct values")
    @Test(priority = 3)
    public void checkValuesCustAfterAddCorrectCust() {

        // Get values of customer from XMLFileCust
        String strValuesCust[] = getCustValuesFromXMLFile(xmlCorrectCust);

        given()
                .auth()
                .basic(PSKey, "")
                .when()
                .get(PSUrl + "/api/customers/" + strIDCust)
                .then()
                .statusCode(200)
                .assertThat()
                .body("prestashop.customer.firstname", CoreMatchers.is(strValuesCust[0]))
                .body("prestashop.customer.lastname", CoreMatchers.is(strValuesCust[1]))
                .body("prestashop.customer.email", CoreMatchers.is(strValuesCust[2]))
                .body("prestashop.customer.birthday", CoreMatchers.is(strValuesCust[3]));
    }


    @Severity(SeverityLevel.CRITICAL)
    @Description("Check API's status code after adding customer with existing value of login (mail)")
    @Test(priority = 4)
    public void checkAPIStatusCodeAfterAddWrongLoginCust() {
        int getStatusCode = xmlPostRequestAddCust(xmlExistingLoginCust);
        Assert.assertFalse(getStatusCode == 201);
        System.out.println("API return status code: " + getStatusCode + ". New customer with existing login not added.\n");
        Assert.assertTrue(CountCustBeforeAdding == CountCustAfterAdding);
        System.out.println("A count of customers is not increased. New customer with wrong login not added.\n");
    }


    @Severity(SeverityLevel.CRITICAL)
    @Description("Check API's status code after adding customer with wrong value of password (<5 chars)")
    @Test(priority = 5)
    public void checkAPIStatusCodeAfterAddWrongPassCust() {
        int getStatusCode = xmlPostRequestAddCust(xmlWrongPassCust);
        Assert.assertFalse(getStatusCode == 201);
        System.out.println("API return status code: " + getStatusCode + ". New customer with wrong password not added.\n");
        Assert.assertTrue(CountCustBeforeAdding == CountCustAfterAdding);
        System.out.println("A count of customers is not increased. New customer with wrong password is not added.\n");
    }


    // post request for add cust, get response status code, save count of customers before|after adding cust, get cust id
    public int xmlPostRequestAddCust(String xmlFileCust) {

        // Get string values from XMLFileCust
        String stringValuesCust = convertXMLFileToString(xmlFileCust);
        // Save count of customers before adding new
        CountCustBeforeAdding = xmlGetResponseGetCountCust();

        // Get response from API
        Response response = given()
                .auth()
                .basic(PSKey, "")
                .body(stringValuesCust)
                .when()
                .post(PSUrl + "/api/customers");

        // Get status code of response
        int statusCode = response.getStatusCode();
        // Save count of customers after adding new
        CountCustAfterAdding = xmlGetResponseGetCountCust();
        // Get XML response of added customer
        xmlResponseCust = String.valueOf(response.prettyPrint());
        // Get ID of added customer
        int firstIndex = xmlResponseCust.indexOf("<id>");
        int lastIndex = xmlResponseCust.indexOf("</id>");
        strIDCust = xmlResponseCust.substring(firstIndex + 4, lastIndex);
        //xmlResponseCust = String.valueOf(response.prettyPeek());
        //System.out.println("Post Response :" + xmlResponseCust);
        //System.out.println("Status Code :" + response.getStatusCode());
        return statusCode;
    }


    // Get count of customers
    private int xmlGetResponseGetCountCust() {
        int countCust = given()
                .auth()
                .basic(PSKey, "")
                .when()
                .get(PSUrl + "/api/customers")
                .then()
                .statusCode(200)
                .extract().xmlPath().getInt("prestashop.customers.customer.size()");
        return countCust;
    }


}
