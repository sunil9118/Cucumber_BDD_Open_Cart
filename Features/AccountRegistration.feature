Feature: Account Registration

  Scenario: Account Registration for new user
    Given Navigate to registration page
    When Enter the registration details
      | FirstName | Kishu    |
      | LastName  | Verma    |
      | password  | demo1234 |
    And Select privacy policy
    And Clik on continue button
    Then New account should be created
