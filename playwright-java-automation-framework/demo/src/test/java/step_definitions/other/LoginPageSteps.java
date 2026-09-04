package step_definitions.other;

import com.example.PlaywrightBase2;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.microsoft.playwright.Locator;

public class LoginPageSteps extends PlaywrightBase2 {

    private String capturedAlertText;

    @Given("I navigate to the WDU homepage")
    public void navigateToWDUHomepage() {
        this.getPage().navigate("https://www.webdriveruniversity.com/");
    }

    @When("I click the Login Portal link")
    public void clickLoginPortal() {
        this.getPage().evaluate("window.scrollBy(0, 500)");

        Locator loginPortalTile = this.getPage().locator(".thumbnail:has(h1:has-text('LOGIN PORTAL'))");
        loginPortalTile.scrollIntoViewIfNeeded();

        this.setPage(this.getPage().waitForPopup(() -> loginPortalTile.click()));
        this.getPage().waitForURL("**/Login-Portal/index.html*");
    }

    @And("I type a username {string}")
    public void typeUsername(String username) {
        this.getPage().locator("xpath=//input[@id='text']").fill(username);
    }

    @And("I type a password {string}")
    public void typePassword(String password) {
        this.getPage().locator("xpath=//input[@id='password']").fill(password);
    }

    @And("I click the Login button")
    public void clickLoginButton() {

        // Register the dialog handler BEFORE clicking
        this.getPage().onceDialog(dialog -> {
            System.out.println("Alert text: " + dialog.message());
            capturedAlertText = dialog.message(); // store for assertion
            dialog.accept();
        });

        this.getPage().locator("#login-button").hover();
        this.getPage().locator("#login-button").click();
    }

    @Then("I should see an alert containing a text message {string}")
    public void verifyLoginMessage(String expectedMessage) {
        assert capturedAlertText.toLowerCase().contains(expectedMessage.toLowerCase());
    }

}