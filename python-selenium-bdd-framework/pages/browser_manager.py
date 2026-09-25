from selenium import webdriver
from selenium.webdriver.chrome.options import Options as ChromeOptions
from selenium.webdriver.edge.options import Options as EdgeOptions
from selenium.webdriver.firefox.options import Options as FirefoxOptions


class BrowserManager:
    def __init__(self, browser_name: str = "chrome", headless: bool = True):
        self.browser_name = browser_name.lower()
        self.headless = headless
        self.driver = None

    def _build_driver(self):
        if self.browser_name in {"chrome", "chromium"}:
            options = ChromeOptions()
            if self.headless:
                options.add_argument("--headless=new")
            options.add_argument("--window-size=1920,1080")
            options.add_argument("--disable-gpu")
            return webdriver.Chrome(options=options)

        if self.browser_name in {"edge", "msedge"}:
            options = EdgeOptions()
            options.use_chromium = True
            if self.headless:
                options.add_argument("--headless=new")
            options.add_argument("--window-size=1920,1080")
            return webdriver.Edge(options=options)

        if self.browser_name == "firefox":
            options = FirefoxOptions()
            if self.headless:
                options.add_argument("-headless")
            return webdriver.Firefox(options=options)

        raise ValueError(
            f"Unsupported browser: {self.browser_name}. "
            "Choose chrome, chromium, edge, msedge, or firefox."
        )

    def setup(self):
        self.driver = self._build_driver()
        self.driver.implicitly_wait(2)
        if self.headless:
            self.driver.set_window_size(1920, 1080)
        else:
            self.driver.maximize_window()
        return self.driver

    def teardown(self):
        if self.driver is not None:
            self.driver.quit()
            self.driver = None
