package main.java.test.oleg;


import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import main.java.helperinstrument.LogInHelper;
import main.java.test.BasicTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Listeners(BasicTest.class)

public class TestLoginForm extends BasicTest {

    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify if customer can log in")
    @Test
    public void testLoginForm() {

        LogInHelper logInHelper = new LogInHelper();
		String expected = "Admin admin";
		String actual = logInHelper.getUserPage ().initHeaderFull().getLogUserInformation ().getLogUserInfo ().getUserNameFromHeader ();
		assertEquals ( actual, expected );
		
	}
}
