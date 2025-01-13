Feature: Opencart navigation Feature
Background:
Given User navigates to opencart website

Scenario: Verify that No of Component count is correct in Components page
When user mouse hover on Components menu
And user clicks on Show all components hyperlink
Then User should be navigated to Components list page
And Number of components present on screen should be 5

Scenario: Verify that user successfully navigated to Monitors page
When user mouse hover on Components menu
And user clicks on Show all components hyperlink
And user clicks on Monitors hyperlink
Then user should be navigated to Monitors list view page

Scenario: Verify the Breadcrums are correct & correct no of tiles present
When user mouse hover on Components menu
And user clicks on Show all components hyperlink
And user clicks on Monitors hyperlink
Then The breadcrums should be shown correctly
And The No of tiles present on screen should be 2