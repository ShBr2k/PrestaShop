package main.java.test.nata;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import main.java.helperinstrument.ChangeLanguageHelper;
import main.java.pages.header.HeaderFull;
import main.java.pages.main.MainPage;
import main.java.pages.main.PopularProducts;
import main.java.pages.product.ProductPage;
import main.java.test.BasicTest;
import main.java.tools.OurWebDriver;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(BasicTest.class)

public class ChangeCurrencyAfterChangingLanguageTest extends BasicTest {

    @Severity(SeverityLevel.CRITICAL)
    @Description("Verifies if currency is changed to EUR on product page")
    @Test
    public void changeCurrencyAfterChangingLanguage() {

        //Arrange

        String beforePrice= loginHelper()
                .getUserPage()
                .initHeaderFull()
                .getLogCont()
                .goToMainPage()
                .getPopularProducts()
                .getProductByPartialName("Sweater")
                .goToProductPage().showPrice();

        System.out.println("Price before changing is " + beforePrice +" UAH.");

        //Act
        String currency = changeLanguageHelper()
                .changeLanguageForUkrainina()
                .getCurrency()
                .chooseEUR()
                .showValueOfTheCurrencyItem();

        System.out.println("Currency is changed to " + currency);

        String actual = new ProductPage().showPrice();

        //Assert
        Assert.assertNotSame(beforePrice, actual);
        System.out.println("Price after changing currency is " + actual + " EUR.");
    }
}
