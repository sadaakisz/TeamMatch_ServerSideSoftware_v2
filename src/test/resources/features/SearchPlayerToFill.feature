Feature: Search for a player to fill an existing team

  Scenario Outline: Searching for a player
    Given I am a <logged>
    And I have an incomplete team with <members>
    And I need a <total> of members
    When I search for <teamMembers>
    Then I would have my team complete

    Examples:
      |logged    |members  |total    |teamMembers |
      |1         |2        |4        |2           |
      |1         |1        |2        |1           |
      |0         |1        |3        |2           |
      |1         |2        |6        |4           |
      |1         |3        |4        |1           |
      |0         |5        |6        |1           |