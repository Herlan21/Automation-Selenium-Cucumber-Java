@login
  Feature: Login
    Background: User open the app and proceed to login page
      Given user is launch the app, then if skip button is displayed, click skip button

      Scenario Outline: login with invalid credentials
        And user click form and input username with <email>
        And user click form and input password with <password>
        When user click login button
        Then user get alert
  Examples:
    | email                           | password        |
    | "brainboost123@mailnesia.com"   | "password123!"  |
    | "mamanabdurahman@gmail.com"     | "password"      |
    | ""                              | "password"      |
    | ""                              | ""              |
    | "herlannurachman2000@gmail.com" | ""              |
