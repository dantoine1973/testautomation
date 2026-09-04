import pytest

def pytest_addoption(parser):
    parser.addoption(
        "--selenium-browser",
        action="store",
        default="chrome",
        help="Browser to use for Selenium testing: chrome, chromium, edge, msedge, or firefox"
    )

@pytest.fixture
def selected_browser(request):
    return request.config.getoption("--selenium-browser")
