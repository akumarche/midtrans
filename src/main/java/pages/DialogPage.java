package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import core.Base;

public class DialogPage  extends Base {

	public DialogPage() {

		PageFactory.initElements(driver,this);

	}

	@FindBy (css = "span[class='text-page-title']")
	WebElement orderSummary;

	@FindBy (xpath = "//*[@id='application']/div[1]")
	WebElement continueButton;

	@FindBy (css = "a[class='list with-promo']")
	WebElement card;

	@FindBy (css = "input[name='cardnumber']")
	WebElement cardNumber;

	@FindBy (css = "div[class='input-group col-xs-7'] input[type='tel']")
	WebElement cardExpDate;

	@FindBy (css = "div[class='input-group col-xs-5'] input[type='tel']")
	WebElement cardCVV;

	@FindBy (css = "div[class='button-main show']")
	WebElement payNow;

	@FindBy (css = "input[type='password']")
	WebElement enterPassword;

	@FindBy (css = "button[type='submit']")
	WebElement okButton;

	@FindBy (xpath = "//iframe")
	WebElement passIframe;

	@FindBy (css = "div[class='card-container full']")
	WebElement transactionMessage;
	
	@FindBy (xpath = "//iframe[contains(@src, 'https://api.sandbox.veritrans.co.id/v2')]")
	WebElement veritransIframe;

	public String verifyOrderSummary() {
		String order = getText(orderSummary);
		return order;

	}

	public void clickContinue() {

		driver.switchTo().frame(0);
		click(continueButton);

	}

	public void selectCard() {

		click(card);
		System.out.println("Debit-credit card selected");
	}

	public void enterCardDetails(String num , String date , String cvv) {

		sendKeys(cardNumber, num);

		System.out.println("Card number entered");

		sendKeys(cardExpDate, date);
		System.out.println("expiry date entered");

		sendKeys(cardCVV, cvv);
		System.out.println("cvv entered");

	}

	public void selectPayNow() {
		click(payNow);

	}

	public void enterPassword(String pass) throws InterruptedException {

		Thread.sleep(5000);
		driver.switchTo().frame(veritransIframe);

		click(enterPassword);
		sendKeys(enterPassword,pass);
		click(okButton);

	}

	public String verifyTransaction() throws InterruptedException {
		Thread.sleep(2000);
		driver.switchTo().frame(0);
		String message = getText(transactionMessage);
		return message;
	}
}