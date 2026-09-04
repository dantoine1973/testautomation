import os
import json
import pytest
from playwright.sync_api import Playwright
from pageObjects.login import LoginPage
#from utils.apiBase import APIUtils
from utils.apiBaseFramework import APIUtils
import conftest

with open('C:\\Users\\danto\\PycharmProjects\\PythonProjectBasics4\\playwright\\data\\credentials.json') as f:
    test_data = json.load(f)
    user_credentials_list = test_data['user_credentials']

@pytest.mark.smoke
@pytest.mark.parametrize('user_credentials', user_credentials_list)
def test_e2e_web_api(playwright:Playwright, user_credentials, browserInstance):

    myApiUtils = APIUtils(user_credentials["userEmail"], user_credentials["userPassword"])

    orderId = myApiUtils.createOrder(playwright)

#    print(f"This is the username and password being used: {myApiUtils.username} ; {myApiUtils.password}")




    # initialUrl = "https://www.rahulshettyacademy.com/client"

    myLoginPage = LoginPage(browserInstance)
#    myLoginPage.navigate()
    myDashboardPage = myLoginPage.login(myApiUtils.username, myApiUtils.password)

    myOrdersHistoryPage = myDashboardPage.selectOrdersNavLink()

    myOrdersDetailsPage = myOrdersHistoryPage.selectOrderId(orderId)

    myOrdersDetailsPage.verifyOrderMessage()