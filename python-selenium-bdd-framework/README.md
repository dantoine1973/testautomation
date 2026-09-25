# Python Selenium BDD Framework

A small page object model framework for testing [Swag Labs](https://www.saucedemo.com/) with Python, Selenium, and Cucumber-style BDD using `behave`.

## Project structure

```text
python-selenium-bdd-framework/
|-- features/
|   |-- environment.py
|   |-- login_and_cart.feature
|   `-- steps/
|       `-- sauce_demo_steps.py
|-- pages/
|   |-- base_page.py
|   |-- browser_manager.py
|   |-- cart_page.py
|   |-- inventory_page.py
|   `-- login_page.py
|-- requirements.txt
`-- README.md
```

## Setup

```powershell
cd python-selenium-bdd-framework
python -m venv .venv
.\.venv\Scripts\Activate.ps1
python -m pip install -r requirements.txt
```

If PowerShell blocks activation, run the commands with the Python executable directly:

```powershell
.\.venv\Scripts\python.exe -m pip install -r requirements.txt
```

## Run the BDD tests

Run headless with the default Chrome browser:

```powershell
.\.venv\Scripts\python.exe -m behave
```

## Allure reporting

Install the dependencies, then generate Allure results while running Behave:

```powershell
.\.venv\Scripts\python.exe -m pip install -r requirements.txt
.\.venv\Scripts\python.exe -m behave -f allure_behave.formatter:AllureFormatter -o allure-results
```

The results are written to `allure-results`. The Allure command-line tool is required to view them. With Allure installed, start a temporary local report:

```powershell
allure serve allure-results
```

Or generate a saved report:

```powershell
allure generate allure-results -o allure-report --clean
allure open allure-report
```

Failed scenarios automatically include a browser screenshot in the Allure report.

Choose a browser from the command line with Behave's `-D` user-data option:

```powershell
.\.venv\Scripts\python.exe -m behave -D browser=chrome
.\.venv\Scripts\python.exe -m behave -D browser=chromium
.\.venv\Scripts\python.exe -m behave -D browser=edge
.\.venv\Scripts\python.exe -m behave -D browser=firefox
```

The accepted browser names are `chrome`, `chromium`, `edge`, `msedge`, and `firefox`. Headless mode is enabled by default. To see the browser window, add `-D headless=false`:

```powershell
.\.venv\Scripts\python.exe -m behave -D browser=edge -D headless=false
```

Environment variables remain supported for CI or shell defaults:

```powershell
$env:BROWSER = "firefox"
$env:HEADLESS = "false"
$env:BASE_URL = "https://www.saucedemo.com/"
.\.venv\Scripts\python.exe -m behave
```

Selenium Manager downloads and manages the matching browser driver. A supported browser must already be installed.
