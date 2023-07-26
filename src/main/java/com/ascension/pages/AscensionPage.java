package com.ascension.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.io.InputStream;
import org.yaml.snakeyaml.Yaml;
import java.util.Map;
import static java.nio.file.Files.newInputStream;
import static java.nio.file.Paths.get;

public class AscensionPage {
    private final WebDriver driver;
    private final Map<String, String> pageElements;

    private final Logger log = LoggerFactory.getLogger(AscensionPage.class); // Enabled Logger

    public AscensionPage(WebDriver driver) throws IOException {
        this.driver = driver;
        this.pageElements = loadPageElements();
    }

    private Map<String, String> loadPageElements() throws IOException {
        InputStream inputStream = newInputStream(get("src/main/resources/page_elements.yaml"));
        Yaml yaml = new Yaml();
        return yaml.load(inputStream); // Use the method to access yaml file (NOT WORKING)
    }



    public void navigateToAscension() {
        driver.get("https://amirtask-app.onrender.com/"); // Provide URL here (can be put to yaml once working)
    }


    public void clickLoginButton() {
        log.info("ELEMENT CHECK  " + pageElements.get("loginButton.id")); //using logger than syso
        driver.findElement(By.id(pageElements.get("loginButton.id"))).click(); //Not working
        //driver.findElement(By.id("userLogin")).click(); //works directly
    }

    public void username() {
        driver.findElement(By.id("username")).sendKeys("username");
    }

}