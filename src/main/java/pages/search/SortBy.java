package main.java.pages.search;

import main.java.tools.OurWebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

/**
 * Use method selectSort, with int argument variant of sorting
 * Use template:
 * Sort by:
 *      Relevance           > 0
 *      Name, A to Z        > 1
 *      Name, Z to A        > 2
 *      Price, low to high  > 3
 *      Price, high to low  > 4
 */
public class SortBy {

    private ArrayList<WebElement> sortTypes = new ArrayList<WebElement>();
    private WebElement expendButton;
    private boolean isAriaExpanded = false;
    /**
     * Default constructor
     */
    public SortBy() {
        getSortTypes();
    }

    /**
     * Maybe I will need to rewrite this method in future, if test will be fallen
     * @param index
     */
    public void selectSort(int index){
        if (isAriaExpanded){
            sortTypes.get(index).click();
        }
        else{
            clickExpendButton();
            sortTypes.get(index).click();
        }
    }

    public ArrayList<WebElement> getSortTypes(){
        sortTypes.addAll(OurWebDriver.driver.findElementsByXPath("//div[@class='dropdown-menu']//a"));
        return sortTypes;
    }

    public void clickExpendButton(){
        expendButton = OurWebDriver.driver.findElementByXPath("//div[@class='row sort-by-row']//button[@data-toggle]");
        isAriaExpanded = Boolean.getBoolean(expendButton.getAttribute("aria-expanded"));
        expendButton.click();
    }
}