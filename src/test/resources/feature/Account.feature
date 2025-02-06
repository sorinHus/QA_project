Feature: Account operations

  Scenario: Open new account
    Given customer is on the Homepage
    When customer is logged in with valid Credentials
    And customer clicks Open New Account link
    And customer clicks Open New Account button
    Then customer will see Account opened confirmation

  Scenario: Successful application for loan
    Given customer is on the Homepage
    When customer is logged in with valid Credentials
    And customer clicks Request loan link
    And customer fills in the form
    And customer clicks the Apply now button
    Then customer will see Loan Request confirmation

  Scenario: Successful logging out
    Given customer is on the Homepage
    When customer is logged in with valid Credentials
    And customer clicks Log out link
    Then customer is logged out