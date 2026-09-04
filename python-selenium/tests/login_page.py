from selenium.webdriver.common.by import By

class LoginPage:
    def __init__(self, driver):
        self.driver = driver
    
    username = (By.NAME, "username")
    password = (By.NAME, "password")
    login_button = (By.XPATH, "//button[@type='submit']")
    login_error = (By.CSS_SELECTOR, "div[role='alert']")
    
    # div[role='alert']
    
    def get_username(self):
        return self.driver.find_element(*LoginPage.username)
    
    def get_password(self):
        return self.driver.find_element(*LoginPage.password)
    
    def get_login_button(self):
        return self.driver.find_element(*LoginPage.login_button)
    
    def get_login_error(self):
        return self.driver.find_element(*LoginPage.login_error)