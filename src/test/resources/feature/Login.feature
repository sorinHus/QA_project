Feature: Login Flow

  Scenario: Successful Login
    Given customer is on the homePage
    When customer enters valid credentials
    Then customer should be redirected to the account overview page