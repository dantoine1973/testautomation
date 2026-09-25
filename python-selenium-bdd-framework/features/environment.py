import os

import allure

from pages.browser_manager import BrowserManager


def before_all(context):
    context.base_url = os.getenv("BASE_URL", "https://www.saucedemo.com/")
    context.browser_name = context.config.userdata.get(
        "browser", os.getenv("BROWSER", "chrome")
    ).lower()
    headless = context.config.userdata.get("headless", os.getenv("HEADLESS", "true"))
    context.headless = str(headless).lower() not in {"0", "false", "no"}


def before_scenario(context, scenario):
    context.browser_manager = BrowserManager(context.browser_name, context.headless)
    context.driver = context.browser_manager.setup()


def after_scenario(context, scenario):
    if scenario.status == "failed":
        driver = getattr(context, "driver", None)
        if driver is not None:
            try:
                allure.attach(
                    driver.get_screenshot_as_png(),
                    name="failure-screenshot",
                    attachment_type=allure.attachment_type.PNG,
                )
            except Exception:
                pass

    browser_manager = getattr(context, "browser_manager", None)
    if browser_manager is not None:
        browser_manager.teardown()
