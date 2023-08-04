package utils;

import com.github.dzieciou.testing.curl.CurlRestAssuredConfigFactory;
import com.github.dzieciou.testing.curl.Options;
import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ConfigUtils {
    private static final Properties configProperties = new Properties();

    static {
        try {
            FileInputStream fis = new FileInputStream("src/main/resources/api_config.properties");
            configProperties.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getBaseUrl() {
        return configProperties.getProperty("base_url");
    }

    public static String notes_path() {
        return configProperties.getProperty("notes_path");
    }

    public static String getProperties(String keyName) {
        return configProperties.getProperty(keyName);
    }

}
