package utils;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Objects;


import static io.restassured.RestAssured.given;

public class RestUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(RestUtils.class);
    public static RequestSpecification requestSpecification;
    public static Response response;

    public RestUtils() throws IOException {
    }

    public JsonObject readJsonFile(String fileName) throws IOException {
        JsonParser parser = new JsonParser();
        try (InputStreamReader reader = new InputStreamReader(
                Objects.requireNonNull(RestUtils.class.getClassLoader().getResourceAsStream(fileName + ".json")),
                StandardCharsets.UTF_8
        )) {
            JsonElement jsonElement = parser.parse(reader);
            return jsonElement.getAsJsonObject();
        }
    }


    public static void setBaseUrl(String baseUrl) {
        RestAssured.baseURI = baseUrl;
        requestSpecification = given();
        LOGGER.info("Sending request to endpoint: {}", RestAssured.baseURI);
    }

    public static void setBasePath(String basePath) {
        RestAssured.basePath = basePath;
        requestSpecification = given();
        LOGGER.info("Sending request to endpoint: {}", RestAssured.basePath);
    }

    public static void setContentType(String contentType) {
        requestSpecification.contentType(contentType);
    }


    public static Response performPostRequest(String payload) throws IOException {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        JsonObject bodyPayload = new RestUtils().readJsonFile(payload);
        requestSpecification.body(bodyPayload.toString());
        response = requestSpecification.post(RestAssured.basePath);
        response.then().log().all();
        LOGGER.info("Post URL: {}", RestAssured.baseURI + RestAssured.basePath);
        LOGGER.info("Post body: {}", RestAssured.requestSpecification);
        LOGGER.info("Received response status code: {}", response.getStatusCode());
        return response;
    }

    public static Response performPutRequest(String payload) throws IOException {
        JsonObject bodyPayload = new RestUtils().readJsonFile(payload);
        response = requestSpecification.when().body(bodyPayload.toString()).put(RestAssured.basePath).then().extract().response();
        response.then().log().all();
        LOGGER.info("Put URL: {}", RestAssured.baseURI + RestAssured.basePath);
        LOGGER.info("Received response status code: {}", response.getStatusCode());
        return response;
    }

    public static Response performDeleteRequest() {
        response = requestSpecification.when().delete(RestAssured.basePath).then().extract().response();
        response.then().log().all();
        LOGGER.info("Delete URL: {}", RestAssured.baseURI + RestAssured.basePath);
        LOGGER.info("Received response status code: {}", response.getStatusCode());
        return response;
    }

    public static Response performGetRequest() {
        response = requestSpecification.when().get(RestAssured.baseURI + RestAssured.basePath);
        response.then().log().all();
        LOGGER.info("Get URL: {}", RestAssured.baseURI + RestAssured.basePath);
        LOGGER.info("Received response status code: {}", response.getStatusCode());
        return response;
    }


}
