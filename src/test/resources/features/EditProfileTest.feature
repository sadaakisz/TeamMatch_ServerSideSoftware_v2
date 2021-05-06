Feature: Edit Profile

  Scenario Outline: Modifying player username
    Given My username is <opening username>
    And I want to modify it to <new username>
    When I go to Edit Profile
    Then My username should be <username>
    Examples:
      |opening username|new username|username     |
      |"tupapipro"     |"papipro"   |"papipro"    |
      |"vilaron"       |"reymarcelo"|"reymarcelo" |
      |"calixto"       |"calixto_21"|"calixto_21" |