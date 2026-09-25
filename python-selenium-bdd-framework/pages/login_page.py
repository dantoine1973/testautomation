from selenium.webdriver.common.by import By

from pages.base_page import BasePage


class LoginPage(BasePage):
    USERNAME = (By.ID, "user-name")
    PASSWORD = (By.ID, "password")
    LOGIN_BUTTON = (By.ID, "login-button")
    ALERT_MESSAGE = (By.XPATH, "//h3[@role='alert']")

    def open(self, base_url: str):
        super().open(base_url)

    def login(self, username: str, password: str):
        self.driver.find_element(*self.USERNAME).send_keys(username)
        self.driver.find_element(*self.PASSWORD).send_keys(password)
        self.driver.find_element(*self.LOGIN_BUTTON).click()
        
    def is_error_displayed(self, timeout: int = 1) -> bool:
        return self.is_element_displayed(*self.ALERT_MESSAGE, timeout=timeout)

    def error_message(self) -> str:
        return self.driver.find_element(*self.ALERT_MESSAGE).text
