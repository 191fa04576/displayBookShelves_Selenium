package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{

	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	public HomePage(WebDriver driver)
	{
		 // Calls the constructor of the BasePage class
		super(driver);
	}
	
	// Locates the bookShelves element using its XPath
	@FindBy(xpath="//*[@id=\"content\"]/div[3]/div/div[2]/a[7]") 
	// Declares a WebElement for the bookShelves element
	WebElement bookShelves;
	
	// Locates the studyChairs element using its XPath
	@FindBy(xpath="//a[@href='/study-chair?src=g_topnav_study_study-chairs_study-chairs']")
	// Declares a WebElement for the studyChairs element
	WebElement studyChairs;
	
	
	
	// Locates the searchBox element using its XPath
	@FindBy(xpath = "//*[@id='search']")
	// Declares a WebElement for the searchBox element
    WebElement searchBox;
	
	// Locates the closeButton element using its XPath
	@FindBy(xpath="//*[@id='authentication_popup']/div/div/div[2]/a[1]")
	 // Declares a WebElement for the closeButton element
	WebElement closeButton;
	
	// Locates the Login element using its XPath
			@FindBy(xpath="//*[@id='header-icon-login']")
			WebElement login;
	
	// Method to click the bookShelves element
    public void clickBookShelves()
    {
    	wait.until(ExpectedConditions.elementToBeClickable(bookShelves));
    	bookShelves .click(); 
    }
 // Method to click the closeButton element
    public void clickPopupCloseButton() {
     wait.until(ExpectedConditions.elementToBeClickable(closeButton));
    	closeButton.click();
    }
 // Method to click the studyChairs element
    public void clickStudyChairs()
    {
    	js.executeScript("arguments[0].click();", studyChairs);
    }
    
 
    
    // Method to enter a value into the searchBox
    public void searchBox(String value) {
    	searchBox.sendKeys(value);
    }
    
 // Method to click the closeButton element
    public void clickLoginButton() {
    	js.executeScript("arguments[0].click();", login);
    }

}
