package main.java.pages.header;

import org.openqa.selenium.WebElement;

/**
 *
 */
public class Clothes {

    private WebElement men;
    private WebElement women;

    /**
     * Default constructor
     */
    public Clothes() {
        //Men = driver.find....
        //Women = driver.find...
    }

    public void clickMen() {
        men.click();
    }

    public void clickWomen() {
        women.click();
    }

}