package main.java.test.oleg;

import main.java.pages.header.LogUserInformation;
import main.java.pages.login.LoginForm;
import main.java.test.BasicTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Listeners(BasicTest.class)
public class TestNegativeLoginForm extends BasicTest{
	@Test
	public void testLoginFormWithWrongData(){
		new LogUserInformation ()
				.getUnloggedUserInfo()
				.clickSignInHeaderFull()
				.getLoginForm ()
				.logInVoid ( "some@gmail.com" , "somes" );
		String expected = "some@gmail.com";
		String actual = new LoginForm ().getEmail ().getAttribute ( "value" );
		assertEquals(actual, expected);
	}
}
