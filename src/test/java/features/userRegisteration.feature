 Feature: user Registration
 	user register to our E-commerce websit
 	
 	Scenario Outline: user registeration
 	Given user in home page
 	When user click on register link
 	And  user entered "<firstName>","<lastName>","<email>","<password>"
 	Then registration page appear massage says Your registration completed
 	
 	
Examples:
	| firstName | lastName | email | password |
	| wow       | wow2     | ahmedser71@gmail.com | 1234667892 |
	| non       | non2     | seriwad@gmail.com | 12342145654 |
