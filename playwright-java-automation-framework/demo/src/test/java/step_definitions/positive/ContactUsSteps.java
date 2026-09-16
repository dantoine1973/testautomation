package step_definitions.positive;

import com.example.PlaywrightBase2;
import com.microsoft.playwright.Locator;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import java.util.List;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.datafaker.Faker;
import context.PersonContext;

public class ContactUsSteps extends PlaywrightBase2 {
    private final Faker faker = new Faker();
    private final PersonContext personContext;

    public ContactUsSteps(PersonContext personContext) {
        this.personContext = personContext;
    }

    @Given("I navigate to the WebDriverU homepage")
    public void navigateToHomepage() {
        this.getPage().navigate("https://www.webdriveruniversity.com/");
    }

    @When("I click on the Contact Us button")
    public void clickContactUs() {
        this.setPage(this.getPage().waitForPopup(() -> this.getPage().getByText("CONTACT US").first().click()));
        this.getPage().waitForURL("**/Contact-Us/contactus.html");
    }

    @And("I type in a random first name")
    public void typeRandomFirstName() {
        String randomFirstName = faker.name().firstName();
        personContext.setRandomFirstName(randomFirstName);
        this.getPage().locator("input[name='first_name']").fill(randomFirstName);
    }

    @And("I type in a specific first name {string}")
    public void typeSpecificFirstName(String firstName) {
        this.getPage().locator("input[name='first_name']").fill(firstName);
    }

    @And("I type in a random last name")
    public void typeRandomLastName() {
        String randomLastName = faker.name().lastName();
        personContext.setRandomLastName(randomLastName);
        this.getPage().locator("input[name='last_name']").fill(randomLastName);
    }

    @And("I type in a specific last name {string}")
    public void typeSpecificLastName(String lastName) {
        this.getPage().locator("input[name='last_name']").fill(lastName);
    }

    @And("I type a first name {string} and a last name {string}")
    public void typeSpecificFirstAndLastName(String firstName, String lastName) {
        this.getPage().locator("input[name='first_name']").fill(firstName);
        this.getPage().locator("input[name='last_name']").fill(lastName);
    }

    @And("I type in a random valid email address")
    public void typeRandomEmail() {
        String randomEmailAddress = faker.internet().emailAddress();
        personContext.setRandomEmailAddress(randomEmailAddress);
        this.getPage().locator("input[name='email']").fill(randomEmailAddress);
    }

    @And("I type in a specific valid email address {string}")
    public void typeSpecificEmail(String emailAddress) {
        this.getPage().locator("input[name='email']").fill(emailAddress);
    }

@And("I type a random comment in the comment input field")
    public void typeRandomComment() {
        String randomComment = faker.lorem().sentence();
        personContext.setRandomComment(randomComment);
        this.getPage().locator("textarea[name='message']").fill(randomComment);
    }

    @And("I type the specific text {string} and a number {int} in the comment input field")
    public void typeComment(String commentText, Integer int1) {
        this.getPage().locator("textarea[name='message']").fill(commentText + " " + int1);
    }

    @And("I type an email address {string} and a comment {string}")
    public void typeSpecificEmailAndComment(String emailAddress, String commentText) {
        this.getPage().locator("input[name='email']").fill(emailAddress);
        this.getPage().locator("textarea[name='message']").fill(commentText);
    }

    @And("I click on the Submit button")
    public void clickSubmit() {
        this.getPage().locator("input[type='submit']").click();
    }

    @Then("I should be presented with a successful contact us submission message")
    public void verifySuccessMessage() {

        // Wait for the navigation triggered by the Submit button
        this.getPage().waitForURL("**/contactus.html");

        // Now the success message exists
        Locator locator = this.getPage().locator("#contact_reply h1");

        assertThat(locator).isVisible();
        assertThat(locator).hasText("Thank You for your Message!");
    }

    @Then("I should be presented with header text {string}")
    public void verifyMessage(String messageText) {

        // Wait for the navigation triggered by the Submit button
        this.getPage().waitForURL("**/contactus.html");

        // Now the success message exists

        this.getPage().waitForSelector("//h1 | //body");

        List<String> texts = this.getPage().locator("//h1 | //body").allInnerTexts();

        boolean found = texts.stream().anyMatch(t -> t.contains(messageText));

        assert found : "Expected header text '" + messageText +
                "' not found. Actual text: " + texts;
    }
}