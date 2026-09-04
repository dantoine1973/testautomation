import os
import time
from typing import Any
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support.select import Select
from selenium_base import BrowserManager

def test_example_page_title(selected_browser: Any):
    """Test using browser selected via --selenium-browser or BROWSER env var"""
    
    try:
        manager = BrowserManager(selected_browser, "https://www.facebook.com/")
        driver = manager.setup()
        
        driver.find_element(by=By.XPATH, value="//*[@id='_R_1h6kqsqppb6amH1_']").send_keys("first@example.com")
        
        driver.find_element(by=By.XPATH, value="//*[@id=\"_R_1hmkqsqppb6amH1_\"]").send_keys("somepassword")
        
        driver.find_element(by=By.XPATH, value="//*[@id=\"login_form\"]/div/div[1]/div/div[4]/div/a").click()
        
        
        label = driver.find_element(By.XPATH, "//label[normalize-space()='Mobile number or email']")

        input_id = label.get_attribute("for")

        email_field = driver.find_element(By.ID, input_id)
        email_field.send_keys("smuvmoney@gmail.com")
        
        driver.back()
                
        driver.find_element(By.XPATH, value="//*[@id=\"login_form\"]/div/div[1]/div/div[5]/div/a/div").click()
            
        driver.find_element(By.XPATH, value="//input[@id=//label[normalize-space()='First name']/@for]").send_keys("David")
        driver.find_element(By.XPATH, value="//input[@id=//label[normalize-space()='Last name']/@for]").send_keys("Antoine")
        driver.find_element(By.XPATH, value="//input[@id=//label[normalize-space()='Mobile number or email']/@for]").send_keys("smuvmoney@gmail.com")
       
        time.sleep(1)
    # """        
    #     # Month
    #     month_dropdown = Select(driver.find_element(By.NAME, "birthday_month"))
    #     month_dropdown.select_by_visible_text("Aug")   # or "August" depending on UI

    #     # Day
    #     day_dropdown = Select(driver.find_element(By.NAME, "birthday_day"))
    #     day_dropdown.select_by_visible_text("31")

    #     # Year
    #     year_dropdown = Select(driver.find_element(By.NAME, "birthday_year"))
    #     year_dropdown.select_by_visible_text("1973")
    #     """
       
        #driver.find_element(By.XPATH, "//span[text()='Select your gender']").click()
        #driver.find_element(By.XPATH, "//div[@role='option' and text()='Male']").click()
        driver.back()
        
        driver.find_element(By.PARTIAL_LINK_TEXT, value="Forgot").click()
        
        time.sleep(1)
        
        driver.find_element(By.XPATH, value="//input[@id=//label[normalize-space()='Mobile number or email']/@for]").send_keys("smuvmoney@sbcglobal.net")
    
        time.sleep(1)
    finally:
        manager.teardown()