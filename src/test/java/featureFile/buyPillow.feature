
Feature: Feature to test valid credit card
Scenario: Buy pillow from Midtrans with valid credit card
	Given User in midtrans website
	When User clicks on Buy Now
	And User clicks on Checkout
	And User cick on Continue at order summary
	And User selects Credt or Debit card
  And user enter card number and ExpiryDate and CVV
	And user click on Pay Now
	And user enter OPT and press OK
  Then user get successfull transaction
    

