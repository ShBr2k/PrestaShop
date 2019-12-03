package main.java.pages.login;


import main.java.tools.OurWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ForgotPassword {
	private WebElement emailAddress;
	private WebElement sendResetLink;
	private WebElement backToLogin;
	
	public ForgotPassword () {
		initResentLink ();
	}
	
	public void initResentLink(){
		emailAddress = OurWebDriver.driver.findElement ( By.cssSelector ( "#email" ) );
		sendResetLink = OurWebDriver.driver.findElement ( By.cssSelector ( "#content > form > section > div > " +
				"button.form-control-submit.btn.btn-primary.hidden-xs-down" ) );
		backToLogin = OurWebDriver.driver.findElement ( By.cssSelector ( "#main > footer > a" ) );
	}
	
	public WebElement emailAddressClick (){
		getEmailAddress ().click ();
		return emailAddress;
	}
	
	public ForgotLoginMessage sendResetLinkClick (){
		getSendResetLink ().click ();
		return new ForgotLoginMessage ();
	}
	
	public WebElement backToLoginClick(){
		getBackToLogin ().click ();
		return backToLogin;
	}
	
	public ForgotLoginMessage writeEmail(){
		emailAddressClick ().sendKeys ( "admin@gmail.com" );
		sendResetLinkClick ();
		return new ForgotLoginMessage ();
	}
	
	public void writeNegativeEmail( String email){
		emailAddressClick ().sendKeys ( email );
		sendResetLinkClick ();
	}
	
	public WebElement getEmailAddress () {
		return emailAddress;
	}
	
	public WebElement getSendResetLink () {
		return sendResetLink;
	}
	
	public WebElement getBackToLogin () {
		return backToLogin;
	}
	
}
