Feature: Ascension UI Automation POC

  Scenario: Create a Task
    Given I navigate to Ascension page
    When I click the login button
    When I enter "Amirtaraj" into username input field
    When I enter "amirt@123" into password input field
    When I click the signin button
    Then I wait for 4 seconds
    When I click Add New Task link
    Then I wait for 2 seconds
    When I enter "Ascension Demo Test Title" into title input field
    When I enter "Ascension Demo Test Text" into text input field
    When I select "Amirtaraj" option from username dropdown
    When I click the save button
    Then I wait for 3 seconds
    When I click the home button
    When I click View my Task link
    Then I wait for 3 seconds
    When I click the logout button
