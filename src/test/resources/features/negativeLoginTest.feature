@negativeLoginTest
Feature: Negative Login Test - The user should not be able to login with invalid credentials

  Background: Go to homepage login
    Given The user is on the login page

  Scenario Outline: Negative Scenario - The user should not be able to login with invalid credentials
    When The user enters username "<invalidUsername>" and password "<inValidpassword>" and clicks login button
    Then Verify that invalid "<message>"
    Examples:
      | invalidUsername | inValidpassword | message                                |
      | nested4         |                 | Please fill out Username and Password. |
      |                 | password        | Please fill out Username and Password. |
      |                 | invalidPassword | Please fill out Username and Password. |
      | nested4         | invalidPassword | Wrong password.                        |
      | invalidUsername | invalidPassword | User does not exist.                   |
      |                 |                 | Please fill out Username and Password. |