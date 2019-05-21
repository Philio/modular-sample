Feature: Login

  Scenario Outline: Login with correct credentials
    Given I have a LoginActivity
    When I enter the username <username>
    And I enter the password <password>
    And I press the login button
    Then I should see a snackbar with a welcome message for <username>

  Examples:
    | username | password |
    | test     | pa55w0rd |