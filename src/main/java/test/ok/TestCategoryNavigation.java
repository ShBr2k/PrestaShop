package main.java.test.ok;

import io.qameta.allure.Description;
import main.java.pages.main.MainPage;
import main.java.pages.search.SearchPage;
import main.java.test.BasicTest;
import main.java.tools.OurWebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(BasicTest.class)

public class TestCategoryNavigation extends BasicTest {

    //Arrange
    private MainPage mainPage;
    private SearchPage searchPage;
    private String addressBuffer;

    //Act
    @Description("Open search page.")
    @Test(priority = 1)
    public void Step1(){
        //Arrange
        mainPage = new MainPage();
        //Act
        searchPage = mainPage.getPopularProducts().clickAllProducts();
        //Assert
        Assert.assertEquals(searchPage.getDescription().getDescriptionName(),"HOME");
    }

    @Description("Check \"Home\" category.")
    @Test(priority = 2)
    public void Step2(){
        //Arrange
        addressBuffer = OurWebDriver.driver.getCurrentUrl();    //remember search page address
        //Act
        searchPage.getCategories().clickCategoryName();
        //Assert
        Assert.assertEquals(OurWebDriver.driver.getCurrentUrl(),addressBuffer);
    }

    @Description("Check \"Clothes\" category.")
    @Test(priority = 3)
    public void Step3(){
        //Act
        searchPage.getCategories().clickCategory(0);
        //Assert
        Assert.assertEquals(searchPage.getDescription().getDescriptionName(),"CLOTHES");
    }

    @Description("Check \"Clothes\" subcategory \"Men\".")
    @Test(priority = 4)
    public void Step4(){
        //Act
        searchPage.getCategories().clickCategory(0);
        //Assert
        Assert.assertEquals(searchPage.getDescription().getDescriptionName(),"MEN");
    }

    @Description("Return back, and check \"Women\" subcategory.")
    @Test(priority = 5)
    public void Step5(){
        //Act
        searchPage.getPagePath().clickElement(1);
        searchPage.getCategories().clickCategory(1);
        //Assert
        Assert.assertEquals(searchPage.getDescription().getDescriptionName(),"WOMEN");
    }

    @Description("Open search page, and check \"Accessories\" category.")
    @Test(priority = 6)
    public void Step6(){
        //Act
        searchPage.getPagePath().clickElement(0);
        mainPage = new MainPage();                          //Need to refresh main page obj
        searchPage = mainPage.getPopularProducts().clickAllProducts();
        searchPage.getCategories().clickCategory(1);
        //Assert
        Assert.assertEquals(searchPage.getDescription().getDescriptionName(),"ACCESSORIES");
    }

    @Description("Check \"Accessories\" subcategory \"Stationery\".")
    @Test(priority = 7)
    public void Step7(){
        //Act
        searchPage.getCategories().clickCategory(0);
        //Assert
        Assert.assertEquals(searchPage.getDescription().getDescriptionName(),"STATIONERY");
    }

    @Description("Return back, and check subcategory \"Home Accessories\".")
    @Test(priority = 8)
    public void Step8(){
        //Act
        searchPage.getPagePath().clickElement(1);
        searchPage.getCategories().clickCategory(1);
        //Assert
        Assert.assertEquals(searchPage.getDescription().getDescriptionName(),"HOME ACCESSORIES");

    }

    @Description("Open search page, and check \"Art\" category.")
    @Test(priority = 9)
    public void Step9(){
        //Act
        searchPage.getPagePath().clickElement(0);
        mainPage = new MainPage();                          //Need to refresh main page obj
        searchPage = mainPage.getPopularProducts().clickAllProducts();
        searchPage.getCategories().clickCategory(2);
        //Assert
        Assert.assertEquals(searchPage.getDescription().getDescriptionName(),"ART");

    }
}
