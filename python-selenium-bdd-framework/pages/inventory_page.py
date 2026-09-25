from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.support.ui import WebDriverWait

from pages.base_page import BasePage


class InventoryPage(BasePage):
    PAGE_TITLE = (By.CLASS_NAME, "title")
    CART_LINK = (By.CLASS_NAME, "shopping_cart_link")

    def is_open(self) -> bool:
        return self.driver.current_url.endswith("/inventory.html")

    def add_product_to_cart(self, product_name: str):
        product = self.driver.find_element(
            By.XPATH,
            f"//div[contains(@class, 'inventory_item')][.//div[contains(@class, 'inventory_item_name') and normalize-space()={self._xpath_literal(product_name)}]]",
        )
        product.find_element(By.TAG_NAME, "button").click()

    def open_cart(self):
        self.driver.find_element(*self.CART_LINK).click()

    def wait_until_loaded(self):
        WebDriverWait(self.driver, 10).until(EC.visibility_of_element_located(self.PAGE_TITLE))

    @staticmethod
    def _xpath_literal(value: str) -> str:
        if "'" not in value:
            return f"'{value}'"
        if '"' not in value:
            return f'"{value}"'
        parts = value.split("'")
        return "concat(" + ", \"'\", ".join(f"'{part}'" for part in parts) + ")"
