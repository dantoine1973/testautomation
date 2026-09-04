import time
import pytest
from playwright.sync_api import Page

from utils.apiBase import APIUtils

fakePayloadOrderResponse = {"data":[],"message":"No Orders"}

def intercept_response(route):
    """This function helps return a mock response for the API call from the browser instead of the real response"""
    route.fulfill(
        json=fakePayloadOrderResponse
    )

@pytest.mark.smoke
def test_Network_1(page:Page):

    username = 'smuvmoney@gmail.com'
    password = 'SmuvMoney1!'

    myApiUtils = APIUtils(username, password)

    # Go to login page

    page.goto("https://www.rahulshettyacademy.com/client")

    # check specific page route URL/request for network interception/mocking

    page.route("https://rahulshettyacademy.com/api/ecom/order/get-orders-for-customer/*", intercept_response)

    # enter username and password

    page.get_by_placeholder("email@example.com").fill(myApiUtils.username)
    page.get_by_placeholder("enter your passsword").fill(myApiUtils.password)  # yes passsword is spelled wrong
    page.get_by_role("button", name="Login").click()

    # click orders link after login

    page.get_by_role("button", name="ORDERS").click()

    # after mock response, perform assertion on what empty orders page should look like

    #time.sleep(5)
    ordertext = page.locator(".mt-4").text_content()

    print(ordertext)