package com.qa.CNBC.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.CNBC.chekkfactory.DriverFactory;
import com.qa.CNBC.pages.SignInAccountPage;
import com.qa.CNBC.pages.MyAccountPage;
import com.qa.CNBC.pages.ProfilePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	DriverFactory df;
	protected Properties prop;
	public WebDriver driver;
	protected SignInAccountPage signInAccountPage;
	protected MyAccountPage myAccPage;
	protected ProfilePage profPage;

	
	@BeforeTest 
	public void setUp() {
		df=new DriverFactory();
		prop=df.init_prop();
		driver=df.init_driver(prop);
		signInAccountPage = new SignInAccountPage(driver);
		profPage = new ProfilePage(driver);
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
	

}
