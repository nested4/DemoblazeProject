@wip
Feature: Login Test - The user should be able to login with valid credentials

  Background: Go to homepage login
    Given The user is on the login page

  @loginWithoutParameters
  Scenario: Positive Scenario 1 - user should be able to login
    When The user enters valid credentials
    Then Verify "Welcome nested4"

  @loginWithParameters
  Scenario: Positive Scenario 2 - user should be able to login with parameters
    When The user enters username "nested4" and password "password" and clicks login button
    Then Verify "Welcome nested4"

  @loginWithScenarioOutline
  Scenario Outline: Positive Scenario 3 - user should be able to login with Scenario Outline
    When The user enters username "<username>" and password "<password>" and clicks login button
    Then Verify "<Welcome username>"
    Examples:
      | username | password | Welcome username |
      | nested4  | password | Welcome nested4  |

  @loginWithDataTableAndScenarioOutline
  Scenario Outline: Positive Scenario 4 - user should be able to login
    When The user enters valid username and password and clicks login button
      | username | <username> |
      | password | <password> |
    Then Verify "<Welcome username>"

    Then Verify "<Welcome username>"
    Examples:
      | username | password | Welcome username |
      | nested4  | password | Welcome nested4  |
      | ktb2     | Test1234 | Welcome ktb2     |




