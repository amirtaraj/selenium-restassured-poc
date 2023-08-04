Feature: Ascension API Automation POC


  @getAllPatients
  Scenario: To view all patients
    Given user has access to endpoint "/patients"
    When user makes a request to view all Patients
    Then user should get the response code 200
    Then I should get "id[4]" as "007"
    Then I should get "firstName[3]" as "name1"

  @savePatient
  Scenario: To save a new Patient using JSON data
    Given user has access to endpoint "/patient"
    When user saves a patient from JSON file "savePatientBody.json"
    Then user should get the response code 200
    Then I should get "id" as "304"
    Then I should get "email" as "amirtaraj_r@yahoo.co.in"

  @getPatient
  Scenario: To view a patient with Id
    Given user has access to endpoint "/patient" with param "x"
    When user makes a request to view all Patients
    Then user should get the response code 200
    Then I should get "id" as "x"
    Then I should get "timeSlot" as "2023-07-28T13:35:20.37"