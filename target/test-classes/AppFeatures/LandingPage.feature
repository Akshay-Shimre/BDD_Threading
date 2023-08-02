Feature: Landing Page Features

Background:
Given user has already logged in to application
|username|password|
|akshayshimre92@gmail.com|Dungen@123|

Scenario: Landing Page Title check
Given user is on Landing page
When user gets the title of the page
Then page title should be "My Account"
Then user gets accounts section
|My Account|
|My Orders|
|My Affiliate Account|
|Newsletter|
And account section count should be 4

