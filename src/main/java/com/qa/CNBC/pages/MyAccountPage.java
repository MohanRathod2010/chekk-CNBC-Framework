package com.qa.CNBC.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v111.systeminfo.model.VideoDecodeAcceleratorCapability;
import org.testng.Assert;

import com.qa.CNBC.Utils.Constants;
import com.qa.CNBC.Utils.ElementsUtil;

public class MyAccountPage {

	public WebDriver driver;
	private ElementsUtil eleUtil;

	// Private By Locators - Object Repo
	private By myAccountMenu = By.xpath("//button[normalize-space()='MY ACCOUNT']");
	private By profilelink = By.cssSelector("#account-dropdownMenu > li:nth-child(2) > a");
	private By signOutLink = By.xpath("//*[@id='account-dropdownMenu']/li[5]/a");
	private By loggedInUser = By.xpath("//*[@id='account-dropdownMenu']/li[1]/a");

	// Public page class constructor
	public MyAccountPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementsUtil(this.driver);
	}

	// Public page methods

	public String getmyAccPageTitle() {
		return driver.getTitle();
	}

	public String getMyAccountMenuText() throws InterruptedException {

		eleUtil.waitForElementVisible(myAccountMenu, Constants.DEFAULT_ELEMENT_WAIT_TIME_OUT);
		Thread.sleep(4000);
		String myACCMenuText = eleUtil.doGetElementText(myAccountMenu);
		System.out.println(myACCMenuText);
		return myACCMenuText;

	}

	public boolean isSignOutLinkExist() throws InterruptedException {
		eleUtil.waitForElementVisible(myAccountMenu, Constants.DEFAULT_ELEMENT_WAIT_TIME_OUT);
		Thread.sleep(4000);
		eleUtil.doClick(myAccountMenu);
		System.out.println("Sign Out Link Exists ");
		return eleUtil.doIsDisplayed(signOutLink);
	}

	public String getLoggedInUser() {
		eleUtil.waitForElementVisible(myAccountMenu, Constants.DEFAULT_ELEMENT_WAIT_TIME_OUT);
		String loggedinusername = eleUtil.doGetElementText(loggedInUser);
		System.out.println("Logged in user name is -> " + loggedinusername);
		return loggedinusername;
	}

	public void clickOnProfile() {
		eleUtil.doClick(profilelink);
	}

	public void clickOnMyAccountMenu() {
		eleUtil.waitForElementVisible(myAccountMenu, Constants.DEFAULT_ELEMENT_WAIT_TIME_OUT).click();
	}

	public void clickOnSignoutt() throws InterruptedException {
		eleUtil.doClick(signOutLink);

	}

	public ProfilePage clickOnProfileOption() {
		WebElement Profpage = eleUtil.waitForElementVisible(profilelink, Constants.DEFAULT_ELEMENT_WAIT_TIME_OUT);
		Profpage.click();
		return new ProfilePage(driver);

	}

}
