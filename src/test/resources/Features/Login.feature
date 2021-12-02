Feature: Login Functionality

Background:
Given user navigate to url "http://localhost:100" on chrome
Then login page should be appear

@smoke
Scenario: Valid Login
When user enters valid userid and password
And click on Login button
Then user should be landed on homepage 
And Logout link should be appear
And Close the browser

Scenario Outline: InValid Login
When user enters invalid userid as "<userid>" and password as "<password>"
And click on Login button
Then error message should be appear
And Close the browser

Examples:
|userid|password|
|admin1|admin1|
