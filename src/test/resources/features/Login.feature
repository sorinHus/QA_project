Feature: Login Flow

  @logPoz
  Scenario: Successful Login
    Given customer is on the homePage
    When customer enters valid credentials
    Then customer should be redirected to the account overview page

  @logNeg
  Scenario: missing username
    Given customer is on the homePage
    When customer enters valid password
    Then customer should see error message for missing username

  @logNeg
  Scenario: missing password
    Given customer is on the homePage
    When customer enters valid username
    Then customer should see error message for missing password

  @logNeg
  Scenario: invalid password
    Given customer is on the homePage
    When customer enters valid username and invalid password
    Then customer should see error message invalid credentials

  @logNeg
  Scenario: invalid username
    Given customer is on the homePage
    When customer enters invalid username
    Then customer should see error message invalid credentials