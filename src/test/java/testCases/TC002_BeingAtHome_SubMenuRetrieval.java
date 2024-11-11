package testCases;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pageObjects.BeingAtHomePage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC002_BeingAtHome_SubMenuRetrieval extends BaseClass{
	public Properties p;
	
	@Test
	public void test_beingAtHome() throws InterruptedException, IOException{
		 FileReader file=new FileReader(".//src//test//resources//config.properties");
		 p=new Properties();
		 p.load(file);
		HomePage hp=new HomePage(driver);
		hp.searchBox(p.getProperty("Search"));
		BeingAtHomePage b=new BeingAtHomePage(driver);
		b.clickSearchBox();
		b.hoverCategory();
		List<WebElement> category=b.getCategories();
		System.out.println("All Category under Being At Home");
		System.out.println("--------------------------------------");
		          for(WebElement value:category) {
		           String s=value.getText();
		        	System.out.println(s);
		        	
		        	 
		
        }
		          
	}
}
		
	


