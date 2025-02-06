Feature: open new account

  Scenario: Successful operation
    Given customer is on the Homepage
    When customer enters valid Credentials
    And clicks Open New Account link
    And clicks Open New Account button
    Then customer will see Account opened confirmation