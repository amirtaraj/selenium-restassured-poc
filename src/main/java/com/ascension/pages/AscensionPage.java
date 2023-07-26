package com.ascension.pages;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.openqa.selenium.By;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
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



}
