package com.demoblaze.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage{
    @FindBy (id = "nameofuser")
    public WebElement welcomeUsername;

    public void verifyLogin_method(String expectedUserWelcomeMessage){
        String actualUserWelcomeMessage = welcomeUsername.getText();
        Assert.assertEquals("User welcome message verification FAILED", expectedUserWelcomeMessage,actualUserWelcomeMessage);
    }
}
