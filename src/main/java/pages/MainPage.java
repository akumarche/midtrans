package pages;
	
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import core.Base;

	public class MainPage extends Base {
		
		public MainPage() {
		
		PageFactory.initElements(driver,this);
		}		
		@FindBy (css = "a[class='btn buy']")
		WebElement buyNow;
		
		@FindBy (css = "div[class='cart-checkout']")
		WebElement checkout;
		
		public void clickBuyNow() throws InterruptedException {
			click(buyNow);							
		}

		public DialogPage clickCheckout() {
		
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", checkout);
			return new DialogPage();
		}
	}