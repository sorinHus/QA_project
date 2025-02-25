Feature: Registration flow

  @Sanity
  Scenario: Successful registration
    Given customer is on the homepage
    And customer clicks on Register button
    When customer completes registration form using following data:
      | firstName    | Sorin        |
      | lastName     | Hus          |
      | address      | First Street |
      | city         | First City   |
      | state        | First State  |
      | zip_code     | 90000        |
      | phoneNumber  | 0750123456   |
      | SSN          | 123456789    |
      | password     | 123456       |
      | confPassword | 123456       |
    And customer clicks create account button
    Then customer should see a confirmation message

    @SmokeTest
  Scenario: Registration with missing required fields
    Given customer is on the homepage
    And customer clicks on Register button
    When customer completes registration form with missing data:
      | firstName    |               |
      | lastName     | Hus           |
      | address      | First Street  |
      | city         | First City    |
      | state        | First State   |
      | zip_code     | 90000         |
      | phoneNumber  | 0750123456    |
      | SSN          | 123456789     |
      | password     | 123456        |
      | confPassword | 123456        |
    And customer clicks on create account button
    Then customer should see an error message for the missing first name

      @SmokeTest
  Scenario: Registration with password mismatch
    Given customer is on the homepage
    And customer clicks on Register button
    When customer completes registration form with password mismatch:
      | firstName    | Sorin         |
      | lastName     | Hus           |
      | address      | First Street  |
      | city         | First City    |
      | state        | First State   |
      | zip_code     | 90000         |
      | phoneNumber  | 0750123456    |
      | SSN          | 123456789     |
      | password     | 123456        |
      | confPassword | 12345        |
    And customer clicks on register account button
    Then customer should see an error message for the mismatch