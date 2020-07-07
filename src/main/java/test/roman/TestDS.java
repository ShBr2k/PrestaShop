package main.java.test.roman;


import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import main.java.pages.ds.Login;
import main.java.test.BasicTest;
import main.java.tools.OurWebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

@Listeners(BasicTest.class)

public class TestDS extends BasicTest{

    static public ChromeDriver driver;
    private static WebDriverWait wait;

    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify opening are login page of DS")
    @Test
    public void testOpenLoginPage() {

        //OurWebDriver ourWebDriver = new OurWebDriver();
        OurWebDriver.openDS();

        Login login = new Login();

        int loginButton = login.getLoginButton();

        Assert.assertEquals(loginButton, 1);
        System.out.println("LoginButton is present");

    }
}
