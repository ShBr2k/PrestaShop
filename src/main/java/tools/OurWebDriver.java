package main.java.tools;

import main.java.helperinstrument.EnviromentHelper;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class OurWebDriver {
    static public ChromeDriver driver;
    private static WebDriverWait wait;

    public OurWebDriver() {

        if ((System.getProperty("os.name")).contains("Mac OS") || (System.getProperty("os.name")).contains("Linux")) {
            System.setProperty("webdriver.chrome.driver", EnviromentHelper.getMacDriver());
        } else {
            System.setProperty("webdriver.chrome.driver", EnviromentHelper.getWinDriver());
        }

        if ((System.getProperty("os.name")).contains("Linux")) {
            ChromeOptions ChromeOptions = new ChromeOptions();
            ChromeOptions.addArguments("--headless", "window-size=1024,768", "--no-sandbox", "--whitelisted-ips");
            driver = new ChromeDriver(ChromeOptions);
        } else {
            driver = new ChromeDriver();
        }
        
        driver.manage().window().maximize(); // Maximize test browser window
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(EnviromentHelper.getPrestaUrl()); // GoTo startURL
        wait = new WebDriverWait(driver, 5);
    }

    public static WebDriverWait getWait() { return wait; }

    public void closeDriver() { driver.quit(); } // Close test browser windows to release hardware resources
}
