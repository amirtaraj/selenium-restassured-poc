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
import java.util.concurrent.TimeUnit;


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
    }


    @When("I enter {string} into username input field")
    public void iEnterIntoUsernameInputField(String username) {
        ascensionPage.enterUsername(username);
    }

    @When("I enter {string} into password input field")
    public void iEnterIntoPasswordInputField(String password) {
        ascensionPage.enterPassword(password);
    }

    @When("I click the signin button")
    public void iClickTheSigninButton() {
        ascensionPage.clickSignInButton();
    }

    @When("I click View my Task link")
    public void iClickViewMyTaskLink() {
        ascensionPage.clickViewMyTask();
    }




    @Then("I wait for {int} seconds")
    public void i_wait_for_seconds(Integer seconds)  {
        try {
            Thread.sleep(TimeUnit.SECONDS.toMillis(seconds));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @When("I click Add New Task link")
    public void i_click_add_new_task_link() {
        ascensionPage.addNewTask();
    }

    @When("I enter {string} into title input field")
    public void iEnterIntoTitleInputField(String title) {
        ascensionPage.enterTitle(title);
    }

    @When("I enter {string} into text input field")
    public void iEnterIntoTextInputField(String text) {
        ascensionPage.enterText(text);
    }

    @When("I select {string} option from username dropdown")
    public void iSelectOptionFromUsernameDropdown(String optionText) {
        ascensionPage.dropdownSelect(optionText);
    }

    @When("I click the save button")
    public void iClickTheSaveButton() {
        ascensionPage.saveTask();
    }

    @When("I click the home button")
    public void iClickTheHomeButton() {
        ascensionPage.homeClick();
    }

    @When("I click the logout button")
    public void iClickTheLogoutButton() {
        ascensionPage.logoutClick();
    }
}