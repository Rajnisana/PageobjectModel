package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.testBase.MyTestBase;

public class loginPageTest extends MyTestBase{
	
	LoginPage loginPage;
	HomePage homePage;

	public loginPageTest() {
		super();
	}
	
	

	@BeforeMethod
	public void setup() {
		
		System.out.println("before initialization");

		
		initialization();
		
		loginPage= new LoginPage();
	}
	
	
	@Test(priority =1)
	
	public void PageTitle() {
		
		String title = loginPage.validateLoginPageTitle();
		
		Assert.assertEquals(title, "Free CRM software in the cloud powers sales and customer service");
	}
	
	@Test(priority =2)
	
	public void login() {
		
		homePage= loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@AfterMethod
	
	public void closeBrowser() {
		
		driver.quit();
		System.out.println("browser closed");
	}
	

}
