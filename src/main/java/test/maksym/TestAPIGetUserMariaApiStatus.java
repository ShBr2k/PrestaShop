package main.java.test.maksym;

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

import static org.testng.Assert.assertEquals;

@Listeners(BasicTest.class)
public class TestAPIGetUserMariaApiStatus extends BasicTest {

    @Severity(SeverityLevel.CRITICAL)
    @Description("API request to get details of User Maria Kvitka")
    @Test
    public void TestCreateAccountWithoutBirthday() throws InterruptedException {

        // ******* ARRANGE *******

        RestAssured.baseURI = EnviromentHelper.getPrestaUrl();

        RequestSpecification httpRequest =
                RestAssured.given()
                        .auth()
                        .basic(EnviromentHelper.getPrestaKey(), "");

        // ******* ACT *******

        Response response = httpRequest.get("/api/customers/16");

        // ******* ASSERT *******

        assertEquals(response.getStatusCode(), 200);


    }
}
