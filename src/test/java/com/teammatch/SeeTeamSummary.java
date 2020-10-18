package com.teammatch;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class SeeTeamSummary {

    private String registered;
    private String username;
    private String filters;
    private String team;
    private String description;

    @Given("I have my account {string}")
    public void iHaveRegisterAccountRegistered(String registered) {
        this.registered = registered;
    }

    @And("I have my account {string} logged in")
    public void iHaveMyAccountUsernameLoggedIn(String username) {
        if(this.registered.equals("an")){
            this.username = username;
        }
        else if(this.registered.equals("no")){
            this.username="error";
        }
        assertEquals(this.username, username);
    }

    @And("I search for Teams")
    public void iSearchForTeams() {
    }

    @And("I have inputted {string} filters")
    public void iHaveInputtedF_amountFilters(String filters) {
        if(this.username.equals("error")){
            this.filters = "error";
        }
        else{
            this.filters= filters;
        }
        assertEquals(this.filters, filters);
    }

    @When("I see a {string} that caught my attention")
    public void iSeeATeamThatCaughtMyAttention(String Team) {
        if(this.filters.equals("error")){
            this.team = "error";
        }
        else{
            this.team= Team;
        }
        assertEquals(this.team, Team);
    }

    @Then("I should be able to see a {string} of the team")
    public void iShouldBeAbleToSeeASummaryOfTheTeam(String description) {
        if(this.team.equals("error")){
            this.description = "error";
        }
        else{
            this.description= description;
        }
        assertEquals(this.description, description);
    }

}
