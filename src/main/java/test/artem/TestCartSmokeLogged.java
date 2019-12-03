package main.java.test.artem;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import main.java.pages.cart.CartPage;
import main.java.pages.main.MainPage;
import main.java.test.BasicTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
@Listeners( BasicTest.class)

public class TestCartSmokeLogged extends BasicTest {

    @Severity(SeverityLevel.CRITICAL)
    @Description("Smoke test includes add to cart and delete from it logged user")
    @Test
    public void itemPresentsLogin () {
        //Arrange
        MainPage userPage = loginHelper()
                .getUserPage()
                .initHeader()
                .getLogCont()
                .goToMainPage();
        CartPage cartPage = addToCartHelper()
                .getCartPage();
        //Act
        String actual = cartPage.getShoppingCart()
                .getShoppingItemsList()
                .get(0)
                .getNameText();
        //Assert
        assertTrue(actual.toLowerCase().contains("t-shirt"));
        cartPage
                .getShoppingCart()
                .deleteAllFromCart();
        assertTrue(cartPage.getShoppingCart().getShoppingItemsList().isEmpty());
    }


}
