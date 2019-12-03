package main.java.test.maksym;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

import main.java.data.User;
import main.java.test.BasicTest;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static main.java.helperinstrument.UserOperationHelper.*;


@Listeners(BasicTest.class)
public class TestAPICreateNewUserViaGUIApiVerification extends BasicTest{

    @Severity(SeverityLevel.CRITICAL)
    @Description("Create new user and API verification Test")
    @Test
    public void testCreateNewUserApiVerification() throws InterruptedException {


        // ******* ARRANGE *******

        int usersBeforeCreation = GetNumberOfCustomersViaApi();

        // ******* ACT *******

        User newUser = createAccountForNewUniqueUser();
        int usersAfterCreation = GetNumberOfCustomersViaApi();
        int idOfLastCustomer = getIdOflastCustomerViaApi();

        // ******* ASSERT *******

        Assert.assertNotEquals(usersAfterCreation, usersBeforeCreation, "The amount of users shouldn't be same");
        verifyUserViaApi(newUser, idOfLastCustomer);
    }
}
