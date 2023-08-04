Feature: Ascension API Automation POC


  @getAllPatients
  Scenario: To view all patients
    Given user has access to endpoint "/patients"
    When user makes a request to view all Patients
    Then user should get the response code 200

  @savePatient
  Scenario: To save a new Patient using JSON data
    Given user has access to endpoint "/patient"
    When user saves a patient from JSON file "savePatientBody.json"
    Then user should get the response code 200

  @getPatient
  Scenario: To view a patient with Id
    Given user has access to endpoint "/patient" with param "x"
    When user makes a request to view all Patients
    Then user should get the response code 200
