Feature: Database metadata scenarios


  @db_only
  Scenario: Verify the column names for albums table
    When  I send a request to retrieve colum names for albums table
    Then It should be the following

      | id          |
      | title       |
      | artist      |
      | genre       |
      | artworkPath |

  @metadata
  Scenario: Verify the title column length of albums table
    When  I send a request to add a new title that is more than the expected length of 250
    Then  The data should be truncated to the expected length






