/*
 * main.java.pages.addresses;
 *
 * Version 1.0
 *
 * 09.11.2019
 *
 * Copyright: Made by Volodymyr Zyhmund
 */

package main.java.pages.user;

// Additional packages
import main.java.pages.common.ParentPage;
import main.java.test.BasicTest;
import org.testng.annotations.Listeners;

// Listeners are waiting for the error and if it occurs - make a screenshot of error page
@Listeners(BasicTest.class)

// UserPage class
public class UserPage extends ParentPage {

	// Default constructor
	public UserPage() {
		getUserPageContainer();
	}

	// Getter
	public UserPageContainer getUserPageContainer() {
		return new UserPageContainer();
	}
}