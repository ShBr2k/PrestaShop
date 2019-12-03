package main.java.test.nata;

import main.java.helperinstrument.EnviromentHelper;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class TestApi {

    @Test
    public void testingApi() throws IOException {

        given().auth().basic("8EK95K35AXZ1FL416IG25475KBC48S7T", "")
                .get(EnviromentHelper.getPrestaUrl() + "/api/addresses/12")
                .then()
                .log().all()
                .statusCode(200);



    }
}
