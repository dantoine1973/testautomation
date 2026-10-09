package step_definitions.other;

import com.example.PlaywrightBase2;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;

public class LoginPageSteps extends PlaywrightBase2 {

    private String capturedAlertText;
    private final HomePage homePage;
    private final LoginPage loginPage;

    public LoginPageSteps() {
        this.homePage = new HomePage();
        this.loginPage = new LoginPage();
    }

    @Given("I navigate to the WDU homepage")
    public void navigateToWDUHomepage() {
        homePage.navigateToHomePage();
    }

    @When("I click the Login Portal link")
    public void clickLoginPortal() {
        homePage.clickLoginPortal();
        this.getPage().waitForURL("**/Login-Portal/index.html*");
    }

    @And("I type a username {string}")
    public void typeUsername(String username) {
        loginPage.typeUsername(username);
    }

    @And("I type a password {string}")
    public void typePassword(String password) {
        loginPage.typePassword(password);
    }

    @And("I click the Login button")
    public void clickLoginButton() {

        // Register the dialog handler BEFORE clicking
        this.getPage().onceDialog(dialog -> {
            System.out.println("Alert text: " + dialog.message());
            capturedAlertText = dialog.message(); // store for assertion
            dialog.accept();
        });

        loginPage.clickLoginButton();
    }

    @Then("I should see an alert containing a text message {string}")
    public void verifyLoginMessage(String expectedMessage) {
        loginPage.verifyMessage(expectedMessage);
    }

}