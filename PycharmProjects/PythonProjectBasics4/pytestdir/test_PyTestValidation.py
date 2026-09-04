# Fixtures across multiple test cases


## @pytest.fixture(scope="class")

## @pytest.fixture(scope="module")

import pytest

##@pytest.mark.skip
def test_initialCheck(preWork):
    print("This is a first test")
    assert preWork == "fail"

##@pytest.mark.smoketest
def test_secondCheck(preSetupWork):
    print("This is a second test")
    assert preSetupWork == "pass"