package com.teammatch;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SendMessage {
    public String registered;
    public String logged_in;
    public String player_username;
    public String message;

    @Given("I'm a {string} User")
    public void imARegisteredUser(String registered) {
        this.registered = registered;
        if (registered.equals("Not registered")){
            this.logged_in = "Logged out";
        }
    }
    @And("I've {string}")
    public void iveLoggedIn(String logged_in) {
        this.logged_in = logged_in;
    }

    @And("I have made the search for players according to the filters selected")
    public void iHaveMadeTheSearchForPlayersAccordingToTheFiltersSelected() {
    }

    @When("I select a {string} that could complete my team and be my new friend")
    public void iSelectAPlayerUsernameThatCouldCompleteMyTeamAndBeMyNewFriend(String player_username) {
        this.player_username = player_username;
    }

    @Then("I send to {string} a message that says {string}")
    public void iSendToPlayerUsernameAMessageThatSaysMessage(String message, String player_username) {
        this.message = message;
        this.player_username = player_username;
    }
}
