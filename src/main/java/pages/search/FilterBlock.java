package main.java.pages.search;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;

/**
 * 
 */
public class FilterBlock {

    private String blockName;
    private ArrayList<WebElement> checkBoxes;

    /**
     * Default constructor
     */
    public FilterBlock(String blockName) {
        setBlockName(blockName);
    }

    /**
     * Set block name
     * @param blockName
     */
    public void setBlockName(String blockName) {
        this.blockName = blockName;
    }

    /**
     * Adding a checkbox to filter block
     * @param checkBox
     */
    public void addCheckBox(WebElement checkBox) {
        checkBoxes.add(checkBox);
    }
}