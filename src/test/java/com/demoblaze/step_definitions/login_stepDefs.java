package com.demoblaze.step_definitions;

import com.demoblaze.pages.LoginPage;
import com.demoblaze.pages.ProductPage;
import com.demoblaze.utilities.ConfigurationReader;
import com.demoblaze.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;

public class login_stepDefs {
    LoginPage loginPage = new LoginPage();
    ProductPage productPage = new ProductPage();
    @Given("The user is on the login page")
    public void the_user_is_on_the_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));
    }
    @When("The user enters valid credentials")
    public void the_user_enters_valid_credentials() {
        loginPage.loginMethod();

    }
    @Then("Verify {string}")
    public void verify(String expectedUserWelcomeMessage) {
        productPage.verifyLogin_method(expectedUserWelcomeMessage);
    }

    @When("The user enters username {string} and password {string} and clicks login button")
    public void theUserEntersUsernameAndPasswordAndClicksLoginButton(String username, String password) {
        loginPage.loginMethod(username,password);

    }

    @When("The user enters valid username and password and clicks login button")
    public void the_user_enters_valid_username_and_password_and_clicks_login_button(Map<String,String> credentials) {
        loginPage.loginMethod(credentials.get("username"),credentials.get("password"));
    }


    @Then("Verify that invalid {string}")
    public void verifyThatInvalid(String expectedMessage) {
        loginPage.verifyNegativeLoginMessage(expectedMessage);

    }
}
