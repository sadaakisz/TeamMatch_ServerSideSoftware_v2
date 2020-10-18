package com.teammatch;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApplyFilters {
    private String amRegistered;
    private String login;
    private int initialSize;
    private int filters;
    private int matchingFilters;
    private int finalSize;

    @Given("I am: {string}")
    public void iHaveAmRegistered(String amRegistered) {
        this.amRegistered = amRegistered;
    }

    @And("my login state is {string}")
    public void myLoginStateIs(String login) {
        this.login = login;
    }

    @And("my initial found players list length is {int}")
    public void myInitialFoundPlayersListLengthIsInitialSize(int initialSize) {
        this.initialSize = initialSize;
    }

    @When("I enter {int} filters")
    public void iEnterFiltersNumberOfFilters(int filters) {
        this.filters = filters;
    }

    @And("A found player has {int} filters")
    public void aFoundPlayerHasMatchingNumberOfFilters(int matchingFilters) {
        this.matchingFilters = matchingFilters;
    }

    @Then("my found players list should be {int}")
    public void myFoundPlayersListShouldBeFinalSize(int finalSize) {
        this.finalSize = finalSize;
        if (this.amRegistered == "Registered" && this.login == "Logged in") {
            if (this.matchingFilters == this.filters) {
                this.finalSize = this.initialSize+1;
            }
        }
        assertEquals(finalSize, this.finalSize);
    }
}
