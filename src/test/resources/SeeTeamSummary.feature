Feature: See Team Summary

  Scenario Outline: See a Team Summary
    Given I have <register> account registered
    And I have logged in with an <username>
    And I select the option of Search Teams
    And I have registered <f_amount> filters
    When I see a <Team> that interest me
    Then I should be able to see a <summary> of the team
    Examples:
    |register  |username |f_amount|Team         |summary                         |
    |"an"       |"Empe"   |"3"       |"Overthimker"|"Professional Project+ players" |
    |"an"       |"eightRB"|"5"       |"Wapo"       |"Professional Fall Guys players"|
    |"no"       |"error"|"error"       |"error"       |"error"|


