
Feature: A feature

  Background:
    Given I am on the home page


@smoke
  Scenario: A feature files scenario

    When I navigate to singup page and enter valid credentials.
    Then I should be able to sing up successfully

  @signup
  Scenario: A feature files scenario 2
    When I navigate to singup page and enter valid credentials.
    Then I should be able to sing up successfully

