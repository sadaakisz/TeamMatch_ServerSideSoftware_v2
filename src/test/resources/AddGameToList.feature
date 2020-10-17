Feature: Add Game to List

  Scenario Outline: Adding a game
    Given I have <opening list size> games in my list
    And I want to add <new game> to my games
    When I go to Add Game
    Then My game list should have <list size> games
    Examples:
      |opening list size|new game     |list size|
      |0                |"Fortnite"   |1        |
      |2                |"Lol"        |3        |
      |5                |"Dota"       |6        |