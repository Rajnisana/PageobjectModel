package com.qa.pages;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.testBase.MyTestBase;

public class LoginPage extends MyTestBase{
	
	//Page factory or object repository
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement loginbutton;
	
	@FindBy(xpath = "//button[contains(text(),'signup']")
	
	WebElement SingUpButton;
	
	
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	
	public String validateLoginPageTitle() {
		
		return driver.getTitle();
		
	}
	
	public HomePage login(String un, String pwd) {
		
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginbutton.click();
		
		return new HomePage();
		
	}
}
