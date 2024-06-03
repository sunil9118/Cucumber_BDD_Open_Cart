Feature: Login with valid credentials

  Scenario: Successfull login with Valid Credential
    Given Navigate user to login page
    When Enter credentails for logining the page (username: "customeruser@gmail.com", password: "demo1234")
    And click on login button
    Then User redirected to MyAccount page
