from pageObjects.ordersdetails import OrdersDetailsPage


class OrdersHistoryPage:
    def __init__(self, page):
        self.page = page

    def selectOrderId(self, orderId):
        row = self.page.locator("tr").filter(has_text=orderId)
        row.get_by_role("button", name="View").click()
        myOrdersDetailsPage = OrdersDetailsPage(self.page)
        return myOrdersDetailsPage
