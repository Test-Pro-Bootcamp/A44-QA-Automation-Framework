Feature: Login Tests

  Scenario: Login Success
    Given I open Login Page
    When I enter email
    And I enter password
    And I click submit
    Then I am logged in

  Scenario: LoginWrongEmail
    Given I open Login Page
    When I enter wrong email
    And I enter password
    And I click submit
    Then I am not logged in