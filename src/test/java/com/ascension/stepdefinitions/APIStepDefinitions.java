package com.ascension.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import utils.ConfigUtils;
import utils.RestUtils;
import io.restassured.response.Response;
import static org.junit.Assert.assertEquals;
import java.io.IOException;


public class APIStepDefinitions {
    private Response response;

    @When("I perform a GET request")
    public void getRequest(){
        response = RestUtils.performGetRequest();
    }

    @Given("I have set the {string}")
    public void setBaseUrl(String base_url) {
        String baseUrl = ConfigUtils.getProperties(base_url);
        RestUtils.setBaseUrl(baseUrl);
    }

    @Given("I have set the path {string}")
    public void setBasePath(String base_path) {
        String basePath = ConfigUtils.getProperties(base_path + "_path");
        RestUtils.setBasePath(basePath);
    }

    @Given("I have set the path {string} with param {string}")
    public void setBasePathWithParam(String base_path, String param) {
        String path = ConfigUtils.getProperties(base_path + "_path");
        String basePath = path + "/" + param;
        RestUtils.setBasePath(basePath);
    }

    @Given("I have set the content type to {string}")
    public void setContentType(String content_type) {
        String contentType;
        if (content_type.equals("application")) {
            contentType = ConfigUtils.getProperties("content_type");
        } else {
            contentType = ConfigUtils.getProperties(content_type);
        }
        RestUtils.setContentType(contentType);
    }

    @Then("I should receive a response with status code {int}")
    public void checkStatusCode(int expectedStatusCode) {
        assertEquals(expectedStatusCode, RestUtils.response.getStatusCode());
    }

    @When("I perform a POST request to with payload {string}")
    public void performPostRequest(String payload) throws IOException {
        RestUtils.performPostRequest(payload);
    }

    @When("I perform a PUT request to with payload {string}")
    public void putRequest(String payload) throws IOException {
        response = RestUtils.performPutRequest(payload);
    }

    @When("I perform a DELETE request")
    public void deleteRequest(){
        response = RestUtils.performDeleteRequest();
    }



}