@regression @login
Feature: webdriveruniversity.com - Login Page

  Background: Pre Conditions
    Given I navigate to the WDU homepage
    When I click the Login Portal link

  Scenario Outline: Login Portal Submission Attempts
    And I type a username '<username>'
    And I type a password '<password>'
    And I click the Login button
    Then I should see an alert containing a text message '<message>'

    Examples:
      | username  | password     | message              |
      | webdriver | webdriver123 | validation succeeded |
      | webdriver | webdriver321 | validation failed    |

    @smoke
    Examples:
      | username  | password     | message              |
      | webdriver | webdriver123 | validation succeeded |

