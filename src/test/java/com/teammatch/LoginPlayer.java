package com.teammatch;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginPlayer {

    private boolean registered;
    private String registeredUsername;
    private String registeredPassword;
    private String username;
    private String password;
    private String response;

    @Given("I have {} existing account with {string} and with {string}")
    public void iHaveRegisteredExistingAccountWithRegisteredUsernameAndWithRegisteredPassword(boolean registered, String registeredUsername, String registeredPassword) {
        this.registered=registered;
        if (this.registered) {
            this.registeredUsername=registeredUsername;
            this.registeredPassword=registeredPassword;
        }
    }

    @When("I go to log in as a player with {string} username")
    public void iGoToLogInAsAPlayerWithUsernameUsername(String username) { this.username=username; }

    @And("I go to log in as a player with {string} password")
    public void iGoToLogInAsAPlayerWithPasswordPassword(String password) { this.password=password; }

    @Then("I should see {string} log in response screen")
    public void iShouldSeeLogInResponseResponseScreen(String response) {
        if (this.registered){
            if (this.registeredUsername.equals(this.username) && (this.registeredPassword.equals(this.password))) this.response="successful";
            else if (!this.registeredUsername.equals(this.username)) this.response="account doesn't exist";
            else this.response="password doesn't match";
        }
        else this.response="account doesn't exist";
        assertEquals(this.response, response);
    }

}
