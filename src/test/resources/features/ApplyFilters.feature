Feature: Apply Search Filters

  Scenario Outline: Applying filters for player search
    Given I am: <amRegistered>
    And my login state is <login>
    And my initial found players list length is <initial size>
    When I enter <number_of_filters> filters
    And A found player has <matching> filters
    Then my found players list should be <final size>
    Examples:
    |amRegistered    |login       |initial size|number_of_filters|matching|final size|
    |"Registered"    |"Logged in" |0           |3      |3       |1         |
    |"Not registered"|"Logged out"|0           |0      |0       |0         |
    |"Registered"    |"Logged in" |5           |4      |4       |6         |
    |"Registered"    |"Logged in" |6           |1      |1       |7         |
    |"Registered"    |"Logged in" |8           |4      |2       |8         |
    |"Registered"    |"Logged out"|0           |0      |0       |0         |
