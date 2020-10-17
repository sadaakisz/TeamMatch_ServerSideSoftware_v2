import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchPlayer {

    private int logged;
    private int members;
    private int total;
    private int teamMembers;

    @Given("I am a {int}")
    public void iAmALogged(int logged) {
        this.logged = logged;
    }

    @And("I have an incomplete team with {int}")
    public void iHaveAnIncompleteTeamWithMembers(int members) {
        this.members = members;
    }

    @And("I need a {int} of members")
    public void iNeedATotalOfMembers(int total) {
        this.total = total;
    }

    @When("I search for {int}")
    public void iSearchForTeamMembers(int teamMembers) {
        this.teamMembers = teamMembers;
    }

    @Then("I would have my team complete")
    public void iWouldHaveMyTeamComplete() {
        assertEquals(this.teamMembers, this.total - this.members);
    }
}
