package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.Mousehover;
import utilities.Wait;

public class OpencartPage {
	
	public String Component_PageTitle;
	public String Monitor_PageTitle;
	public int No_of_components;
	public int Actual_Breadcrum_Size;
	public int Actual_Tile_Size;
	private List<WebElement> listOfComponents;
	
	private WebDriver driver;
	//Storing all the locators
	private By Components_menu = By.xpath("//a[@class='nav-link dropdown-toggle' and contains(text(),'Components')]");
	private By Show_all_components = By.xpath("//a[@class='see-all' and contains(text(),'Show All Components')]");
	private By Component_list = By.xpath("//div[@class ='col-sm-3']");
	private By Monitor_link = By.xpath("//div[@class='col-sm-3']/ul/li//a[text()='Monitors (2)']");
	private By Breadcrums = By.xpath("//li[@class=\"breadcrumb-item\"]");
	private By Tiles = By.xpath("//div[@class='col mb-3']");
	//Using parameterised constructor to initialize the driver
	public OpencartPage(WebDriver driver) {
		this.driver = driver;	
	}
	
	public void mouseHover_On_Components_Menu() {
		Wait.imWait();
		WebElement component_Menu_Elelement = driver.findElement(Components_menu);
		Mousehover.mouseHover(component_Menu_Elelement);
	}
	public void Click_on_ShowAllComponents() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(Show_all_components).click();
	}
	public String Get_Components_page_title() throws InterruptedException {
		Thread.sleep(9000);
		Component_PageTitle = driver.getTitle();
		System.out.println("Component Webpage title is:"+Component_PageTitle);
		return Component_PageTitle;
	}
	public int Get_No_of_Components_fromList() {
		listOfComponents = driver.findElements(Component_list);
		No_of_components = listOfComponents.size();
		return No_of_components;
	}
	public void Click_on_Monitor_hyperlink() {
		driver.findElement(Monitor_link).click();
	}
	public String Get_Monitor_page_title() throws InterruptedException {
		Thread.sleep(8000);
		Monitor_PageTitle = driver.getTitle();
		System.out.println("Monitor Webpage title is:"+Monitor_PageTitle);
		return Monitor_PageTitle;
	}
	public int Get_No_Of_Breadcrums() {
		List<WebElement> Breadcrum_Elements = driver.findElements(Breadcrums);
		Actual_Breadcrum_Size  = Breadcrum_Elements.size();
		return Actual_Breadcrum_Size;
	}
	public int Get_No_of_Tiles() {
		List<WebElement> Tile_Elements = driver.findElements(Tiles);
		Actual_Tile_Size  = Tile_Elements.size();
		return Actual_Tile_Size;
	}
	
	
}
