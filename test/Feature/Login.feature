Feature: Login Functionality 
@data-driven 
Scenario: Login with valid credentials 
	Given Navigate to Home Page 
	When user enters the username and password 
	Then user login successfully 
	
@data-driven 
Scenario: Search Product 
	When user searches products 
		|headphone|
		|Cylotains|
		|Carpet|
	Then products should be added in a cart if available 
	
@user-specific 
Scenario Outline: Login with valid credentials 
	Given Navigate to Home Page 
	When user enters the "<username>" and "<password>"
	Then user login successfully 
	Examples: 
		|username|password|
		|lalitha|Password123|
		|nnnnnnnn|nnnnnnnn|