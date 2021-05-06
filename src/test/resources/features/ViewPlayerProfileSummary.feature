Feature: View Profile summary of the found Player

  Scenario Outline: Viewing summary of the found Player's Profile
    Given I am <registered> user
    And I am <loggedIn>
    And I have selected the filters
    When I click <fillMyTeam>
    Then I see a list of <profileSummaries>

    Examples:
      |registered     |loggedIn   |fillMyTeam     |profileSummaries |
      |1              |1          |1              |1                |
      |1              |1          |1              |1                |
      |1              |1          |1              |1                |
      |1              |0          |1              |0                |
      |0              |0          |1              |0                |
      |0              |0          |0              |0                |