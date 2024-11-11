package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StudyChairsPage extends BasePage {
     public StudyChairsPage(WebDriver driver) {
    	// Calls the constructor of the BasePage class
    	 super(driver);
     }
 
  // Locates the sort_value element using its XPath
     @FindBy(xpath="//*[@id=\"content\"]/div[2]/div[1]/div/div/div/div/div[2]/div[1]/span")
  // Declares a WebElement for the sort_value element
     WebElement sort_value;
     
  // Locates the recommended_option element using its XPath
     @FindBy(xpath="//*[@id='content']/div[2]/div[1]/div/div/div/div/div[2]/div[2]/div/div/ul/li[1]")
     // Declares a WebElement for the recommended_option element
     WebElement recommended_option;
     
  // Locates the studyChair_Names elements using their XPath
     @FindBy(xpath="//*[@id='content']/div[3]/div/ul/li/div/div[5]/a/div[1]/span")
  // Declares a list of WebElements for the study chair names
     List<WebElement> studyChair_Names;

  // Locates the studyChair_Prices elements using their XPath
    @FindBy(xpath="//*[@id='content']/div[3]/div/ul/li/div/div[5]/a/div[2]/span")
 // Declares a list of WebElements for the study chair prices
    List<WebElement> studyChair_Prices;
	 
 // Method to check the sort value and click the recommended option if not already selected
     public void checkAndClickRecommended() {
    	String sort_text = sort_value.getText();
        if(!sort_text.equals("Recommended")) {
            recommended_option.click();
        }
    }
  // Method to get the list of study chair names
    public List<WebElement> getStudyChairNames() {
        return studyChair_Names;
    }
 // Method to get the list of study chair prices
    public List<WebElement> getStudyChairPrices() {
        return studyChair_Prices;
    }
    
}
