Feature: Data-Mapping scenarios


  @data_mapping_ui_to_db
  Scenario: New User Sign Up from UI to DB flow
    Given I am on the home page
    And I navigate to signup page
    When  I enter the following credentials as list of map
      | username | firstname | lastname | email            | password   |
      | ray.ban  | Ray       | Ban      | rayban@gmail.com | rayban2022 |
    Then I should be able to sing up successfully
    And The database should also have correctly mapped info
      | username | firstname | lastname | email            | password   |
      | ray.ban  | Ray       | Ban      | rayban@gmail.com | rayban2022 |






    @data_mapping_db_to_ui
    Scenario: New User Creation, verify data mapping DB to UI flow
      When I add a new user to the database with the following info
        | username  | first | last | email               | password    |
        | peppapig0 | Peppa | Pig | peppapig0@gmail.com | peppapig99 |
      Then I should be able to log in with the same credentials on the UI
      And  The firstname, lastname and email also should be correct