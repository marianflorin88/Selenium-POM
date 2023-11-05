Feature: Saucelabs Authentication

  Scenario Outline: Logging in with a valid user account
    Given user is on home page
    When logging in with username: <username> and password "secret_sauce"
    And submitting login form
    Then user is logged in and redirected to "https://www.saucedemo.com/inventory.html"

    Examples:
      | username                  |
      | "standard_user"           |
      | "problem_user"            |
      | "performance_glitch_user" |

  Scenario Outline: Attempting Login with invalid credentials
    Given user is on home page
    When logging in with username: <username> and password <password>
    And submitting login form
    Then user is not logged in and the message: <errorMessage> is displayed

    Examples:
      | username                      | password                | errorMessage                                                                            |
      | "valid_inexistent"            |     "secret_sauce"      |   "Epic sadface: Username and password do not match any user in this service"           |
      | ""                            |     "secret_sauce"      |   "Epic sadface: Username is required"                                                  |
      | "locked_out_user"             |   "secret_sauce"        |   "Epic sadface: Sorry, this user has been locked out."                                 |
      | "locked_out_user"             |   ""                    |   "Epic sadface: Password is required"                                                  |
