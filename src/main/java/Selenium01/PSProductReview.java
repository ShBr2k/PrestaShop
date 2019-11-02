package Selenium01;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class PSProductReview {

    private static WebDriver webDriver;
    private static final String APP_URL = "http://3.124.147.74";


    public static void setChromeDriverProperty() {
        //System.setProperty("webdriver.chrome.driver", "C:/Users/User/IdeaProjects/zJars/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", "C:/Users/ShBr2k/IdeaProjects/zJars/chromedriver.exe");
    }


    @BeforeClass
    public static void prepareApplication() {
        setChromeDriverProperty();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
    }


    @Test(priority = 1)
    public static void launchApplication() {

        webDriver.get(APP_URL);

        //WebElement topSlider = (new WebDriverWait(webDriver, 60)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='slider-wrapper-panel']")));
        //WebElement loginButton = (new WebDriverWait(webDriver, 60)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Log in')]")));

    }

}
