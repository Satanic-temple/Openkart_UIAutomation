package utilities;

import java.time.Duration;




public class Wait {
	 //static WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(15));
	public static void imWait() {
		DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
//    public static void exwait_for_GroupPage() {
//    	
//    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='min-w-0 text-truncate']")));
//    }
//    public static void exwait_for_IndividualPage() {
//   	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Date of Birth']")));
//   	////span[@class='min-w-0 text-truncate' and contains(text(),Individuals)]
//    }
}
