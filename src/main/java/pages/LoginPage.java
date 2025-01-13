package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.Wait;

public class LoginPage {
	
	private WebDriver driver;

	//Storing all the locators
	private By Close_popup = By.xpath("//button[@class='create-modal-close-icon onboarding__close-button']");
	private By SignIn_UP = By.xpath("//a[@class = 'menu-nav__profile-button']");
    private By SignIn_page_SignIn_button = By.xpath("//button[@class = 'btn btn-md btn-primary auth-styles__btn mb-20']");
    private By Email = By.id("enterUsername");
    private By SignIn_with_password_button = By.xpath("//button[@class = 'btn btn-lg btn-secondary auth-styles__btn']");
    private By Password = By.id("password");
    private By SignIn_with_password_SignIN_button = By.xpath("//button[@class = 'btn btn-lg btn-primary auth-styles__btn']");
    private By LogIn_Greeting_message = By.xpath("//span[@class='message' and contains(text(),\"Welcome back. you're now signed in.\")]");
    private By Wrong_Email_msg = By.xpath("//div[@class='body-text-xs']");
    private By Wrong_Password_msg = By.xpath("//div[@class='body-text-xs' and contains(text(),\"The password entered\")]");
    
	public LoginPage(WebDriver driver) {
		this.driver=driver;

}
	public void clickOnSignIn_UP(){
		Wait.imWait();
		driver.findElement(Close_popup).click();
		driver.findElement(SignIn_UP).click();
	}
	
	public void clickOnSignInbutton() {
		driver.findElement(SignIn_page_SignIn_button).click();
	}
	
	public void enterEmail(String email) {
		Wait.imWait();
		driver.findElement(Email).sendKeys(email);
		
	}
	
	public void clickOnSignInWithpassword() {
		Wait.imWait();
		driver.findElement(SignIn_with_password_button).click();
	}
	public void enterpassword(String password) {
		Wait.imWait();
		driver.findElement(Password).sendKeys(password);
	}
	public void clickOnSignIn_in_pw_Page() {
		Wait.imWait();
		driver.findElement(SignIn_with_password_SignIN_button).click();
	}
	
	public String getGreetingMessage() {
		String greeting_msg = driver.findElement(LogIn_Greeting_message).getText();
		return greeting_msg;
	}
	
	public String getWrongEmailMessage() {
		String Wrong_Email_Message = driver.findElement(Wrong_Email_msg).getText();
		return Wrong_Email_Message;
	}
	public String getWrongPasswordMessage() {
		String Wrong_Password_Message = driver.findElement(Wrong_Password_msg).getText();
		return Wrong_Password_Message;
	}
	
}
