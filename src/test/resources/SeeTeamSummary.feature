Feature: See Team Summary

  Scenario Outline: See a Team Summary
    Given I have my account <register>
    And I have my account <username> logged in
    And I search for Teams
    And I have inputted <f_amount> filters
    When I see a <Team> that caught my attention
    Then I should be able to see a <summary> of the team
    Examples:
    |register  |username |f_amount|Team         |summary                         |
    |"an"       |"Empe"   |"3"       |"Overthimker"|"Professional Project+ players" |
    |"an"       |"eightRB"|"5"       |"Wapo"       |"Professional Fall Guys players"|
    |"no"       |"error"|"error"       |"error"       |"error"|


