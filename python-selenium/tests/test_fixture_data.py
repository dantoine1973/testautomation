import os
import time
import pytest
from typing import Any
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support.select import Select
from selenium_base import BrowserManager

@pytest.fixture(scope='function')
def connect_to_DB():
    print("DB connection successful")
    yield
    print("Close the DB")
    
@pytest.fixture()
def load_test_data():
    print("Fetch the Data")
    list_data = ["David", "Joseph", "Antoine"]