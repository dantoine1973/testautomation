import pytest
import pytest_bdd
from pytest_bdd import given, when, then, scenarios, parsers

from pageObjects.login import LoginPage
from utils.apiBaseFramework import APIUtils
from playwright.sync_api import Playwright

scenarios("../features/orderTransaction.feature")

@pytest.fixture
def shared_data():
    return {}

@given(parsers.parse('I place the item order with {username} and {password}'))
def place_item_order(playwright: Playwright, username, password, shared_data):
    myApiUtils = APIUtils(username, password)
    orderId = myApiUtils.createOrder(playwright)
    shared_data['orderId'] = orderId

@given('The user is on landing page')
def user_on_landing_page(browserInstance, shared_data):
    myLoginPage = LoginPage(browserInstance)
    shared_data['loginPage'] = myLoginPage

@when(parsers.parse('I login to the portal with the same {username} and {password}'))
def login_to_portal(browserInstance, username, password, shared_data):
    myLoginPage = shared_data['loginPage']
    myDashboardPage = myLoginPage.login(username, password)
    shared_data['dashboardPage'] = myDashboardPage

@when('I navigate to the order page')
def navigate_to_orders_page(shared_data):
    myDashboardPage = shared_data['dashboardPage']
    myOrdersHistoryPage = myDashboardPage.selectOrdersNavLink()
    shared_data['ordersHistoryPage'] = myOrdersHistoryPage

@when('I select the order ID')
def select_order_id(shared_data):
    myOrdersHistoryPage = shared_data['ordersHistoryPage']
    myOrdersDetailsPage = myOrdersHistoryPage.selectOrderId(shared_data['orderId'])
    shared_data['ordersDetailsPage'] = myOrdersDetailsPage

@then('The order message is successfully displayed')
def verify_order_message(shared_data):
    myOrdersDetailsPage = shared_data['ordersDetailsPage']
    myOrdersDetailsPage.verifyOrderMessage()