package stepDefination;

import core.Base;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pages.DialogPage;
import pages.MainPage;

@SuppressWarnings("deprecation")
public class BuyPillowTest extends Base {

	MainPage mainPage;
	DialogPage cocoStorePopUp;
	
	@Given("User in midtrans website")
	public void getURL() {
		Base.initialization();
	}

	@When("User click on Buy Now")
	public void clickBuyNow() throws InterruptedException {
		mainPage = new MainPage();
		mainPage.clickBuyNow();
	}

	@When("User click on Checkout")
	public void clickCheckout() {
		mainPage.clickCheckout();
	}

	@When("User click on Continue at order summary")
	public void clickContinue() {
		cocoStorePopUp = new DialogPage();
		cocoStorePopUp.clickContinue();
	}

	@When("User select Credt or Debit card")
	public void selectCard() {
		cocoStorePopUp.selectCard();
	}

	@When("user enter {string} and {string} and {string}")
	public void enterCardDetails(String cardNumber, String expiryDate, String cvv) {
		cocoStorePopUp.enterCardDetails(cardNumber, expiryDate, cvv);
	}

	@When("user click on Pay Now")
	public void clickPayNow() {
		cocoStorePopUp.selectPayNow();
	}

	@When("user enter {string} and press OK")
	public void enterOTP(String opt) throws InterruptedException {
		cocoStorePopUp.enterPassword(opt);
	}

	@Then("user get transaction successfull")
	public void validateSuccessfullTransaction() throws InterruptedException {
		String mes = cocoStorePopUp.verifyTransaction();
		Assert.assertTrue(mes.contains("Transaction successful"));
	}

	@Then("user get transaction failed")
	public void ValidateFailedTransaction() throws InterruptedException {
		String mes = cocoStorePopUp.verifyTransaction();
		Assert.assertTrue(mes.contains("Transaction failed"));
	}
	
	@After
	public void tearDown() {
		Base.quit();			
	}

}