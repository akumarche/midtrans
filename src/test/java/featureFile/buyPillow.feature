
Feature: To test transaction with valid / Invalid credit card

Background: Buy Pillow
	Given User in midtrans website
	When User click on Buy Now
	And User click on Checkout
	And User click on Continue at order summary
	And User select Credt or Debit card
	
	Scenario Outline: Buy pillow with valid credit card
	
  And user enter "<CardNumber>" and "<ExpiryDate>" and "<CVV>"
	And user click on Pay Now
	And user enter "<OPT>" and press OK
  Then user get transaction successfull 
  
  Examples: 
      |CardNumber|ExpiryDate|CVV|OPT|
      |4811111111111114|1224|123|112233|
    

  Scenario Outline: Buy pillow with invalid credit card
  
  And user enter "<CardNumber>" and "<ExpiryDate>" and "<CVV>"
  And user click on Pay Now
  And user enter "<OPT>" and press OK
  Then user get transaction failed
  
   Examples: 
      |CardNumber|ExpiryDate|CVV|OPT|
      |4911111111111113|1224|123|112233|