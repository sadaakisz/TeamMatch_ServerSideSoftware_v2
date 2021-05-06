package com.teammatch;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateTeam {

    private String registered;
    private String loggedIn;
    private int teams;
    private int newTeams;

    @Given("I am a {string} user")
    public void iAmARegisteredUser(String registered) {
        this.registered = registered;
        if (registered == "Not registered")
            this.loggedIn = "Logged out";
    }

    @And("I am {string}")
    public void iHaveLoggedIn(String loggedIn) {
        this.loggedIn = loggedIn;
    }

    @And("I have {int} teams")
    public void iHaveTeamsTeams(int teams) {
        this.teams = teams;
    }

    @When("I enter team and game information")
    public void iEnterTeamAndGameInformation() {
    }

    @Then("I should have {int} teams")
    public void iShouldHaveNewTeams(int newTeams) {
        this.newTeams = newTeams;
        if (this.loggedIn == "Logged in" && this.registered == "Registered") {
            this.newTeams = this.teams + 1;
        }
        assertEquals(this.newTeams, newTeams);
    }
}
