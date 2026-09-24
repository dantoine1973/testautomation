package pages.base;

import com.example.PlaywrightBase2;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.WaitForSelectorState;

// This class can be used to add common methods for all pages in the future.

public class BasePage extends PlaywrightBase2 {

    // This method can be implemented to wait for an element by role and click it.

    public void waitAndClickByRole(String role, String name) {
        Locator element = this.getPage().getByRole(AriaRole.valueOf(role.toUpperCase()),
                new Page.GetByRoleOptions().setName(name));
        this.setPage(this.getPage().waitForPopup(() -> element.click()));
    }

    // This method can be implemented to wait for an element by selector and click
    // it.

    public void waitAndClickSelector(String selector) {

        this.getPage().waitForSelector(selector,
                new Page.WaitForSelectorOptions().setState(WaitForSelectorState.VISIBLE));
        this.getPage().locator(selector).click();
    }

    // This method can be implemented to wait for an element and click it.

    public void waitAndClick(Locator locator) {
        locator.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
        locator.click();
    }

    public void navigateTo(String url) {
        this.getPage().navigate(url);
    }
}
