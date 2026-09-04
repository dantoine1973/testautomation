import os
import time
import pytest
from typing import Any
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support.select import Select
from selenium_base import setup_browser, teardown_browser


@pytest.mark.smoke_test
def test_compose_email():
    print("Compose email success")
    assert True

@pytest.mark.smoke_test
@pytest.mark.xfail
def test_draft_email():
    print("Compose draft success")
    assert True

@pytest.mark.regression_test
@pytest.mark.sanity_test
@pytest.mark.skip
def test_compose_email_with_attachment():
    print("Compose email with attachment successful")
    assert True
    
@pytest.mark.sanity_test
def test_compose_email_with_text():
    print("Compose email with text successful")
    assert True