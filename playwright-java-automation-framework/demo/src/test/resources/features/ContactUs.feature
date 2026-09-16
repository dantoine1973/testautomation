@regression
Feature: webdriveruniversity.com - Contact Us Page

  Background: Pre Conditions
    Given I navigate to the WebDriverU homepage
    When I click on the Contact Us button

  Scenario: Valid Contact Us Form Submission - Using Specific Data
    And I type in a specific first name "Sarah"
    And I type in a specific last name "Woods"
    And I type in a specific valid email address "sarah_woods@example.com"
    And I type the specific text "Hello world" and a number 2026 in the comment input field
    And I click on the Submit button
    Then I should be presented with a successful contact us submission message

  Scenario: Valid Contact Us Form Submission - Using Random Data
    And I type in a random first name
    And I type in a random last name
    And I type in a random valid email address
    And I type a random comment in the comment input field
    # And I type the specific text "Hello world" and a number 2026 in the comment input field
    And I click on the Submit button
    Then I should be presented with a successful contact us submission message

  @smoke
  Scenario Outline: Validate Contact Us Page
    And I type a first name '<firstName>' and a last name '<lastName>'
    And I type an email address '<emailAddress>' and a comment '<comment>'
    And I click on the Submit button
    Then I should be presented with header text '<message>'

    Examples:
      | firstName | lastName | emailAddress              | comment                 | message                      |
      | John      | Jones    | john_jones@example.com    | hello how are you?      | Thank You for your Message!  |
      | Mia       | Carter   | mia_carter123@example.com | Test123 Test321         | Thank You for your Message!  |
      | Grace     | Hudson   | grace hudson              | Do you create websites? | Error: Invalid email address |
      | David     | Antoine  | smuvmoney@gmail.com       | My personalized example | Thank You for your Message!  |
