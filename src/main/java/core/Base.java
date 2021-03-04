package core;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Base {

	public static void main(String[] args) {
		
		initialization("chrome");
		
	}
	public static WebDriver driver;


	public static void initialization(String browser) { 

		String chromeDriverPath = System.getProperty("user.dir")+"/resources/driver/chromedriver";
		String geckoDriverPath = System.getProperty("user.dir")+"/resources/driver/geckodriver";

		String browserName = browser;
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",chromeDriverPath);
			driver = new ChromeDriver();
		}
		else if(browserName.equals("firefox")) {

			System.setProperty("webdriver.gecko.driver",geckoDriverPath);
			driver = new FirefoxDriver();
		} 

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demo.midtrans.com/");		

	

	}
}


