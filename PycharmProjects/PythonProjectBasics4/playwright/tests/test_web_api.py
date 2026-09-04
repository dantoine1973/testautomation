from playwright.sync_api import Playwright, expect

from utils.apiBase import APIUtils

def test_e2e_web_api(playwright:Playwright):
    username = 'smuvmoney@gmail.com'
    password = 'SmuvMoney1!'

    myApiUtils = APIUtils(username,password)

    print(f"This is the username and password being used: {myApiUtils.username} ; {myApiUtils.password}")

    orderId = myApiUtils.createOrder(playwright)
    # create order to get order ID

    # login to site

    browser = playwright.chromium.launch(headless=False)
    context = browser.new_context()
    page = context.new_page()
    page.goto("https://www.rahulshettyacademy.com/client")

    page.get_by_placeholder("email@example.com").fill(username)
    page.get_by_placeholder("enter your passsword").fill(password) # yes passsword is spelled wrong
    page.get_by_role("button", name="Login").click()

    # orders history page -> order is present

    page.get_by_role("button", name="ORDERS").click()

    row = page.locator("tr").filter(has_text=orderId)
    row.get_by_role("button", name="View").click()

    expect (page.locator(".tagline")).to_contain_text("Thank you")

    context.close()





