Feature: Login Flow

  Scenario: Successful Login
    Given customer is on the homePage
    When customer enters valid credentials
    Then customer should be redirected to the account overview page

  Scenario: missing username
    Given customer is on the homePage
    When customer enters valid password
    Then customer should see error message for missing username

  Scenario: missing password
    Given customer is on the homePage
    When customer enters valid username
    Then customer should see error message for missing password

  Scenario: invalid password
    Given customer is on the homePage
    When customer enters valid username and invalid password
    Then customer should see error message invalid credentials

  Scenario: invalid username
    Given customer is on the homePage
    When customer enters invalid username
    Then customer should see error message invalid credentials