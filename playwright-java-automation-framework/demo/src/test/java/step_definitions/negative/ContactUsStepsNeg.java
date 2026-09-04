package step_definitions.negative;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import com.example.PlaywrightBase2;
import com.microsoft.playwright.Locator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContactUsStepsNeg extends PlaywrightBase2 {
    @Given("I navigate to the WebDriverUniversity homepage")
    public void navigateToHomepage() {
        this.getPage().navigate("https://www.webdriveruniversity.com/");
    }

    @When("I click on Contact Us")
    public void clickContactUs() {
        this.setPage(this.getPage().waitForPopup(() -> this.getPage().getByText("CONTACT US").first().click()));
        this.getPage().waitForURL("**/Contact-Us/contactus.html");
    }

    @And("I type in a first name")
    public void typeFirstName() {
        this.getPage().locator("input[name='first_name']").fill("Test");
    }

    @And("I type in a last name")
    public void typeLastName() {
        this.getPage().locator("input[name='last_name']").fill("User");
    }

    @And("I type in an invalid email address")
    public void typeInvalidEmail() {
        this.getPage().locator("input[name='email']").fill("test.user @ example.com");
    }

    @And("I type in a comment")
    public void typeComment() {
        this.getPage().locator("textarea[name='message']").fill("This is a test comment.");
    }

    @And("I click Submit")
    public void clickSubmit() {
        this.getPage().locator("input[type='submit']").click();
    }

    @Then("I should be presented with an error message about the invalid email address")
    public void verifyErrorMessage() {
        this.getPage().waitForURL("**/contactus.html");
        Locator locator = this.getPage().locator("body");
        assertThat(locator).isVisible();
        assertThat(locator).containsText("Error: Invalid email address");
    }
}