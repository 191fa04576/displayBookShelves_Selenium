package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BeingAtHomePage extends BasePage {
	public BeingAtHomePage(WebDriver driver) {
		super(driver);
		
	}
	// Locates the search box element using its XPath
	@FindBy(xpath="//*[@id=\"search\"]")
	WebElement searchBox;
	
	
	// Locates the search button element using its XPath
	@FindBy(xpath="//*[@id=\"search_button\"]/span")
	WebElement searchBoxClick;
	
	
	// Locates the category element using its XPath
	@FindBy(xpath="//*[@id=\"filters-form\"]/div[1]/div/div/ul/li[1]")
	 WebElement category;
	
	// Locates a list of category elements using their XPath
	@FindBy(xpath="//*[@id='filters-form']/div[1]/div/div/ul/li[1]/div[2]/div/div/div/ul/li/label")
	 List<WebElement> beingAtHome_Categories;
	
	// Method to enter a value into the search box
	public void value_SearchBox(String value) {
		searchBox.sendKeys(value);
	}
	// Method to click the search button
	public void clickSearchBox() {
		searchBoxClick.click();
	}
	// Method to hover over the category element
	public void hoverCategory() {
	 actions.moveToElement(category).perform();
	}
	
	// Method to return the list of category elements
	public List<WebElement> getCategories() {
		return beingAtHome_Categories;
		
	}
  
}
