package main.java.test.ok;

import io.qameta.allure.Description;
import main.java.pages.header.HeaderFull;
import main.java.pages.searchresult.SearchResultPage;
import main.java.test.BasicTest;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(BasicTest.class)

public class TestSearchField extends BasicTest {

    //Arrange
    private SearchResultPage searchResultPage;
    private HeaderFull headerFull;
    private int expectedResult = 1;

    //Act
    @Description("Write text in search field.")
    @Test
    public void Step2(){
        //Arrange
        headerFull = new HeaderFull();
        //Act
        headerFull.getSearchField().sendKeys("Shirt");
        //Assert
    }

    @Description("Click on search button.")
    @Test
    public void Step3(){
        //Arrange
        //Act
        searchResultPage = headerFull.searchButtonClick();
        //Assert
    }

    //Assert
    @Description("Check the result.")
    @Test
    public void Step4(){
        //Arrange
        int resultCount;
        //Act
        resultCount=searchResultPage.getProducts().getProductsCount();
        //Assert
        Assert.assertEquals(resultCount,expectedResult);
    }
}
