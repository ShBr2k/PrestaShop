package main.java.pages.ds;


import io.qameta.allure.Step;
import main.java.tools.OurWebDriver;
import main.java.tools.RegexUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Login {

    private String userName = "shbr2k";//EnviromentHelper.getUserName();
    private String userPass = "FEBzero";//EnviromentHelper.getUserPass();

    private static WebElement userNameInput;
    private static WebElement passwordInput;
    private static WebElement loginButton;

    public Login() {
        initLogin();
    }

    private static void initLogin() {
        userNameInput = OurWebDriver.driver.findElement(By.xpath("//input[@id='username']"));
        passwordInput = OurWebDriver.driver.findElement(By.xpath("//input[@id='password']"));
        loginButton = OurWebDriver.driver.findElement(By.xpath("//div[@role='button']"));
    }

    private void setUserName() {
        userNameInput.sendKeys(userName);
    }

    private void setPassword() {
        passwordInput.sendKeys(userPass);
    }

    private void clickLoginButton() {
        loginButton.click();
    }


    @Step("Get amount of loginButton;")
    public int getLoginButton() {
        int countLoginButton = (OurWebDriver.driver.findElements(By.xpath("//div[@role='button']")).size());
        return countLoginButton;
    }


//    public ModulesPage doLogin() {
//        setUserName();
//        setPassword();
//        clickLoginButton();
//        return new ModulesPage();
//    }

}

