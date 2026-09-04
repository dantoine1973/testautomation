import time
from typing import Any
from selenium.webdriver import ActionChains, Keys
from selenium.webdriver.common.by import By
from selenium.webdriver.support.select import Select
from selenium_base import BrowserManager


def test_kbm_double_click(selected_browser: Any):    
    try:
        manager = BrowserManager(selected_browser, "https://www.google.com/")
        driver = manager.setup()
        time.sleep(1)
        
        driver.find_element(by=By.ID, value="ti6dpd").send_keys("Python Selenium" + Keys.TAB)
        driver.find_element(by=By.ID, value="ti6dpd").send_keys(Keys.CONTROL + "A")
        driver.find_element(by=By.ID, value="ti6dpd").send_keys(Keys.BACKSPACE)
        
        time.sleep(2)
        
        driver.find_element(by=By.ID, value="ti6dpd").send_keys("Python Selenium" + Keys.TAB)
        
        action = ActionChains(driver)
        
        #//div[10]//span[1]  ; 
        
        action.double_click(driver.find_element(by=By.CSS_SELECTOR, value="#gbqfbb")).perform()
        time.sleep(2)
        
    finally:
        manager.teardown()

def test_kbm_right_click(selected_browser: Any):  
    try:
        manager = BrowserManager(selected_browser, "https://www.google.com/")
        driver = manager.setup()
        
        time.sleep(1)
        
        driver.find_element(by=By.ID, value="ti6dpd").send_keys("Python Selenium" + Keys.TAB)
        action = ActionChains(driver)
        action.double_click(driver.find_element(by=By.ID, value="ti6dpd")).perform()
        action.context_click(driver.find_element(by=By.ID, value="ti6dpd")).perform()
        time.sleep(2)
        
    finally:
        manager.teardown()

def test_kbm_mouse_hover(selected_browser: Any):   
    try:
        manager = BrowserManager(selected_browser, "https://practice.expandtesting.com/hovers")
        driver = manager.setup()
        time.sleep(1)
        
        action = ActionChains(driver)
        action.move_to_element(driver.find_element(by=By.CSS_SELECTOR, value="img[alt='User Avatar'][data-testid='img-user-2']")).perform()
        
        # 
        
        # /html/body/main/div[3]/div[2]/div/div/div[1]/img ; //div[@class='container']//div[1]//img[1]
        # div.figure:nth-child(4) > img:nth-child(1) ; div.figure:nth-child(4) > img:nth-child(1)
        
        time.sleep(2)
        
    finally:
        manager.teardown()

def test_kbm_mouse_drag_drop(selected_browser: Any):


    try:
        manager = BrowserManager(selected_browser, "https://the-internet.herokuapp.com/drag_and_drop")
        driver = manager.setup()

        time.sleep(1)
        
        action = ActionChains(driver)
        action.drag_and_drop(driver.find_element(by=By.XPATH, value="//div[@id='column-a']"), driver.find_element(by=By.XPATH, value="//*[@id='column-b']")).perform()
        
        time.sleep(2)
        
    finally:
        manager.teardown()