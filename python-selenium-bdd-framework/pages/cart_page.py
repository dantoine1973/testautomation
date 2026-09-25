from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait

from pages.base_page import BasePage


class CartPage(BasePage):
    CART_ITEM_NAMES = (By.CLASS_NAME, "inventory_item_name")
    CHECKOUT_BUTTON = (By.ID, "checkout")

    def contains_product(self, product_name: str) -> bool:
        WebDriverWait(self.driver, 10).until(lambda driver: driver.current_url.endswith("/cart.html"))

        def product_is_present(driver):
            products = driver.find_elements(*self.CART_ITEM_NAMES)
            return any(product.text == product_name for product in products)

        return WebDriverWait(self.driver, 10).until(product_is_present)

    def proceed_to_checkout(self):
        self.driver.find_element(*self.CHECKOUT_BUTTON).click()
        WebDriverWait(self.driver, 10).until(lambda driver: driver.current_url.endswith("/checkout-step-one.html"))
