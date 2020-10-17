Feature: Register Player User

  Scenario Outline: Registering a new Player User
    Given I have <registered> existing account
    When I go to register as a player with <username>
    Then I should see <response> response screen
    And I should see <registered username> my username
    Examples:
    |registered|username|response|registered username|
    |false     |"sadaakisz"|"successful"|"sadaakisz"        |
    |true      |"tupapipro"|"failed"   |""                 |
    |false     |"empeleycal"|"successful"|"empeleycal"     |
    |true      |"oserigez"|"failed"   |""                 |
    |false     |"calixto21"|"successful"|"calixto21"     |