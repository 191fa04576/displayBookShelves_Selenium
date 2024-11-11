package testCases;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.StudyChairsPage;
import testBase.BaseClass;

public class TC004_DisplayStudyChairs extends BaseClass {
	@Test
	public void test_displayStudyChairs() throws InterruptedException{
	HomePage hp=new HomePage(driver);
	hp.clickStudyChairs();
    StudyChairsPage s=new StudyChairsPage(driver);
    s.checkAndClickRecommended(); 
    List<WebElement>  studyChair_Name=s.getStudyChairNames();
    List<WebElement>  studyChair_Prices=s.getStudyChairPrices();
    Map<String, String> productMap = new HashMap<String, String>(); 
    
    for(int i=0;i<=2;i++) {
            productMap.put(studyChair_Name.get(i).getText(),studyChair_Prices .get(i).getText());
    } 
    System.out.println("Name and price of study_chairs");
    for (String key : productMap.keySet()) {
	    System.out.println("Product Name: " + key + ", Price: " + productMap.get(key));
	    System.out.println("Price: " + productMap.get(key));
	    System.out.println();
	}
     
	}
         
}
