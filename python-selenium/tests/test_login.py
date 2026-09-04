import os
import time
from typing import Any
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support.select import Select
from selenium_base import BrowserManager

def test_login_successful():
    print("Login is successful")
    
def test_login_unsuccessful():
    print("Login is not successful")
    assert False