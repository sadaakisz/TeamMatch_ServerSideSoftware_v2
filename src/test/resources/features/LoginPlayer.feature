Feature: Login Player User

  Scenario Outline: Logging in as an existing Player User
    Given I have <registered> existing account with <registered username> and with <registered password>
    When I go to log in as a player with <username> username
    And I go to log in as a player with <password> password
    Then I should see <response> log in response screen
    Examples:
      |registered|registered username|registered password|username|password|response|
      |true      |"sadaakisz"        |"password123"      |"sadaakisz"|"password123"|"successful"|
      |false      |""        |""      |"juanleycal"|"123contras"|"account doesn't exist"|
      |true      |"marceloomar"        |"omarreyma"      |"marceloomar"|"omarreyma2"|"password doesn't match"|
      |true      |"8rb"        |"3122252"      |"johndoe"|"3122252"|"account doesn't exist"|
      |true      |"scenario5"        |"scenario5pas"      |"scenario5"|"scenario5pas"|"successful"|