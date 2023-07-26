package com.ascension.pages;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.openqa.selenium.By;

import java.io.FileInputStream;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yaml.snakeyaml.Yaml;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.io.File;


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
        driver.get("https://amirtask-app.onrender.com/"); // Provide URL here (can be put to yaml once working)
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

}