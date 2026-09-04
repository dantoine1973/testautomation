import os

from selenium import webdriver
from selenium.webdriver.chrome.options import Options as ChromeOptions
from selenium.webdriver.edge.options import Options as EdgeOptions
from selenium.webdriver.firefox.options import Options as FirefoxOptions

class BrowserManager:
    def __init__(self, browser_name: str | None = None, url: str | None = None):
        self.browser_name = (browser_name or os.getenv("BROWSER", "chrome")).lower()
        self.url = url
        self.driver = None

    def _build_driver(self):
        browser = self.browser_name

        if browser in {"chrome", "chromium"}:
            options = ChromeOptions()
            options.add_argument("--start-maximized")
            return webdriver.Chrome(options=options)

        if browser in {"edge", "msedge"}:
            options = EdgeOptions()
            options.use_chromium = True
            options.add_argument("--start-maximized")
            return webdriver.Edge(options=options)

        if browser == "firefox":
            options = FirefoxOptions()
            return webdriver.Firefox(options=options)

        raise ValueError(f"Unsupported browser: {browser}")

    def setup(self):
        self.driver = self._build_driver()
        self.driver.maximize_window()
        self.driver.implicitly_wait(5)

        if self.url:
            self.driver.get(self.url)

        return self.driver

    def teardown(self):
        if self.driver is not None:
            self.driver.quit()

# import os

# from selenium import webdriver
# from selenium.webdriver.chrome.options import Options as ChromeOptions
# from selenium.webdriver.edge.options import Options as EdgeOptions
# from selenium.webdriver.firefox.options import Options as FirefoxOptions
# from webdriver_manager.microsoft import EdgeChromiumDriverManager

# def get_browser_name(browser_name: str | None = None) -> str:
#     return (browser_name or os.getenv("BROWSER", "chrome")).lower()

# def build_driver(browser_name: str | None = None):
#     browser = get_browser_name(browser_name)

#     if browser in {"chrome", "chromium"}:
#         options = ChromeOptions()
#         options.add_argument("--start-maximized")
#         return webdriver.Chrome(options=options)

#     if browser in {"edge", "msedge"}:
#         options = EdgeOptions()
#         options.use_chromium = True
#         options.add_argument("--start-maximized")
#         return webdriver.Edge(options=options)
    
#     if browser == "firefox":
#         options = FirefoxOptions()
#         return webdriver.Firefox(options=options)

#     raise ValueError(f"Unsupported browser: {browser}")

# """     if browser in {"edge", "msedge"}:
#         options = EdgeOptions()
#         options.use_chromium = True
#         options.add_argument("--start-maximized")
#         return webdriver.Edge(EdgeChromiumDriverManager().install(), options=options) """

# def setup_browser(browser_name: str | None = None, url: str | None = None):
#     driver = build_driver(browser_name)
#     driver.maximize_window()
#     driver.implicitly_wait(5)
    
#     if url:
#         driver.get(url)
    
#     return driver

# def teardown_browser(driver):
#     if driver is not None:
#         driver.quit()