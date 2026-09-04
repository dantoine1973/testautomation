from pytest_base_url.plugin import base_url
from pageObjects.dashboard import DashboardPage

class LoginPage:
#    initialUrl = ""

    def __init__(self, page):
        self.page = page
#        self.initialUrl = initialUrl

#    def navigate(self):
#        self.page.goto(self.initialUrl)

    def login(self, username, password):
        self.page.get_by_placeholder("email@example.com").fill(username)
        self.page.get_by_placeholder("enter your passsword").fill(password)  # yes passsword is spelled wrong
        self.page.get_by_role("button", name="Login").click()

        myDashboardPage = DashboardPage(self.page)
        return myDashboardPage