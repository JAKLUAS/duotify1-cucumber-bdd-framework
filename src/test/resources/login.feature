Feature: User login feature








  Scenario: Registered user login positive
    When I enter lara.alissa as a username and lara12345 as password
    Then I should be able to login successfully


  @login
  Scenario: Registered user login positive parametrized
    When I enter "lara.alissa" as a username and "lara12345" as password
    Then I should be able to login successfully


  @login
  Scenario: Registered user login positive parametrized
    When I enter "majd.aslan" as a username and "majd12345" as password
    Then I should be able to login successfully

  @login
  Scenario: Registered user login positive parametrized
    When I enter "halil.dikmen" as a username and "halil12345" as password
    Then I should be able to login successfully



  @parametrized
  Scenario:  scenario for passinf different parameter type
    Given I have 5 cucumbers
    When I add 20 more and change the weight to 1.8 pounds
    Then I should have 25 cucumbers

  @parametrized
  Scenario: Example scenario for passing different parameter type
    Given I have 105 cucumbers
    When I add 50 more and change the weight to 1.8 pounds
    Then I should have 155 cucumbers


