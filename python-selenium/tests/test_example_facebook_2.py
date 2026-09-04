import time
from typing import Any
from selenium.webdriver.common.by import By
from selenium.webdriver.support.select import Select
from selenium_base import BrowserManager

def test_example_page_title(selected_browser: Any):
    try:
        manager = BrowserManager(browser_name=selected_browser, url="https://www.facebook.com")
        driver = manager.setup()
        
        email_label = driver.find_element(By.XPATH, "//label[normalize-space()='Email or mobile number']")
        email_id = email_label.get_attribute("for")
        email_element = driver.find_element(By.ID, email_id)
        email_element.send_keys("first@example.com")
        
        password_label = driver.find_element(By.XPATH, "//label[normalize-space()='Password']")
        password_id = password_label.get_attribute("for")
        password_element = driver.find_element(By.ID, password_id)
        password_element.send_keys("somepassword")

        driver.find_element(By.LINK_TEXT, "Forgot password?").click()
        time.sleep(2)

        email_label = driver.find_element(By.XPATH, "//label[normalize-space()='Mobile number or email']")
        email_id = email_label.get_attribute("for")
        email_element = driver.find_element(By.ID, email_id)
        email_element.send_keys("smuvmoney@gmail.com")

        driver.back()

        # -------------------------------
        # CREATE NEW ACCOUNT
        # -------------------------------

        driver.find_element(
            By.XPATH,
            "//a[@data-testid='open-registration-form-button']"
        ).click()

        # -------------------------------
        # SIGNUP FORM FIELDS
        # -------------------------------

        driver.find_element(By.NAME, "firstname").send_keys("David")
        driver.find_element(By.NAME, "lastname").send_keys("Antoine")
        driver.find_element(By.NAME, "reg_email__").send_keys("smuvmoney@gmail.com")

        time.sleep(1)

        # -------------------------------
        # BIRTHDAY DROPDOWNS
        # -------------------------------

        month_dropdown = Select(driver.find_element(By.NAME, "birthday_month"))
        month_dropdown.select_by_visible_text("Aug")

        day_dropdown = Select(driver.find_element(By.NAME, "birthday_day"))
        day_dropdown.select_by_visible_text("31")

        year_dropdown = Select(driver.find_element(By.NAME, "birthday_year"))
        year_dropdown.select_by_visible_text("1973")

        time.sleep(1)

    finally:
        manager.teardown()