package main.java.test.artem;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import main.java.pages.cart.CartPage;
import main.java.test.BasicTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
@Listeners( BasicTest.class)

public class TestBoundaryValue extends BasicTest {
    @Severity(SeverityLevel.NORMAL)
    @Description("Verification of possibility to order max product quantity")
    @Test
    public void cartOverLimitValue () {
        //Arrange
        CartPage cartPage= addToCartHelper()
                .getCartPage();
        //Act
        cartPage
                .getShoppingCart()
                .getShoppingItemsList()
                .get(0)
                .quantityChangeValue("291");
        //Assert
        assertFalse (cartPage.isAlertMessagePresent());
    }
}
