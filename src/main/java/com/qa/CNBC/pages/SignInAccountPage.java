package com.qa.CNBC.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.CNBC.Utils.Constants;
import com.qa.CNBC.Utils.ElementsUtil;
import com.qa.CNBC.pages.MyAccountPage;

public class SignInAccountPage {

	public WebDriver driver;
	private ElementsUtil eleUtil;

	// Private By Locators - Object Repo
	private By signInLink = By.linkText("SIGN IN");
	private By CloseSignIn = By.cssSelector("#root > div.Modal-modalBackground > div > button > svg");
	private By signInUsername = By.name("email");
	private By signInPasword = By.name("password");
	private By SignInbtn = By.name("signin");
	private By forgotPwdLink = By.xpath("//*[normalize-space()='Forgot Password?']");
	private By createFreeAccountLink = By.linkText("CREATE FREE ACCOUNT");
	private By profileLink = By.xpath("//a[@title='profile']");
	private By signInAccountPage = By.xpath("//*[@id='GlobalNavigation']/div[2]/div/div/div[4]/div/button");
	private By signOutLink = By.linkText("SIGN OUT");

	// Public page class const
	public SignInAccountPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementsUtil(this.driver);
	}

	// Public page methods

	public String getSignInAccountPageTitle() {
		String title = eleUtil.waitForTitleIs(Constants.SIGNIN_ACCOUNTPAGE_TITLE,
				Constants.DEFAULT_ELEMENT_WAIT_TIME_OUT);
		System.out.println("login page title is: " + title);
		return title;
	}

	public void clickSignInLink() throws InterruptedException {
		eleUtil.doClick(signInLink);
	}

	public void closeSignInWindow() {
		eleUtil.doClick(CloseSignIn);
	}

	public String getSignInPageURL() {
		String url = eleUtil.waitForUrlContains(Constants.SIGN_Page_URL_FRACTION, Constants.DEFAULT_TIME_OUT);
		System.out.println("The Login page URL is :" + url);
		return url;
	}

	public boolean isForgotPwdLinkExists() throws InterruptedException {
		return eleUtil.waitForElementVisible(forgotPwdLink, Constants.DEFAULT_ELEMENT_WAIT_TIME_OUT).isDisplayed();
	}

	public boolean isCreateFreeAccountLinkExists() {
		return eleUtil.waitForElementVisible(createFreeAccountLink, Constants.DEFAULT_ELEMENT_WAIT_TIME_OUT)
				.isDisplayed();

	}

	// This method is to sign out from CNBC
	public void signOut() {
		eleUtil.doClick(signOutLink);

	}

	// This method is for login to CNBC

	public MyAccountPage doLogin(String username, String password) throws InterruptedException {
		eleUtil.doClick(signInLink);
		System.out.println(username + " : " + password);
		eleUtil.waitForElementVisible(signInUsername, Constants.DEFAULT_ELEMENT_WAIT_TIME_OUT).sendKeys(username);
		eleUtil.doSendKeys(signInPasword, password);
		eleUtil.doClick(SignInbtn);
		return new MyAccountPage(driver);

	}

}
