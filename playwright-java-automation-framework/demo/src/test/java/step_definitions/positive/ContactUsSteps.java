package step_definitions.positive;

import com.example.PlaywrightBase2;
// import com.microsoft.playwright.Locator;
// import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
// import java.util.List;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.datafaker.Faker;
// import pages.base.BasePage;
import pages.HomePage;
import pages.ContactUsPage;
import context.PersonContext;

public class ContactUsSteps extends PlaywrightBase2 {
    private final Faker faker = new Faker();
    private final PersonContext personContext;
    // private final BasePage basePage;
    private final HomePage homePage;
    private final ContactUsPage contactUsPage;

    public ContactUsSteps(PersonContext personContext) {
        this.personContext = personContext;
        this.homePage = new HomePage();
        this.contactUsPage = new ContactUsPage();
    }

    @Given("I navigate to the WebDriverU homepage")
    public void navigateToHomepage() {
        homePage.navigateToHomePage();
    }

    @When("I click on the Contact Us button")
    public void clickContactUs() {
        homePage.clickContactUs();
    }

    @And("I type in a random first name")
    public void typeRandomFirstName() {
        String randomFirstName = faker.name().firstName();
        personContext.setRandomFirstName(randomFirstName);
        contactUsPage.typeFirstName(randomFirstName);
    }

    @And("I type in a specific first name {string}")
    public void typeSpecificFirstName(String firstName) {
        contactUsPage.typeFirstName(firstName);
    }

    @And("I type in a random last name")
    public void typeRandomLastName() {
        String randomLastName = faker.name().lastName();
        personContext.setRandomLastName(randomLastName);
        contactUsPage.typeLastName(randomLastName);
    }

    @And("I type in a specific last name {string}")
    public void typeSpecificLastName(String lastName) {
        contactUsPage.typeLastName(lastName);
    }

    @And("I type a first name {string} and a last name {string}")
    public void typeSpecificFirstAndLastName(String firstName, String lastName) {
        contactUsPage.typeFirstName(firstName);
        contactUsPage.typeLastName(lastName);
    }

    @And("I type in a random valid email address")
    public void typeRandomEmailAddress() {
        String randomEmailAddress = faker.internet().emailAddress();
        personContext.setRandomEmailAddress(randomEmailAddress);
        contactUsPage.typeEmailAddress(randomEmailAddress);
    }

    @And("I type in a specific valid email address {string}")
    public void typeSpecificEmailAddress(String emailAddress) {
        contactUsPage.typeEmailAddress(emailAddress);
    }

    @And("I type a random comment in the comment input field")
    public void typeRandomComment() {
        String randomComment = faker.lorem().sentence();
        personContext.setRandomComment(randomComment);
        contactUsPage.typeComment(randomComment);
    }

    @And("I type the specific text {string} and a number {int} in the comment input field")
    public void typeComment(String commentText, Integer int1) {
        contactUsPage.typeComment(commentText + " " + int1);
    }

    @And("I type an email address {string} and a comment {string}")
    public void typeSpecificEmailAddressAndComment(String emailAddress, String commentText) {
        contactUsPage.typeEmailAddress(emailAddress);
        contactUsPage.typeComment(commentText);
    }

    @And("I click on the Submit button")
    public void clickSubmit() {
        contactUsPage.clickSubmit();
    }

    @Then("I should be presented with a successful contact us submission message")
    public void verifySuccessMessage() {

        // Wait for the navigation triggered by the Submit button
        this.getPage().waitForURL("**/contactus.html");
        contactUsPage.verifyMessage(this.getPage().locator("xpath=//body"), "Thank You for your Message!");
    }

    @Then("I should be presented with header text {string}")
    public void verifyMessage(String messageText) {

        // Wait for the navigation triggered by the Submit button
        this.getPage().waitForURL("**/contactus.html");
        contactUsPage.verifyMessage(this.getPage().locator("xpath=//body"), messageText);
    }
}