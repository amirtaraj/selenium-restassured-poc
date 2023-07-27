Feature: Ascension API Automation POC

  @get
  Scenario: Example Get Scenario
    Given I have set the "base_url"
    And I have set the content type to "application"
    And I have set the path "notes"
    When I perform a GET request
    Then I should receive a response with status code 200

  @post
  Scenario: Example Post Scenario
    Given I have set the "base_url"
    And I have set the content type to "application"
    And I have set the path "notes"
    When I perform a POST request to with payload "post_request"
    Then I should receive a response with status code 201