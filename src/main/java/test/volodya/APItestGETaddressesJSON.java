/*
 * main.java.pages.addresses;
 *
 * Version 1.0
 *
 * 09.11.2019
 *
 * Copyright: Made by Volodymyr Zyhmund
 */

package main.java.test.volodya;

// Additional packages
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import main.java.test.BasicTest;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.io.IOException;

// Listeners are waiting for the error and if it occurs - make a screenshot of error page
@Listeners(BasicTest.class)

// APItestGETaddressesJSON class
public class APItestGETaddressesJSON {

    // Severity and description for Allure report
    @Severity(SeverityLevel.MINOR)
    @Description("Verify that actual response contains expected sub-string")
    @Test
    public void apiTestGET() throws IOException {
        // Arrange
        // Create HttpClient
        OkHttpClient client = new OkHttpClient();

        // Act
        // Create request to server
        Request request = new Request.Builder()
                .url("http://3.124.147.74/api/addresses")
                .get()
                .addHeader("Output-Format", "JSON")
                .addHeader("Authorization", "Basic OEVLOTVLMzVBWFoxRkw0MTZJRzI1NDc1S0JDNDhTN1Q6")
                .addHeader("User-Agent", "PostmanRuntime/7.19.0")
                .addHeader("Accept", "*/*")
                .addHeader("Cache-Control", "no-cache")
                .addHeader("Postman-Token", "3e8c4321-a102-452a-80d9-e4cee99469e7,0a7698cc-602c-4a91-869d-9b3bce670975")
                .addHeader("Host", "3.124.147.74")
                .addHeader("Accept-Encoding", "gzip, deflate")
                .addHeader("Cookie", "PrestaShop-07008fe12e4aedffd7878ad92215ef88=def502000650480c3331f08f435bcc29f93cc3dc50d42ea38ab14bb70e9a8d6a0247f74f8033b02e6af663d0521d44a2fbd8c5d52183fd7bfd8554def623a7b4b2490359e92635dea10817fde76512f05e5d276846ff206671c9d5b1e661e49f418f549abd4c1c45deebc19771b70944297c292c5198e24fe65cbba4ac3b4d60dd46e13ff44f42a9e24872f6e07109a992cfe87d067a5a72fc6e1831fb8fddab489b69")
                .addHeader("Connection", "keep-alive")
                .addHeader("cache-control", "no-cache")
                .build();

        // Receive response from server
        Response response = client.newCall(request).execute();

        assert response.body() != null;

        String actualResponseBody = response.body().string();

        System.out.println("\tStatus code: " + response.code());
        System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
        System.out.println("\tHeaders, returned from server: \n" + response.headers().toString());
        System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");

        System.out.println("\tBody, returned from server: \n" + actualResponseBody);

        // Assert
        // Verify, that body contains expected sub-string
        String expectedResponseBody = "{\"id\":12}";
        Assert.assertTrue(actualResponseBody.contains(expectedResponseBody));
        System.out.println("\n\tActual response body is:     " + actualResponseBody);
        System.out.println("\tAnd it contains sub-string:  " + expectedResponseBody);
    }
}