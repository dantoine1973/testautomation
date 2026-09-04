import os
import time
from typing import Any

from selenium.webdriver import Keys
from selenium.webdriver.common.by import By
from selenium_base import BrowserManager


def test_google_with_selected_browser(selected_browser: Any):
    
    try:
        manager = BrowserManager(selected_browser, "https://www.google.com/")
        driver = manager.setup()
        assert "Google" in driver.title, "Title does not match"
        driver.find_element(by=By.NAME, value="q").send_keys("Python Selenium" + Keys.TAB)
        time.sleep(1)
        driver.back()
        time.sleep(1)
        driver.forward()
        time.sleep(1)
        driver.refresh()
    finally:
        manager.teardown()