import os
import time
from typing import Any
from selenium import webdriver
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support.select import Select
from selenium_base import BrowserManager
from selenium.webdriver.support import expected_conditions

def test_selenium_slow2(selected_browser):
    # print("requested browser:", selected_browser)
    
    try:
        manager = BrowserManager(selected_browser, "https://the-internet.herokuapp.com")
        driver = manager.setup()
        driver.find_element(By.LINK_TEXT, value="Slow Resources").click()
        wait = WebDriverWait(driver, 30)
        wait.until(expected_conditions.visibility_of(driver.find_element(By.TAG_NAME, value="h3")))
        sometext = driver.find_element(By.TAG_NAME, value="h3").text
        print(sometext)
    finally:
        manager.teardown()