package pages;

import pages.base.BasePage;

public class HomePage extends BasePage {

    public HomePage() {
        super();
    }

    public void navigateToHomePage() {
        this.getPage().navigate("https://www.webdriveruniversity.com/");
        this.getPage().bringToFront();
    }

    public void clickContactUs() {
        this.waitAndClickByRole("LINK", "CONTACT US");
        this.getPage().bringToFront();
    }

    public void clickLoginPortal() {
        this.waitAndClickByRole("LINK", "LOGIN PORTAL");
        this.getPage().bringToFront();
    }
}
