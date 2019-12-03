package main.java.test.artem;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import main.java.pages.cart.CartPage;
import main.java.test.BasicTest;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
@Listeners( BasicTest.class)

public class TestOverLimitValue extends BasicTest {

    @Severity(SeverityLevel.NORMAL)
    @Description("Verification of possibility to order over limit product quantity")
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
                .quantityChangeValue("292");
        WebElement expected = cartPage
                .getAlertMessage()
                .getMessage();
        //Assert
        assertTrue (expected.isDisplayed());
    }
}
