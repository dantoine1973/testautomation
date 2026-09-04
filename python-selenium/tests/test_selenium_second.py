import os
import time
from typing import Any
from selenium_base import BrowserManager


def test_google_with_selected_browser(selected_browser: Any):
    
    try:
        manager = BrowserManager(selected_browser, "https://www.google.com/")
        driver = manager.setup()
        assert "Google" in driver.title, "Title does not match"
    finally:
        manager.teardown()