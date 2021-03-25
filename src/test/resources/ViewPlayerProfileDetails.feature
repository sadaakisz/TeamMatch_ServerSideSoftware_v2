Feature: View Player Profile Details

  Scenario Outline: View details of a player profile that was found
    Given I am a <registered> User
    And I have <logged in>
    And I have made the search for players according to my filters
    When I select a <player username> that could complete my team
    Then I see <player username> is <profile details>

    Examples:
      |registered      |logged in   |player username|profile details|
      |"Not registered"|"Logged out"|"nobody"       |"unknown"              |
      |"Registered"    |"Logged out"|"nobody"       |"unknown"              |
      |"Registered"    |"Logged in" |"ElPePe"       |"18 years old and male"|
      |"Registered"    |"Logged in" |"Chamito"      |"23 years old and male"|
      |"Registered"    |"Logged in" |"Roro8rb"      |"20 years old and male"|
