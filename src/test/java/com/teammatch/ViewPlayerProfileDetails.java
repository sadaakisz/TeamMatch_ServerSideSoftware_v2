package com.teammatch;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ViewPlayerProfileDetails {
    public String registered;
    public String logged_in;
    public String player_username;
    public String profile_details;

    @Given("I am a {string} User")
    public void iAmARegisteredUser(String registered) {
        this.registered = registered;
        if (registered.equals("Not registered")){
            this.logged_in = "Logged out";
        }
    }
    @And("I have {string}")
    public void iHaveLoggedIn(String logged_in) {
        this.logged_in = logged_in;
    }

    @And("I have made the search for players according to my filters")
    public void iHaveMadeTheSearchForPlayersAccordingToMyFilters() {
    }

    @When("I select a {string} that could complete my team")
    public void iSelectAPlayerUsernameThatCouldCompleteMyTeam(String player_username) {
        this.player_username = player_username;
    }

    @Then("I see {string} is {string}")
    public void iSeePlayerUsernameIsProfileDetails(String profile_details, String player_username) {
        this.profile_details = profile_details;
        this.player_username = player_username;
    }
}
