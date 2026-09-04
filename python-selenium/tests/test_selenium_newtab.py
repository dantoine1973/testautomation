import os
import time
from typing import Any
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support.select import Select
from selenium_base import BrowserManager

def test_selenium_newtab(selected_browser):
    try:
        manager = BrowserManager(selected_browser, "https://the-internet.herokuapp.com/windows")
        driver = manager.setup()
        driver.find_element(By.LINK_TEXT, value="Click Here").click()
        driver.switch_to.window(driver.window_handles[1])
        print(driver.find_element(By.TAG_NAME, value="h3").text)
        driver.switch_to.window(driver.window_handles[0])
        print(driver.find_element(By.TAG_NAME, value="h3").text)
    finally:
        manager.teardown()