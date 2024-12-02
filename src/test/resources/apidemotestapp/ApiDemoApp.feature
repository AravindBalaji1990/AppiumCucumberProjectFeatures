Feature: Validate the Api demo app
  validate the items NFC
  validate the item text

  Background:
    Given User opens the api demo application
    When User lands on the dashboard od the app


  Scenario: Validate the name Text is visible
    Then User checks Text field is available
    Then User close the app


  Scenario: validate the name text (parameterise the value)
    Then User validate the field to be verified "Text"
    Then User validate the field to be verified "Graphics"
    Then User close the app

  Scenario: validate the data using a table format (this can be used within a step)
    Then User validate the field to be verified with below table
      | field    |
      | Text     |
      | Graphics |
      | OS       |
    Then User close the app


