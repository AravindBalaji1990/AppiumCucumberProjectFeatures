Feature:  Validate the login for Swag lab app

  Background:
    Given User opens the swaglab app


  @swaglab
  Scenario Outline: validate the different sets of data but with same scenario with data <username>
    When User enters the <username> and <password>
    And User validates the dashbaord of the app

    Examples:
      | username        | password     |
      | standard_user   | secret_sauce |
      | locked_out_user | secret_sauce |
      | problem_user    | secret_sauce |