# Fixtures across multiple test cases
import pytest

## @pytest.fixture(scope="class")

## @pytest.fixture(scope="module")

def test_thirdCheck(secondWork):
    print("One more check")