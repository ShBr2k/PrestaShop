package main.java.pages.search;

import main.java.tools.OurWebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

/**
 * 
 */
public class Filter {

    private ArrayList<FilterBlock> blocks;

    /**
     * Default constructor
     */
    public Filter() {
        String addressBuffer;
        for(WebElement block : OurWebDriver.driver.findElementsByXPath("//div[@id='search_filters']/section/p")){
            blocks.add(new FilterBlock(block.getText()));
            addressBuffer = String.format("//div[@id='search_filters']/section/p[text()='%s']/following-sibling::ul/li/label/span/input"
                                           ,block.getText());
            for(WebElement checkBox : OurWebDriver.driver.findElementsByXPath(addressBuffer)){
                blocks.get(blocks.size()-1).addCheckBox(checkBox);
            }

        }
    }



}