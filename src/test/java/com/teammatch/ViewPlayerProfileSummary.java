package com.teammatch;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ViewPlayerProfileSummary {

    private int registered;
    private int logged;
    private int fillMyTeam;
    private int profileSummaries;

    @Given("I am {int} user")
    public void iAmRegisteredUser(int registered) {
        this.registered = registered;
    }

    @And("I am {int}")
    public void iAmLoggedIn(int logged) {
        this.logged = logged;
    }

    @And("I have selected the filters")
    public void iHaveSelectedTheFilters() {
    }

    @When("I click {int}")
    public void iClickFillMyTeam(int fillMyTeam) {
        this.fillMyTeam = fillMyTeam;
    }

    @Then("I see a list of {int}")
    public void iSeeAListOfProfileSummaries(int profileSummaries) {

        if(this.registered == 1 && this.logged == 1 && this.fillMyTeam == 1) {
            this.profileSummaries = 1;
        }
        else {
            this.profileSummaries = 0;
        }

        assertEquals(profileSummaries, this.profileSummaries);
    }
}
