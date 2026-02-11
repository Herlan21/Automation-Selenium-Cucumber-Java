@login
Feature: Login - Negative Case

  Scenario Outline: login with invalid input
    Given user is launch the website
    And user click form and input username with "<username>"
    And user click form and input password with "<password>"
    When user click login button
    Then user get login error based on input condition

    Examples:
      | username        | password          |
      | wrongadmin      | wrongpassword     |
      | admin           | wrongpassword     |
      | wrongadmin      | password          |
      | admin           |                  |
      |                 | password          |

#@login
#  Feature: Login
##    Background: User access CMS JIP URL and proceed to login page
##      Given user is access cms jip url
#
#      Scenario Outline: login with invalid credentials
#        And user click form and input username with <username>
#        And user click form and input password with <password>
#        When user click login button
#        Then user get alert
#  Examples:
#    | username                        | password            |
#    | "wrongjipadmin"                 | "passwordiswrong"   |
#    | "admin"                         | "wrongpassword"     |
#    | "wrongadmin"                    | "password"          |
#    | "admin"                         | ""                  |
#    | ""                              | "password"          |
