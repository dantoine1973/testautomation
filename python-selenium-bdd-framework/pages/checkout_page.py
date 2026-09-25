from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.support.ui import WebDriverWait

from pages.base_page import BasePage


class CheckoutPage(BasePage):
    FIRST_NAME = (By.ID, "first-name")
    LAST_NAME = (By.ID, "last-name")
    POSTAL_CODE = (By.ID, "postal-code")
    CONTINUE_BUTTON = (By.ID, "continue")
    FINISH_BUTTON = (By.ID, "finish")
    COMPLETE_HEADER = (By.CLASS_NAME, "complete-header")

    def enter_customer_information(self, first_name: str, last_name: str, postal_code: str):
        self.driver.find_element(*self.FIRST_NAME).send_keys(first_name)
        self.driver.find_element(*self.LAST_NAME).send_keys(last_name)
        self.driver.find_element(*self.POSTAL_CODE).send_keys(postal_code)
        self.driver.find_element(*self.CONTINUE_BUTTON).click()
        WebDriverWait(self.driver, 10).until(
            EC.visibility_of_element_located(self.FINISH_BUTTON)
        )

    def place_order(self):
        self.driver.find_element(*self.FINISH_BUTTON).click()
        WebDriverWait(self.driver, 10).until(
            EC.visibility_of_element_located(self.COMPLETE_HEADER)
        )

    def confirmation_message(self) -> str:
        return WebDriverWait(self.driver, 10).until(
            EC.visibility_of_element_located(self.COMPLETE_HEADER)
        ).text
