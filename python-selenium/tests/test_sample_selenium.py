import logging
import os
import time
from typing import Any
import allure
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support.select import Select
from selenium_base import BrowserManager
from login_page import LoginPage
from home_page import HomePage

logger = logging.getLogger()
logger.setLevel(logging.INFO)

@allure.suite("Login Related Tests")
class TestSampleSelenium:   
    @allure.story("Login")
    @allure.title("Test Login Success")
    @allure.severity(allure.severity_level.CRITICAL)
    def test_login_success(self, selected_browser):
        try:
            manager = BrowserManager(selected_browser, "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login")
            driver = manager.setup()
            
            login_page = LoginPage(driver)
            logger.info("Attempting to log in")
            login_page.get_username().send_keys("Admin")
            logger.info("Username entered")
            login_page.get_password().send_keys("admin123")
            logger.info("Password entered")
            login_page.get_login_button().click()
            logger.info("Login button clicked")
            

            dashboard = HomePage(driver)

            logger.info("Login successful")
            assert dashboard.get_dashboard().is_displayed()
        finally:
            manager.teardown()
            
    @allure.story("Login")
    @allure.title("Test Login Failure")
    @allure.severity(allure.severity_level.BLOCKER)
    def test_login_failure(self, selected_browser):
        try:
            manager = BrowserManager(selected_browser, "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login")
            driver = manager.setup()
            
            login_page = LoginPage(driver)
            logger.info("Attempting to log in")
            login_page.get_username().send_keys("Admin")
            logger.info("Username entered")
            login_page.get_password().send_keys("admin12345")
            logger.info("Password entered")
            login_page.get_login_button().click()
            logger.info("Login button clicked")

            logger.info("Login failed as expected")
            logger.info("Login error message displayed")
            assert login_page.get_login_error().is_displayed()
        finally:
            manager.teardown()