from pageObjects.ordershistory import OrdersHistoryPage


class DashboardPage:

    def __init__(self, page):
        self.page = page

    def selectOrdersNavLink(self):
        self.page.get_by_role("button", name="ORDERS").click()
        myOrdersHistoryPage = OrdersHistoryPage(self.page)
        return myOrdersHistoryPage
