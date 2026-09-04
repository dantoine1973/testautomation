import os
import time
from selenium_base import BrowserManager

def test_example_page_title(selected_browser):
    """Test using browser selected via --selenium-browser or BROWSER env var"""
    try:
        manager = BrowserManager(selected_browser, "https://example.com/")
        driver = manager.setup()
        assert driver.title == "Example Domain"
        time.sleep(2)
    finally:
        manager.teardown()
