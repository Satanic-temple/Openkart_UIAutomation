package AppHooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.*;
import utilities.ConfigReader;
import utilities.DriverFactory;

public class ApplicationHooks {

	private DriverFactory driverFactory;
	public WebDriver driver;
	private ConfigReader configReader;
	Properties prop;

	@Before(order = 0)
	public void getProperty() {
		System.out.println("Executing Before hook:0");
		configReader = new ConfigReader();
		prop = configReader.init_prop();
	}

	@Before(order = 1)
	public void launchBrowser() {
		System.out.println("Executing Before hook:1");
		// Get browser from system property or default to chrome
		String browserName = prop.getProperty("browser");
		driverFactory = new DriverFactory();
		driver = driverFactory.init_driver(browserName);
	}

	@After(order = 0)
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			// take screenshot:
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName);
			driver.quit();
		}

		else {

			DriverFactory.quitDriver();
		}
	}
	public static WebDriver getDriver() {
		return DriverFactory.getDriver();	
    }
}
