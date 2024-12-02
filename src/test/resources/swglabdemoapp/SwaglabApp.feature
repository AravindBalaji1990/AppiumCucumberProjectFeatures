Feature:  Validate the login for Swag lab app

  @swaglab
  Scenario Outline: validate the different sets of data but with same scenario
    Given User opens the swaglab app
    And User enters the <username> and <password>
    Then User validates the dashbaord of the app
    Then User close the swaglab app

    Examples:
      | username        | password     |
      | standard_user   | secret_sauce |
      | locked_out_user | secret_sauce |
      | problem_user    | secret_sauce |