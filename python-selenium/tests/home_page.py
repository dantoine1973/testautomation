from selenium.webdriver.common.by import By

class HomePage:
    def __init__(self, driver):
        self.driver = driver
    
    homepage = (By.XPATH, "//h6[text()='Dashboard']")
    
    def get_dashboard(self):
        return self.driver.find_element(*HomePage.homepage)