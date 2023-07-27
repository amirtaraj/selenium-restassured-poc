package com.ascension.pages;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.openqa.selenium.By;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class AscensionPage {
    private final WebDriver driver;
    private final Map<String, PageElements> elements;
    private final Logger log = LoggerFactory.getLogger(AscensionPage.class);

    public AscensionPage(WebDriver driver) throws IOException {
        this.driver = driver;
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        File yamlFile = new File("src/main/resources/page_elements.yaml");

        // Mapping the YAML file to a Map of PageElements
        elements = mapper.readValue(yamlFile, new TypeReference<Map<String, PageElements>>() {});
    }

    public void navigateToAscension() {
        // Read the base URL from the JSON file
        String baseUrl = null;
        try {
            baseUrl = readBaseUrlFromJson();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        driver.get(baseUrl);
        log.info("Navigated to Ascension");
    }

    // Method to read the base URL from the JSON file
    private String readBaseUrlFromJson() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File jsonFile = new File("src/main/resources/config.json");
        Map<String, String> jsonContent = mapper.readValue(jsonFile, new TypeReference<Map<String, String>>() {});
        return jsonContent.get("baseUrl");
    }

    public void clickLoginButton() {
        // Check if the key exists in the elements map before accessing its properties
        if (elements.containsKey("LoginButton")) {
            String id = elements.get("LoginButton").getId();
            driver.findElement(By.id(id)).click();
            log.info("Clicked login button");
        } else {
            log.error("LoginButton not found in page_elements.yaml");
        }
    }

    public void enterUsername(String username) {
        // Check if the key exists in the elements map before accessing its properties
        if (elements.containsKey("UsernameField")) {
            String id = elements.get("UsernameField").getId();
            driver.findElement(By.id(id)).sendKeys(username);
            log.info("Entered User name");
        } else {
            log.error("User name element not found in page_elements.yaml");
        }
    }

    public void enterPassword(String password) {
        // Check if the key exists in the elements map before accessing its properties
        if (elements.containsKey("PasswordField")) {
            String id = elements.get("PasswordField").getId();
            driver.findElement(By.id(id)).sendKeys(password);
            log.info("Entered Password");
        } else {
            log.error("Password element not found in page_elements.yaml");
        }
    }

    public void clickSignInButton() {
        // Check if the key exists in the elements map before accessing its properties
        if (elements.containsKey("SignInButton")) {
            String id = elements.get("SignInButton").getId();
            driver.findElement(By.id(id)).click();
            log.info("Clicked Sign in button");
        } else {
            log.error("Sign in not found in page_elements.yaml");
        }
    }

    public void clickViewMyTask() {
        // Check if the key exists in the elements map before accessing its properties
        if (elements.containsKey("viewMyTaskLink")) {
            String id = elements.get("viewMyTaskLink").getId();
            driver.findElement(By.id(id)).click();
            log.info("viewMyTaskLink");
        } else {
            log.error("viewMyTaskLink not found in page_elements.yaml");
        }
    }

    public void addNewTask() {
        // Check if the key exists in the elements map before accessing its properties
        if (elements.containsKey("addNewTaskLink")) {
            String id = elements.get("addNewTaskLink").getId();
            driver.findElement(By.id(id)).click();
            log.info("addNewTaskLink");
        } else {
            log.error("addNewTaskLink not found in page_elements.yaml");
        }
    }

    public void enterTitle(String title) {
        // Check if the key exists in the elements map before accessing its properties
        if (elements.containsKey("titleField")) {
            String id = elements.get("titleField").getId();
            driver.findElement(By.id(id)).sendKeys(title);
            log.info("titleField");
        } else {
            log.error("titleField element not found in page_elements.yaml");
        }
    }

    public void enterText(String text) {
        // Check if the key exists in the elements map before accessing its properties
        if (elements.containsKey("textField")) {
            String id = elements.get("textField").getId();
            driver.findElement(By.id(id)).sendKeys(text);
            log.info("textField");
        } else {
            log.error("textField element not found in page_elements.yaml");
        }
    }

    public void dropdownSelect(String optionText) {
        // Check if the key exists in the elements map before accessing its properties
        if (elements.containsKey("usernameDropdown")) {
            String id = elements.get("usernameDropdown").getId();
            Select dropdown = new Select(driver.findElement(By.id(id)));
            dropdown.selectByVisibleText(optionText); // Select the option by visible text
            log.info("Selected option from usernameDropdown: " + optionText);
        } else {
            log.error("usernameDropdown element not found in page_elements.yaml");
        }
    }

    public void saveTask() {
        // Check if the key exists in the elements map before accessing its properties
        if (elements.containsKey("saveButton")) {
            String id = elements.get("saveButton").getId();
            driver.findElement(By.id(id)).click();
            log.info("saveButton");
        } else {
            log.error("saveButton not found in page_elements.yaml");
        }
    }

    public void homeClick() {
        // Check if the key exists in the elements map before accessing its properties
        if (elements.containsKey("homeButton")) {
            String id = elements.get("homeButton").getId();
            driver.findElement(By.id(id)).click();
            log.info("homeButton");
        } else {
            log.error("homeButton not found in page_elements.yaml");
        }
    }

    public void logoutClick() {
        // Check if the key exists in the elements map before accessing its properties
        if (elements.containsKey("logoutButton")) {
            String id = elements.get("logoutButton").getId();
            driver.findElement(By.id(id)).click();
            log.info("logoutButton");
        } else {
            log.error("logoutButton not found in page_elements.yaml");
        }
    }

}
