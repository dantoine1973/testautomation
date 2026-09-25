Feature: Sauce Demo shopping flow
  As a shopper
  I want to sign in and manage products in my cart
  So that I can verify the core shopping workflow

  Background:
    Given I am on the Sauce Demo login page

  Scenario Outline: Login with valid credentials
    When I log in with username "<username>" and password "<password>"
    Then I should see the Sauce Demo inventory page

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |
      | error_user    | secret_sauce |

  Scenario Outline: Login with invalid credentials
    When I log in with username "<username>" and password "<password>"
    Then I should see an error message "<message>"

        Examples:
      | username      | password     | message                    |
      | standard_user | secret_sauce_sauce | Epic sadface: Username and password do not match any user in this service |
      | error_user    | secret_sauce_sauce | Epic sadface: Username and password do not match any user in this service |
      | locked_out_user | secret_sauce | Epic sadface: Sorry, this user has been locked out. |

  Scenario Outline: Add a product to the cart
    When I log in with username "<username>" and password "<password>"
    And I add the "<product>" product to the cart
    Then the cart should contain "<product>"

    Examples:
      | username      | password     | product             |
      | standard_user | secret_sauce | Sauce Labs Backpack |
      | performance_glitch_user | secret_sauce | Sauce Labs Bolt T-Shirt |

  Scenario Outline: Complete checkout for a product in the cart
    When I log in with username "<username>" and password "<password>"
    And I add the "<product>" product to the cart
    And I start checkout
    And I enter checkout information first name "<first_name>", last name "<last_name>", and postal code "<postal_code>"
    And I place the order
    Then I should see the checkout confirmation "<confirmation>"

    Examples:
      | username      | password     | product             | first_name | last_name | postal_code | confirmation           |
      | standard_user | secret_sauce | Sauce Labs Backpack | Test       | Customer  | 12345       | Thank you for your order! |
      | performance_glitch_user | secret_sauce | Sauce Labs Bolt T-Shirt | Tester  | Customer  | 12345       | Thank you for your order! |