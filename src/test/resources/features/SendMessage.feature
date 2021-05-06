Feature: Send Message

  Scenario Outline: Send a message to a player who has been chosen
    Given I'm a <registered> User
    And I've <logged in>
    And I have made the search for players according to the filters selected
    When I select a <player username> that could complete my team and be my new friend
    Then I send to <player username> a message that says <message>

    Examples:
      |registered      |logged in   |player username|message                                         |
      |"Not registered"|"Logged out"|"nobody"       |"nothing"                                       |
      |"Registered"    |"Logged out"|"nobody"       |"nothing"                                       |
      |"Registered"    |"Logged in" |"ElPePe"       |"Hey bro, do you want to play with me?"         |
      |"Registered"    |"Logged in" |"Chamito"      |"Hi Chamito, do you want to be part of my team?"|
      |"Registered"    |"Logged in" |"Roro8rb"      |"Are you ready to win? "                        |