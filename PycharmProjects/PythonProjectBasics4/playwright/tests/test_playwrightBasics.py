## Playwright code
from playwright.sync_api import Page, expect, Playwright
from idlelib.debugobj import myrepr
import time
import pytest

def test_playwrightBasics(playwright):
    mybrowser = playwright.chromium.launch(headless=False) # invoke browser
    mycontext = mybrowser.new_context() # incognito mode browser window
    mynewpage = mycontext.new_page()
    mynewpage.goto("https://www.google.com")

# only works on Chromium engine on headless mode
def test_playwrightShortCut(page:Page):
    page.goto("https://www.rahulshettyacademy.com")
#   page.close()

# #terms
# .text-info
# tagname
def test_coreLocators(page:Page):
    page.goto("https://www.rahulshettyacademy.com/loginpagePractise")
    page.get_by_label("Username:").fill("rahulshettyacademy")
    page.get_by_label("Password:").fill("Learning@830$3mK2")
#    page.get_by_label("Password:").fill("Learning@830$3mK2-----")
    page.get_by_role("combobox").select_option("teach")
#    page.locator("#terms").check()
    page.get_by_role("link", name="terms and conditions").click()
    page.get_by_role("button", name="Sign In").click()

    # incorrect username/password check "Incorrect username/password"

#     expect(page.get_by_text("Incorrect username/password")).to_be_visible()

# time to run in Firefox instead of Chromium (Chrome/Edge)



def test_firefoxBrowser(playwright:Playwright):
    chrome_browser = playwright.chromium
    # firefox_browser = playwright.firefox
    browser = chrome_browser.launch(headless=False)
    context = browser.new_context()
    page = browser.new_page()
    test_coreLocators(page)


