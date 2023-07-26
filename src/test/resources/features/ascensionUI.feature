Feature: Ascension POC

  Scenario: Create a Task
    Given I navigate to Ascension page
    When I click the login button
    When I enter "Amirtaraj" into username input field
    When I enter "amirt@123" into password input field
    When I click the signin button
    Then I wait for 5 seconds
    When I click View my Task link