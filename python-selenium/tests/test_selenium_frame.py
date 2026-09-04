import os
import time
from typing import Any
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support.select import Select
from selenium_base import BrowserManager

def test_selenium_frame(selected_browser):
    try:
        manager = BrowserManager(selected_browser, "https://the-internet.herokuapp.com")
        driver = manager.setup()
        driver.implicitly_wait(5)
        driver.find_element(By.LINK_TEXT, value="Frames").click()
        driver.find_element(By.LINK_TEXT, value="iFrame").click()
        time.sleep(1)
        driver.find_element(By.XPATH, value="//div[@aria-label='Close']//*[name()='svg']").click()
        time.sleep(1)
        driver.switch_to.frame("mce_0_ifr")        
        frame_element = driver.find_element(By.XPATH, value="//p[normalize-space()='Your content goes here.']")
        print(frame_element.text)
        time.sleep(1)
    finally:
        manager.teardown()