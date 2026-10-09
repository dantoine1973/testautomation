package step_definitions.negative;

// import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import com.example.PlaywrightBase2;
// import com.microsoft.playwright.Locator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.ContactUsPage;
// import context.PersonContext;

public class ContactUsStepsNeg extends PlaywrightBase2 {
    private final HomePage homePage;
    private final ContactUsPage contactUsPage;
//    private final PersonContext personContext;

    public ContactUsStepsNeg() {
//        this.personContext = personContext;
        this.homePage = new HomePage();
        this.contactUsPage = new ContactUsPage();
    }

    @Given("I navigate to the WebDriverUniversity homepage")
    public void navigateToHomepage() {
        homePage.navigateToHomePage();
    }

    @When("I click on Contact Us")
    public void clickContactUs() {
        homePage.clickContactUs();
        this.getPage().waitForURL("**/contactus.html");
    }

    @And("I type in a first name")
    public void typeFirstName() {
        contactUsPage.typeFirstName("Test");
    }

    @And("I type in a last name")
    public void typeLastName() {
        contactUsPage.typeLastName("User");
    }

    @And("I type in an invalid email address")
    public void typeInvalidEmailAddress() {
        contactUsPage.typeEmailAddress("test.user @ example.com");
    }

    @And("I type in a comment")
    public void typeComment() {
        contactUsPage.typeComment("This is a test comment.");
    }

    @And("I click Submit")
    public void clickSubmit() {
        contactUsPage.clickSubmit();
    }

    @Then("I should be presented with an error message about the invalid email address")
    public void verifyErrorMessage() {
        this.getPage().waitForURL("**/contactus.html");
        contactUsPage.verifyMessage(this.getPage().locator("xpath=//body"), "Error: Invalid email address");
    }
}