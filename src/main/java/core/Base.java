package core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {

	public static WebDriver driver;
	public static Properties prop; 
	File configFile = new File(System.getProperty("user.dir")+"/resources/config/config.properties");

	public Base(){  

		try {

			prop = new Properties(); // Initializing prop variable under the constructor

			FileInputStream ip = new FileInputStream(configFile);
			prop.load(ip); // load all the properties in the file to java code
		}

		catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// Method for driver initializing driver, invoking browser and opening midtrans website
	public static void initialization() { 

		String chromeDriverPath = System.getProperty("user.dir")+"/resources/driver/chromedriver";
		String geckoDriverPath = System.getProperty("user.dir")+"/resources/driver/geckodriver";

		String browserName = prop.getProperty("browser");
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
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));	

	}
	// Customized Selenium methods to wait for element till visible and then perform action
	public void waitForVisibility(WebElement e) {

		WebDriverWait wait = new WebDriverWait(driver , 10);
		wait.until(ExpectedConditions.visibilityOf(e));
	}

	public void click(WebElement e) {
		waitForVisibility(e);
		e.click();
	}
	public void sendKeys(WebElement e , String text) {
		waitForVisibility(e);
		e.sendKeys(text);
	}

	public String getAttribute(WebElement e , String attribute) {
		waitForVisibility(e);
		return e.getAttribute(attribute);
	}

	public String getText(WebElement e) {
		waitForVisibility(e);
		return e.getText();			
	}

	// Close session
	public static void quit() {

		driver.quit();

	}
}