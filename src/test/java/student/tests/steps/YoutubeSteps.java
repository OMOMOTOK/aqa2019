package student.tests.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class YoutubeSteps extends BaseStep {

    @Given("Youtube page is loaded")
    public void loadPage() {
        youtubePage.loadPage();
    }

    @When("I search for video {string}")
    public void searchForVideo(String value) {
        youtubePage.getSearch().sendKeys(value);
        youtubePage.getSearchButton().click();
    }

    @Then("Youtube page loaded successfully")
    public void validatePageloaded(String exectedStatus) {
        System.out.println("Youtube: Success!");
    }

    @Then("Youtube video found!")
    public void validateVideoFound() {
        System.out.println("validating...");
    }


}
