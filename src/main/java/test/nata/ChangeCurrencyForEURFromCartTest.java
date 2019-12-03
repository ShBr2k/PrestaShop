package main.java.test.nata;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import main.java.helperinstrument.AddToCartHelper;
import main.java.test.BasicTest;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(BasicTest.class)


public class ChangeCurrencyForEURFromCartTest extends BasicTest {


    @Severity(SeverityLevel.CRITICAL)
    @Description("Verifies if currency is changed for USD on CartPage")
    @Test
    public void changeCurrency() {
        String expected = "EUR";
        //Act
        String actual = addToCartHelper()
                .getCartPage()
                .initHeaderFull()
                .getCurrency()
                .chooseEUR()
                .showValueOfTheCurrencyItem().substring(0, 3);
        System.out.println(actual);

        //Assert

        Assert.assertEquals(actual, expected);

        System.out.println("Currency is changed to EUR");

    }

}

