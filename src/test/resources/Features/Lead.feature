Feature: Lead Functionality

Background: 
Given user navigate to url "http://localhost:100" on chrome
Then login page should be appear

Scenario: Create Lead
When user enters valid userid and password
And click on Login button
Then user should be landed on homepage 
When user click on New Lead 
Then create lead page will be open
When user enters last name and company name and click on save button
Then lead should be created successfully
And Close the browser