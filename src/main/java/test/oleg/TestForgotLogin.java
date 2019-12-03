package main.java.test.oleg;


import main.java.pages.header.UnlogUserInfo;
import main.java.pages.login.ForgotLoginMessage;
import main.java.test.BasicTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners( BasicTest.class)



public class TestForgotLogin extends BasicTest {
	
	@Test
	public void testForgotPassword(){
		ForgotLoginMessage forgotLoginMessage = new UnlogUserInfo ()
				.clickSignInHeaderFull ()
				.getLoginForm ()
				.forgotPasswordClick ()
				.writeEmail ();
	}
}


