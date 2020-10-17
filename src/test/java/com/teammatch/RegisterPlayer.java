package com.teammatch;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegisterPlayer {

    private boolean registered;
    private String username;
    private String response;

    @Given("I have {} existing account")
    public void iHaveRegisteredExistingAccount(boolean registered) { this.registered=registered; }

    @When("I go to register as a player with {string}")
    public void iGoToRegisterAsAPlayerWithUsername(String username) {
        if (!this.registered) { this.username=username; }
        else { this.username=""; }
    }

    @Then("I should see {string} response screen")
    public void iShouldSeeResponseResponseScreen(String response) {
        if (!this.username.equals("")) { this.response="successful"; } else { this.response="failed"; }
        assertEquals(this.response, response);
    }

    @And("I should see {string} my username")
    public void iShouldSeeRegisteredUsernameMyUsername(String registeredUsername) {
        assertEquals(this.username, registeredUsername);
    }
}
