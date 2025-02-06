Feature: Login Flow

  Scenario: Successful Login
    Given customer is on the homePage
    When customer enters valid credentials
    Then customer should be redirected to the account overview page

  Scenario: missing username
    Given customer is on the homePage
    When customer enters valid password
    Then customer should error message for missing username

  Scenario: missing password
    Given customer is on the homePage
    When customer enters valid username
    Then customer should error message for missing password