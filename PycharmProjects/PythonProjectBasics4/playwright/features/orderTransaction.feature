Feature: Order Transaction
  Tests related to order transactions

  Scenario Outline: Verify Order success message shown in Order Details page
    Given I place the item order with <username> and <password>
    And The user is on landing page
    When I login to the portal with the same <username> and <password>
    And I navigate to the order page
    And I select the order ID
    Then The order message is successfully displayed
    Examples:
      | username              | password    |
      | smuvmoney@gmail.com   | SmuvMoney1! |
      | rahulshetty@gmail.com | Iamking@000 |