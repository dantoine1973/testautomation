import time
from playwright.sync_api import Page, Playwright, expect

from utils.apiBase import APIUtils

fakePayloadOrderResponse = {"data": [], "message": "No Orders"}


def intercept_request(route):
    """This function helps return a mock request for the API call from the browser instead of the real response"""
    route.continue_(
        url="https://www.rahulshettyacademy.com/api/ecom/order/get-orders-details?id=6711e249ae2afd4c0b9f6fb0")


def test_Network_2(page: Page):
    username = 'smuvmoney@gmail.com'
    password = 'SmuvMoney1!'

    myApiUtils = APIUtils(username, password)

    # Go to login page

    page.goto("https://www.rahulshettyacademy.com/client")

    # check specific page route URL/request for network interception/mocking

    page.route("https://www.rahulshettyacademy.com/api/ecom/order/get-orders-details?id=*", intercept_request)

    # enter username and password

    page.get_by_placeholder("email@example.com").fill(myApiUtils.username)
    page.get_by_placeholder("enter your passsword").fill(myApiUtils.password)  # yes passsword is spelled wrong
    page.get_by_role("button", name="Login").click()

    # click orders link after login

    page.get_by_role("button", name="ORDERS").click()

    # after mock request, click on view button to trigger response in browser

    page.get_by_role("button", name="View").first.click()

#    time.sleep(5)

    errortext = page.locator(".blink_me").text_content()

    print(errortext)

def test_session_storage(playwright:Playwright):
    api_utils = APIUtils("smuvmoney@gmail.com","SmuvMoney1!")
    new_token = api_utils.getToken(playwright)
    print(new_token)
    browser = playwright.chromium.launch(headless=False)
    context = browser.new_context()
    page = context.new_page()

    # script to inject session cookie via JavaScript

    page.add_init_script(f"""localStorage.setItem('token','{new_token}')""")

    # now go to main page as authenticated user

    page.goto("https://www.rahulshettyacademy.com/client")

    # click on orders button

    page.get_by_role("button", name="ORDERS").click()

    expect (page.get_by_text('Your Orders')).to_be_visible()
