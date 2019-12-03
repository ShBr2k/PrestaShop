package main.java.test.artem;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import main.java.pages.cart.CartPage;
import main.java.pages.cart.ShoppingItem;
import main.java.pages.main.MainPage;
import main.java.test.BasicTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
@Listeners( BasicTest.class)

public class TestTotalPriceLogged extends BasicTest {

    @Severity(SeverityLevel.CRITICAL)
    @Description("Verification of total price and amount of quantity and item price logged user")
    @Test
    @Issue("CDXLI-462")
    public void testPriceLogged () {
        //Arrange
        MainPage userPage =loginHelper()
                .getUserPage()
                .initHeader()
                .getLogCont()
                .goToMainPage();
        CartPage cartPage = addToCartHelper()
                .getCartPage();
        //Act
        cartPage
                .getShoppingCart()
                .getShoppingItemsList()
                .get(0)
                .changeValueByIncreasing();
        ShoppingItem fistItem = cartPage
                .getShoppingCart()
                .getShoppingItemsList()
                .get(0);
        double expected = fistItem.getPriceValue() * fistItem.getQuantityValue();
        double actual = fistItem.getTotalPriceValue();
        //Assert
        assertEquals(actual, expected);
    }
}
