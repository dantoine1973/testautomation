import time
from typing import Any
from selenium.webdriver.common.by import By
from selenium.webdriver.support.select import Select
from selenium_base import BrowserManager


def test_js_alert_accept(selected_browser: Any):
    try:
        manager = BrowserManager(selected_browser, "https://the-internet.herokuapp.com/javascript_alerts")
        driver = manager.setup()

        time.sleep(1)
        
        driver.find_element(by=By.XPATH, value="//button[@onclick='jsAlert()']").click()
        time.sleep(1)
        
        driver.switch_to.alert.accept()
        
        time.sleep(1)
        
        assert driver.find_element(by=By.ID, value="result").text == "You successfully clicked an alert", "Message incorrect"
        
    finally:
        manager.teardown()
        
def test_js_alert_dismiss(selected_browser: Any):    
    try:
        manager = BrowserManager(selected_browser, "https://the-internet.herokuapp.com/javascript_alerts")
        driver = manager.setup()

        time.sleep(1)
        
        driver.find_element(by=By.XPATH, value="//button[@onclick='jsConfirm()']").click()
        time.sleep(1)
        
        driver.switch_to.alert.dismiss()
        
        time.sleep(1)
        
        assert driver.find_element(by=By.ID, value="result").text == "You clicked: Cancel", "Message incorrect"
        
    finally:
        manager.teardown()
        
def test_js_alert_prompt(selected_browser: Any):
    try:
        manager = BrowserManager(selected_browser, "https://the-internet.herokuapp.com/javascript_alerts")
        driver = manager.setup()

        time.sleep(1)
        
        driver.find_element(by=By.XPATH, value="//button[@onclick='jsPrompt()']").click()
        time.sleep(1)
        
        message = "test message"
        
        print(driver.switch_to.alert.text)
        
        driver.switch_to.alert.send_keys(message)
        driver.switch_to.alert.accept()
        
        time.sleep(1)
        
        assert driver.find_element(by=By.ID, value="result").text == f"You entered: {message}", "Message incorrect"
        
    finally:
        manager.teardown()