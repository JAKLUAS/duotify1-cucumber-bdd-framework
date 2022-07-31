
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

  @album
  Scenario: Verify homepage album names

    When I enter "lara.alissa" as a username and "lara12345" as password
    Then The names of the albums should be the following
      | Werk                |
      | Fenix               |
      | I Am...Sasha Fierce |
      | Ultimatum           |
      | Oscillation         |
      | Marisa              |
      | Clouds              |
      | Cruel Summer        |
      | Escape              |