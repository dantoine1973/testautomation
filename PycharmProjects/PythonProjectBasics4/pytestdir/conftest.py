import pytest

@pytest.fixture(scope="module")
def preWork():
    print("Set up the browser instance")
    return "fail"

@pytest.fixture(scope="function")
def preSetupWork():
    print("I pre-setup the browser instance")
    return "pass"

@pytest.fixture(scope="module")
def secondWork():
    print("I second setup the browser instance")
    yield
    print("I teardown the browser instance")


