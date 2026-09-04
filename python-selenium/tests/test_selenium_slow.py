import os
import time
from typing import Any
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support.select import Select
from selenium_base import BrowserManager

def test_selenium_slow(selected_browser):
    try:
        manager = BrowserManager(selected_browser, "https://the-internet.herokuapp.com")
        driver = manager.setup()
        # driver.find_element(By.LINK_TEXT, value="Slow Resources").click()
        driver.find_element(By.XPATH, value = "//a[normalize-space()='Slow Resources']").click()
        sometext = driver.find_element(By.TAG_NAME, value="h3").text
        print(sometext)
    finally:
        manager.teardown()