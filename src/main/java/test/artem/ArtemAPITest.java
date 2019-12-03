package main.java.test.artem;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import main.java.helperinstrument.EnviromentHelper;
import main.java.test.BasicTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.*;
@Listeners( BasicTest.class)

public class ArtemAPITest extends BasicTest {

    @Severity(SeverityLevel.CRITICAL)
    @Description("Verification of presents product item in cart")
    @Test
    public void cartApiTest () {
        //Arrange
        RestAssured.baseURI = EnviromentHelper.getPrestaUrl();
        RequestSpecification httpRequest = RestAssured.given()
                .auth().basic(EnviromentHelper.getPrestaKey(), "");
        //Act
        Response response = httpRequest.get("/api/carts/5");
        int actual = response.getStatusCode();
        int expected = 200;
        System.out.println(response.getBody().asString());
        //Assert
        assertEquals(actual, expected);
    }
 }
