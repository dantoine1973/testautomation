Feature: webdriveruniversity.com - Contact Us Page - Invalid Email Address

    Scenario: Valid Contact Us Form Submission
        Given I navigate to the WebDriverUniversity homepage
        When I click on Contact Us
        And I type in a first name
        And I type in a last name
        And I type in an invalid email address
        And I type in a comment
        And I click Submit
        Then I should be presented with an error message about the invalid email address