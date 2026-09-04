from playwright.sync_api import Page, expect
import time
from tests.test_playwrightBasics import test_coreLocators

def test_UIValidationsDynamicScript(page):
    """

    :type page: Page
    """
    test_coreLocators(page) # previous function from other file

    time.sleep(5)

    iphoneProduct = page.locator("app-card").filter(has_text="iphone X")
    iphoneProduct.get_by_role("button", name="Add").click()


    nokiaProduct = page.locator("app-card").filter(has_text="Nokia Edge")
    nokiaProduct.get_by_role("button", name="Add").click()

    time.sleep(5)

    page.get_by_text("Checkout").click()

    expect(page.locator(".media-body")).to_have_count(2)

    time.sleep(5)

def test_childWindowsHandle(page:Page):
    page.goto("https://www.rahulshettyacademy.com/loginpagePractise")

    with page.expect_popup() as newpage:
        page.locator(".blinkingText", has_text="Free").click()
        childpage = newpage.value
        childtext = childpage.locator(".red", has_text="Email").text_content()
        print(childtext)
        childwords = childtext.split("at")
        email = (childwords[1].strip().split(" ")[0])
        print(email)
        assert email == "mentor@rahulshettyacademy.com"





