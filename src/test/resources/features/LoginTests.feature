Feature: Login Test

  Scenario: Login Success
    Given I open Login Page
    When I enter email
    And I enter password
    And I click submit button
    Then I am successfully logged in

    When I click play button
    Then I see pause button