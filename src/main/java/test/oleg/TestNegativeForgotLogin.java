package main.java.test.oleg;

import main.java.pages.header.UnlogUserInfo;
import main.java.pages.login.LoginForm;
import main.java.test.BasicTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Listeners(BasicTest.class)
public class TestNegativeForgotLogin {
	@Test
	public void testNegativeForgotLogin () {
		 new UnlogUserInfo ()
				.clickSignInHeaderFull ()
				.getLoginForm ()
				.forgotPasswordClick ()
				.writeNegativeEmail ( "someEmail" );
		String expected = "some@gmail.com";
		String actual = new LoginForm ().getEmail ().getAttribute ( "value" );
		assertEquals ( actual, expected );
	}
}
