Feature: Login
  Scenario: Login Success
    Given User open saucedemo website
    When User input valid username and password
    And User click login button
    Then Dashboard Success Login Page is Displayed