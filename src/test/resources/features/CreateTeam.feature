Feature: Create Team

  Scenario Outline: Creating a new team
    Given I am a <registered> user
    And I am <logged in>
    And I have <teams> teams
    When I enter team and game information
    Then I should have <new teams> teams
    Examples:
    |registered      |logged in   |teams|new teams|
    |"Not registered"|"Logged out"|0    |0        |
    |"Registered"    |"Logged out"|2    |2        |
    |"Registered"    |"Logged in" |3    |4        |
    |"Registered"    |"Logged in" |0    |1        |
    |"Registered"    |"Logged in" |2    |2        |

