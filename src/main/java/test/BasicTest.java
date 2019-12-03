package main.java.test;


import io.qameta.allure.Attachment;
import main.java.helperinstrument.AddToCartHelper;
import main.java.helperinstrument.ChangeLanguageHelper;
import main.java.helperinstrument.LogInHelper;
import main.java.tools.OurWebDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class BasicTest implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        saveScreenshot();
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot() {
        return ((TakesScreenshot) OurWebDriver.driver).getScreenshotAs(OutputType.BYTES);
    }


    @BeforeTest
    protected void setUpWebDriver() {
        OurWebDriver driver = new OurWebDriver();
    }

    @AfterTest(alwaysRun = true)
    protected void closeWebDriver() {
        OurWebDriver.driver.quit();
    }

    /**
     * @return new instance of add to cart helper
     */
    protected AddToCartHelper addToCartHelper() {
        return new AddToCartHelper();
    }

    /**
     * @return new instance of login helper
     */
    protected LogInHelper loginHelper() {
        return new LogInHelper();
    }

    /**
     * @return new instance of changeLanguageHelper helper
     */
    protected ChangeLanguageHelper changeLanguageHelper() {
        return new ChangeLanguageHelper();
    }
}