package main.java.pages.common;

import main.java.tools.OurWebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;



/**
 * If you need to click on path element,
 * use method clickElement, with int argument
 * use this temptale: Home / Clothes / Category
 *                     ^        ^         ^
 *                     0        1         2
 */
public class PagePath {

    private ArrayList<WebElement> path;

    /**
     * Default constructor
     */
    public PagePath() {
        path = (ArrayList<WebElement>) OurWebDriver.driver.findElementsByXPath ("//nav[@class='breadcrumb hidden-sm-down']//a");
    }

    public void clickElement(int index){
        path.get(index).click();
    }

}