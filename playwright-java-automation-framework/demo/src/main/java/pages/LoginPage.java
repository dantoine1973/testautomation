package pages;

import pages.base.BasePage;

public class LoginPage extends BasePage {
    
    public LoginPage() {
        super();
    }

    public void typeUsername(String username) {
        this.fillField("Username", username);
    }

    public void typePassword(String password) {
        this.fillField("Password", password);
    }

    public void clickLoginButton() {
        this.getPage().locator("button[id='login-button']").hover();
        this.waitAndClickBySelector("button[id='login-button']");
    }

    public void verifyMessage(String messageText) {
        this.getPage().onceDialog(dialog -> {
            String alertText = dialog.message();
            System.out.println("Alert text: " + alertText);
            if (!alertText.contains(messageText)) {
                throw new AssertionError("Expected alert message to contain: " + messageText + ", but got: " + alertText);
            }
            dialog.accept();
        });
    }
}
