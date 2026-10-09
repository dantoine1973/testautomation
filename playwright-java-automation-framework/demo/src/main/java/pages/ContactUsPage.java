package pages;

import pages.base.BasePage;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import com.microsoft.playwright.Locator;

public class ContactUsPage extends BasePage {

    public ContactUsPage() {
        super();
    }

    public void typeFirstName(String firstName) {
        this.fillField("First Name", firstName);
    }

    public void typeLastName(String lastName) {
        this.fillField("Last Name", lastName);  
    }

    public void typeEmailAddress(String email) {
        this.fillField("Email Address", email); // //body
    }

    public void typeComment(String comment) {
        this.fillField("Comments", comment);
    }

    public void clickSubmit() {
        this.getPage().locator("xpath=//input[@value='SUBMIT']").hover();
        this.waitAndClickBySelector("xpath=//input[@value='SUBMIT']");
    }

    public void verifyMessage(Locator locator, String messageText) {
        this.getPage().waitForURL("**/contactus.html");
        assertThat(locator).isVisible();
        assertThat(locator).containsText(messageText);
    }
}
