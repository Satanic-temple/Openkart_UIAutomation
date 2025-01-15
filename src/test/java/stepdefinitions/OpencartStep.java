package stepdefinitions;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import AppHooks.ApplicationHooks;
import io.cucumber.java.en.*;
import pages.OpencartPage;
import utilities.Wait;

public class OpencartStep {
	private WebDriver driver;
	private ApplicationHooks apphooks;
	
	// Constructor injection
	public OpencartStep(ApplicationHooks apphooks) {
		this.apphooks = apphooks;
		this.driver = ApplicationHooks.getDriver();	
	}
	public String Component_PageTitle = "Components";
	public String Monitor_PageTitle = "Monitors";
	public int Expected_Breadcrum_Size = 3;
	
	public OpencartPage opencartpage = new OpencartPage(ApplicationHooks.getDriver());
	
	@Given("User navigates to opencart website")
	public void user_navigates_to_opencart_website() {
		driver.get("https://demo.opencart.com");  
	}
	@When("user mouse hover on Components menu")
	public void user_mouse_hover_on_components_menu() throws InterruptedException {
		opencartpage.mouseHover_On_Components_Menu();
	}
	@When("user clicks on Show all components hyperlink")
	public void user_clicks_on_show_all_components_hyperlink() throws InterruptedException {
		opencartpage.Click_on_ShowAllComponents();  
	}
	@Then("User should be navigated to Components list page")
	public void user_should_be_navigated_to_components_list_page() throws InterruptedException {
		Wait.imWait();
		assertEquals(Component_PageTitle, opencartpage.Get_Components_page_title());
	}
	@Then("Number of components present on screen should be {int}")
	public void number_of_components_present_on_screen_should_be(int count) {
		Assert.assertEquals(count, opencartpage.Get_No_of_Components_fromList());
	}
	@When("user clicks on Monitors hyperlink")
	public void user_clicks_on_Monitors_hyperlink() {
		opencartpage.Click_on_Monitor_hyperlink();
	}
	@Then("user should be navigated to Monitors list view page")
	public void user_should_be_navigated_to_Monitors_list_view_page() throws InterruptedException {
		assertEquals(Monitor_PageTitle, opencartpage.Get_Monitor_page_title());
	}
	@Then("The breadcrums should be shown correctly")
	public void The_breadcrums_should_be_shown_correctly() {
		Assert.assertEquals(Expected_Breadcrum_Size, opencartpage.Get_No_Of_Breadcrums());
	}
	@Then("The No of tiles present on screen should be {int}")
	public void The_No_of_tiles_present_on_screen_should_be(int tiles_count) {
		Assert.assertEquals(tiles_count, opencartpage.Get_No_of_Tiles());
	}
}
