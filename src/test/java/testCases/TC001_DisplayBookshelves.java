package testCases;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pageObjects.BookShelvesPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_DisplayBookshelves extends BaseClass {
	  @Test
       public void test_displayBookShelves() { 
    	   HomePage hp=new HomePage(driver);
    	   hp.clickBookShelves();
    	   hp.clickPopupCloseButton();
    	   BookShelvesPage b=new BookShelvesPage(driver);
    	   b.hoverStorage();
    	   b.Clickstorage();
    	   b.hoverPrice(); 
    	   b.slider(); 
    	   List<WebElement> bookShelf_Name=b.getBookShelfNames();
    	   List<WebElement> bookShelf_Prices=b.getBookShelfPrices();
    	   System.out.println("Name and price of bookShelves below 15000");
           System.out.println("-------------------------------------------");
           System.out.println("");
           Map<String, String> productMap = new HashMap<String, String>(); 
           
           for(int i=0;i<=2;i++)
           {
                   productMap.put(bookShelf_Name.get(i).getText(),bookShelf_Prices .get(i).getText());

           }
           for (String key : productMap.keySet())
           {
       	    System.out.println("Product Name: " + key);
       	    System.out.println("Price: " + productMap.get(key));
       	    System.out.println();
       	    }
           
         
          

           }
       } 

