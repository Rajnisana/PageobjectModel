package com.qa.testBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.utilities.TestUtil;

public class MyTestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public MyTestBase(){
		
		try {
			
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:/Users/rajni/eclipse-workspace/pageTest/src/main/java/com/" 
			+"/qa/configuration/config.properties");
			prop.load(ip);
		
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
			
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static void initialization() {
		
		String browserName=	prop.getProperty("Browser");
		
		if(browserName.equalsIgnoreCase("chrome")){
			
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\rajni\\Documents\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			
		}else if (browserName.equalsIgnoreCase("firefox")) {
			
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\rajni\\Documents\\Drivers\\geckodriver");
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.pageLoadTime, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.implicitWaittime, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
		
	
	}



}
