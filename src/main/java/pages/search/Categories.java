package main.java.pages.search;

import main.java.tools.OurWebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
/**
 * 
 */
public class Categories {

    private WebElement categoryName;
    private ArrayList<Category> categories= new ArrayList<Category>();
    /**
     * Default constructor
     */
    public Categories() {
        /*
         * Find open category name
         */
        categoryName = OurWebDriver.driver.findElementByXPath("//a[@class='text-uppercase h6']");

        /*
         * Create list of categories
         */
        for (WebElement c: OurWebDriver.driver.findElementsByXPath("//li[@data-depth='0']")) {
            categories.add(new Category(c));
        }

        /*
          Find subcategories for categories
         */
        int i=1; //for check iteration
        for (WebElement c: OurWebDriver.driver.findElementsByXPath("//li[@data-depth=1]/a")){
            if (i<3){
                categories.get(0).addSubCategory(c);
            }
            else{
                categories.get(1).addSubCategory(c);
            }
        }

        /*
         * Add collapse button
         */
        i = 0;
        for (WebElement c: OurWebDriver.driver.findElementsByXPath("//div[contains(@class,'navbar-toggler')]")){
            categories.get(i).setCollapse(c);
            i++;
        }

    }

    public String getCategoryName(){
        return categoryName.getText();
    }

    public void clickCategoryName(){
        categoryName.click();
    }

    public SearchPage clickCategory(int index) {
        SearchPage searchPage = categories.get(index).clickCategory();
        return searchPage;
    }

    public Category getCategory(int index){
        return categories.get(index);
    }


}