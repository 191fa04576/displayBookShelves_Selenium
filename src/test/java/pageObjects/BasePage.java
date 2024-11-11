package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	     WebDriver driver;
	     Actions actions;
	     JavascriptExecutor js;
	      WebDriverWait wait;

	     public BasePage(WebDriver driver) {
	         this.driver = driver;
	         this.actions = new Actions(driver);
	         this.js = (JavascriptExecutor) driver;
	         this.wait = new WebDriverWait(driver, Duration.ofSeconds(60)); 
	         PageFactory.initElements(driver, this);
	     }
      
}
