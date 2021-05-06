package com.teammatch;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddGameToList {

    private int initSize;
    private List<String> games = new ArrayList<String>();
    private String newGame;
    private int finalSize;



    @Given("I have {int} games in my list")
    public void iHaveOpeningListSizeGamesInMyList(int initSize) {
        this.initSize = initSize;
        for(int i = 0; i < this.initSize; i++){
            games.add("game");
        }
    }

    @And("I want to add {string} to my games")
    public void iWantToAddNewGameToMyGames(String newGame) {
        this.newGame = newGame;
        games.add(this.newGame);
        this.finalSize = games.size();
    }

    @When("I go to Add Game")
    public void iGoToAddGame() {
    }

    @Then("My game list should have {int} games")
    public void myGameListShouldHaveListSizeGames(int finalSize) {
        assertEquals(this.finalSize, finalSize);
    }
}
