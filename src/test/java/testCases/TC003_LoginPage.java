package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginPage extends BaseClass {
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	public void test_Login(String email) throws IOException, InterruptedException {
		HomePage homePage=new HomePage(driver);
		homePage.clickLoginButton();
		LoginPage loginPage =new LoginPage(driver);
		
		loginPage.enterInvalidEmail(email);
		
		String errorMsg = loginPage.errorMessage();
		Assert.assertEquals("Please enter a valid email address.",errorMsg);
		System.out.println(errorMsg);
		new BaseClass().captureScreen("warning");
	
	}

}
