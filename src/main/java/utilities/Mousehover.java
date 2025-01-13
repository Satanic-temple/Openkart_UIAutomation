package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Mousehover {
	private static WebDriver driver;
	
	public static void mouseHover(WebElement ele) {
		Actions actions = new Actions(DriverFactory.getDriver());

        // Perform the hover action
        actions.moveToElement(ele).perform();
	}
}
