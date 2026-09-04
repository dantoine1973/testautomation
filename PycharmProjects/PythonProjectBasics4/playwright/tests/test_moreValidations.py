import time
import playwright
from playwright.async_api import Playwright
from playwright.sync_api import Page, expect

# Placeholder examples

def test_UIChecks(page:Page,playwright:Playwright):

    #show/hide example placeholder

    browser = playwright.chromium.launch()
    context = browser.new_context()
    page = context.new_page()
    page.goto("https://www.rahulshettyacademy.com/AutomationPractice/", wait_until="domcontentloaded", timeout=60000)
    expect(page.get_by_placeholder("Hide/Show Example")).to_be_visible()
    page.get_by_role("button", name="Hide").click()
    expect(page.get_by_placeholder("Hide/Show Example")).to_be_hidden()

    #show alert example - need to create event for alert dialog

    page.on("dialog", lambda dialog:dialog.accept())
    page.get_by_role("button", name="Confirm").click()

    #Frame handler

    pageFrame = page.frame_locator("#courses-iframe")
    pageFrame.get_by_role("link", name="All Access Plan").click()
    expect(pageFrame.locator("body")).to_contain_text("Happy Subscibers!")

#   mouse hover example

    page.locator("#mousehover").hover()
    page.get_by_role("link", name="Top").click()

#    time.sleep(5)

#   Check if price of rice == 37 on a different page using dynamic web charts
#   1. ID price column
#   2. ID rice row
#   3. extract price from row/column

    page.goto("https://rahulshettyacademy.com/seleniumPractise/#/offers")

    for index in range(page.locator("th").count()):
        if page.locator("th").nth(index).filter(has_text="Price").count() > 0:
            columnValue = index
            print(f"Price column value is {columnValue}")
            break

    rowValue = page.locator("tr").filter(has_text="Rice")

    expect(rowValue.locator("td").nth(columnValue)).to_have_text("37")



#    with page.expect_popup() as newpage:
#        page.get_by_role("link", name="Top Deals").click()











