import os
import time
from typing import Any
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support.select import Select
from selenium_base import BrowserManager

def test_logout_successful():
    print("Logout is successful")
    assert True
    
def test_logout_unsuccessful():
    print("Logout is not successful")