package com.ascension.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.hamcrest.Matchers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.ConfigUtils;
import utils.JsonReader;
import utils.RestUtils;
import io.restassured.response.Response;
import utils.TestContext;

import static org.junit.Assert.assertEquals;
import java.io.IOException;


public class APIStepDefinitions {
    private Response response;
    private final TestContext context;

    public APIStepDefinitions(TestContext context) {
        this.context = context;
    }

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

    @Given("user has access to endpoint {string}")
    public void userHasAccessToEndpoint(String endpoint) {
        context.session.put("endpoint", endpoint);
    }

    @Given("user has access to endpoint {string} with param {string}")
    public void userHasAccessToEndpointWithParam(String endpoint, String param) {
        String fullEndpoint = endpoint + "/" + param;
        context.session.put("endpoint", fullEndpoint);
    }

    @When("user makes a request to view all Patients")
    public void userMakesARequestToViewBookingIDs() {
        context.response = context.requestSetup().when().get(context.session.get("endpoint").toString());
    }

    @Then("user should get the response code {int}")
    public void userShpuldGetTheResponseCode(Integer statusCode) {
        assertEquals(Long.valueOf(statusCode), Long.valueOf(context.response.getStatusCode()));
    }

    @When("user saves a patient from JSON file {string}")
    public void userCreatesABookingUsingDataFromJSONFile(String JSONFile) {
        context.response = context.requestSetup().body(JsonReader.getRequestBody(JSONFile))
                .when().post(context.session.get("endpoint").toString());
    }





    @Then("^I should get \"([^\"]*)\" as \"([^\"]*)\"$")
    public void validateFieldValue(String field, String expectedValue) {
        String jsonPath = field.replaceAll("\"", "");
        Logger logger = LoggerFactory.getLogger(getClass());
        context.response.then().assertThat().body(jsonPath, Matchers.equalTo(expectedValue));
        logger.info("Validating field '{}' with expected value: Expected='{}', Actual='{}'", jsonPath, expectedValue, context.response.jsonPath().getString(jsonPath));
    }


}