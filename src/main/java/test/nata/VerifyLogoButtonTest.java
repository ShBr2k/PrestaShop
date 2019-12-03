package main.java.test.nata;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import main.java.helperinstrument.LogInHelper;
import main.java.test.BasicTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(BasicTest.class)

public class VerifyLogoButtonTest extends BasicTest {

    private WebElement actual;

    @Severity(SeverityLevel.CRITICAL)
    @Description("Verifies opening MainPage, after pressing on logo")
    @Test
    public void signIn() {

        //Act
        Boolean actual = loginHelper()
                .getUserPage()
                .initHeaderFull()
                .getLogCont()
                .goToMainPage()
                .getPopularProducts()
                .showTextOfAllProducts()
                .contains("All products");

        //Assert
        Assert.assertTrue(actual);
        System.out.println("Logo opens HomePage");

    }
}
