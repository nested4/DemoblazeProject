Feature: Login Test - The user should be able to login with valid credentials

  Scenario: Positive Scenario 1 - user should be able to login
    Given The user is on the login page
    When The user enters valid credentials
    Then Verify "Welcome nested4"