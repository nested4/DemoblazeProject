package com.demoblaze.pages;

import com.demoblaze.utilities.BrowserUtils;
import com.demoblaze.utilities.ConfigurationReader;
import com.demoblaze.utilities.Driver;
import io.cucumber.java.cs.Ale;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    @FindBy (id = "loginusername")
    public WebElement usernameInput;

    @FindBy (id = "loginpassword")
    public WebElement passwordInput;

    @FindBy(css = "[onclick='logIn()']")
    public WebElement loginButton;

    public void loginMethod(){
        String username = ConfigurationReader.get("username");
        String password = ConfigurationReader.get("password");
        loginButtonHomepage.click();
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
        BrowserUtils.waitFor(2);
    }

    public void loginMethod(String username, String password){
        loginButtonHomepage.click();
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
        BrowserUtils.waitFor(2);
    }
    public void verifyNegativeLoginMessage(String expectedMessage){
        Alert alert = Driver.get().switchTo().alert();
        String actualMessage = alert.getText();
        alert.accept();
        Assert.assertEquals("Negative Login Message Verification FAILED",expectedMessage,actualMessage);
        System.out.println("actualMessage = " + actualMessage);
        System.out.println("expectedMessage = " + expectedMessage);


    }
}
