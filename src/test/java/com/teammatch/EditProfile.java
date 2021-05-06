package com.teammatch;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EditProfile {

    private String username;
    private String newUsername;

    @Given("My username is {string}")
    public void myUsernameIsOpeningUsername(String username) {
        this.username = username;
    }

    @And("I want to modify it to {string}")
    public void iWantToModifyItToNewUsername(String newUsername) {
        this.newUsername = newUsername;
        this.username = this.newUsername;
    }

    @When("I go to Edit Profile")
    public void iGoToEditProfile() {
    }

    @Then("My username should be {string}")
    public void myUsernameShouldBeUsername(String newUsername) {
        assertEquals(this.username, newUsername);
    }
}
