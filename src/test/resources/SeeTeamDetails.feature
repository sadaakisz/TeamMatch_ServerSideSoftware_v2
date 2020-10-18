Feature: See a Team Description in more detail

  Scenario Outline: See a Team in detail
    Given I have <register> account registered
    And I have logged in with an <username>
    And I select the option of Search Teams
    And I have registered <f_amount> filters
    And I see a <Team> that interest me
    When I choose the team that I want to see details about
    Then I should be able to see <details> of the team

    Examples:
      |register   |username |f_amount  |Team         |details                         |
      |"an"       |"Empe"   |"3"       |"Overthimker"   |"A lot of details" |
      |"an"       |"eightRB"|"5"       |"Wapo"          |"A lot of details"                              |
      |"no"       |"error"  |"error"   |"error"          |"error"                         |