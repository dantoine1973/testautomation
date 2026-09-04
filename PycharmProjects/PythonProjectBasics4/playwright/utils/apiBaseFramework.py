import json
import time

from playwright.sync_api import Playwright
from pytest_base_url.plugin import base_url



class APIUtils():

    username = ""
    password = ""
    token = ""

    def __init__(self, username, password):
        self.username = username
        self.password = password
        self.token = ""

    def getToken(self, playwright:Playwright):
        api_request_context = playwright.request.new_context(base_url="https://www.rahulshettyacademy.com")

#        print(f"This is the username and password being used: {self.username} ; {self.password}")

        response = api_request_context.post("api/ecom/auth/login",
                                            headers={"Content-Type": "application/json"},
                                            data={
                                                "userEmail": self.username,
                                                "userPassword": self.password
                                            })

        print(response.status)
        assert response.ok

        responseBody = (response.json())
        return responseBody.get("token")

    def createOrder(self, playwright:Playwright):

        api_request_context = playwright.request.new_context(base_url="https://www.rahulshettyacademy.com")
        self.token = self.getToken(playwright)

        response = api_request_context.post("api/ecom/order/create-order",
                                 data={"orders":[{"country":"United States","productOrderedId":"6960ea76c941646b7a8b3dd5"}]},
                                 headers={"Content-Type": "application/json",
                                                              "Authorization": self.token})

        # print(response.json())

        responseBody = response.json()
        responseBody.get('orders')[0]
        print(f'The order ID is {responseBody.get("orders")[0]}')
        return responseBody.get("orders")[0]