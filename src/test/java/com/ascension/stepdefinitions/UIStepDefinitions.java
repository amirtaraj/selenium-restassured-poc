package com.ascension.stepdefinitions;

import com.ascension.pages.AscensionPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;


public class UIStepDefinitions {

    private WebDriver driver;
    private AscensionPage ascensionPage;

    @Given("I navigate to Ascension page")
    public void iNavigateToAscensionPage() { // navigate to URL step definition
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        try {
            ascensionPage = new AscensionPage(driver);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ascensionPage.navigateToAscension();
    }

    @When("I click the login button") // login step definition
    public void iClickTheLoginButton() {
        ascensionPage.clickLoginButton();
        throw new io.cucumber.java.PendingException();
    }


    @When("I enter {string} into username field")
    public void iEnterIntoUsernameField(String username) {
        ascensionPage.username();
    }
}