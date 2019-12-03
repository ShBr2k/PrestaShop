package main.java.helperInstrument;

import main.java.pages.search.Product;
import main.java.pages.search.Products;
import main.java.tools.OurWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;

public class SortHelper {

    private Products productsContainer;
    private ArrayList<Product> products = new ArrayList<Product>();

    public SortHelper(){
    }

    private void refreshProducts(){
        OurWebDriver
                .getWait()
                .until(ExpectedConditions
                        .stalenessOf(OurWebDriver
                                .driver
                                .findElementByXPath("//div[@class='faceted-overlay']")));
        productsContainer = new Products();
        products = new ArrayList<Product>();
        products.addAll(productsContainer.getProducts());
    }

    public boolean checkNameSort(boolean asc){
        refreshProducts();
        boolean result=true;

        if (asc) {
            for (int i = 1; i < products.size(); i++) {
                if (products.get(i).getNameProductText().charAt(0) < products.get(i - 1).getNameProductText().charAt(0)) {
                    result = false;
                    break;
                }
            }
        }
        else{
            for (int i = 1; i < products.size(); i++) {
                if (products.get(i).getNameProductText().charAt(0) > products.get(i - 1).getNameProductText().charAt(0)) {
                    result = false;
                    break;
                }
            }
        }

        return result;
    }

    public boolean checkPriceSort(boolean asc){
        refreshProducts();
        boolean result=true;

        if (asc) {
            for (int i = 1; i < products.size(); i++) {
                if (products.get(i).getProductPrice() >= products.get(i - 1).getProductPrice()) {
                    result = false;
                    break;
                }
            }
        }
        else{
            for (int i = 1; i < products.size(); i++) {
                if (products.get(i).getProductPrice() <= products.get(i - 1).getProductPrice()) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }
}
