package com.teammatch;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class SeeTeamDetails {

    private String registered;
    private String username;
    private String filters;
    private String team;
    private String details;

    @Given("I have {string} account registered")
    public void iHaveRegisterAccountRegistered(String registered) {
        this.registered = registered;
    }

    @And("I have logged in with an {string}")
    public void iHaveLoggedInWithAnUsername(String Username) {
        if(this.registered.equals("an")){
            this.username = Username;
        }
        else if(this.registered.equals("no")){
            this.username="error";
        }
        assertEquals(this.username, Username);
    }

    @And("I select the option of Search Teams")
    public void iSelectTheOptionOfSearchTeams() {
    }

    @And("I have registered {string} filters")
    public void iHaveRegisteredF_amountFilters(String filters) {
        if(this.username.equals("error")){
            this.filters = "error";
        }
        else{
            this.filters= filters;
        }
        assertEquals(this.filters, filters);
    }

    @And("I see a {string} that interest me")
    public void iSeeATeamThatInterestMe(String Team) {
        if(this.filters.equals("error")){
            this.team = "error";
        }
        else{
            this.team= Team;
        }
        assertEquals(this.team, Team);
    }

    @When("I choose the team that I want to see details about")
    public void iSelectTheTeamThatIWantToSeeDetailsAbout() {

    }

    @Then("I should be able to see {string} of the team")
    public void iShouldBeAbleToSeeDetailsOfTheTeam(String details) {
        if(this.team.equals("error")){
            this.details = "error";
        }
        else{
            this.details= details;
        }
        assertEquals(this.details, details);

    }
}
