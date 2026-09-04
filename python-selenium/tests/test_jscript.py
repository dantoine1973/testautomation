import time
from typing import Any
from selenium.webdriver.common.by import By
from selenium.webdriver.support.select import Select
from selenium_base import BrowserManager


def test_js_manual(selected_browser: Any):  
    try:
        manager = BrowserManager(selected_browser, "https://the-internet.herokuapp.com/")
        driver = manager.setup()    
         
        # scroll down to a particular vertex using window.scrollBy(0,100)
        
        driver.execute_script("window.scrollBy(0,200)")
        
        time.sleep(2)
   
        driver.execute_script("window.scrollBy(0,document.body.scrollHeight)")
        
        time.sleep(2)
    
        # assert driver.find_element(by=By.ID, value="result").text == "You successfully clicked an alert", "Message incorrect"
        
    finally:
        manager.teardown()