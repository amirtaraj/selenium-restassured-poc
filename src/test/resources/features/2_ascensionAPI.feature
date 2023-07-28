Feature: Ascension API Automation POC

  @get
  Scenario: Get and validate the Task created
    Given I have set the "base_url"
    And I have set the content type to "application"
    And I have set the path "notes"
    When I perform a GET request
    Then I should receive a response with status code 200
    Then I should get "title[4]" as "Ascension Demo Test Title"
    Then I should get "text[4]" as "Ascension Demo Test Text"
