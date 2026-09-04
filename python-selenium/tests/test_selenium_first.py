import os
import time
from selenium_base import BrowserManager


def test_selenium_first(selected_browser):
    try:
        manager = BrowserManager(selected_browser, "https://www.google.com")
        driver = manager.setup()
        driver.get_screenshot_as_file("C:\\temp\\screenshot1.png")
        assert "Google" in driver.title, f"Title does not match: {driver.title}"
    finally:
        manager.teardown()
