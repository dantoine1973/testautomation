import os
import time
from selenium_base import BrowserManager

## This is a sample comment

def test_example_page_title(selected_browser):
    """Test using browser selected via --selenium-browser"""
    try:
        manager = BrowserManager(selected_browser, "https://example.com/")
        driver = manager.setup()
        assert driver.title == "Example Domain"
        time.sleep(2)
    finally:
        manager.teardown()
