package utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Wait {
	private static By Components_menu = By.xpath("//a[@class='nav-link dropdown-toggle' and contains(text(),'Components')]");
	public static WebDriver driver;
	static WebDriverWait wt = new WebDriverWait(driver,Duration.ofSeconds(10)); 
	
	public static void imWait() {
		DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
    public static void exwait_for_HomePage() {
    WebElement Component_Menu_Element =	wt.until(ExpectedConditions.visibilityOfElementLocated(Components_menu));
    }
}
