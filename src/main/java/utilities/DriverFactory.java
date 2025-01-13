package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	public static WebDriver driver;
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

	/**
	 * This method is used to initialize the threadlocal driver on the basis of given
	 * browser
	 * 
	 * @param browser
	 * @return this will return tldriver.
	 */
	public WebDriver init_driver(String browser) {

		System.out.println("browser value is: " + browser);

		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			tlDriver.set(new EdgeDriver());
		} else {
			System.out.println("Please pass the correct browser value: " + browser);
			throw new IllegalArgumentException("Invalid browser name: " + browser); // Throw exception for invalid browser
	        
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
	}

	/**
	 * this is used to get the driver with ThreadLocal
	 * @return 
	 * @return 
	 * 
	 * @return
	 */
	public static  synchronized WebDriver getDriver() {
		WebDriver driver = tlDriver.get();
		if (driver == null) {
			throw new IllegalStateException("WebDriver is not initialized. Please call initDriver() first.");	
		}
		return driver;
	}
	public static void quitDriver() {
        WebDriver driver = tlDriver.get();
        if (driver != null) {
        	driver.quit();
            tlDriver.remove();
        }

}
}
