package com.qa.CNBC.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.CNBC.Utils.Constants;
import com.qa.CNBC.base.BaseTest;
import com.qa.CNBC.pages.MyAccountPage;
import com.qa.CNBC.pages.SignInAccountPage;

public class SignInAccontPageTest extends BaseTest {

	@Test(priority = 1)
	public void signInAccPageTitleTest() {
		String actualTitle = signInAccountPage.getSignInAccountPageTitle();
		Assert.assertEquals(actualTitle, Constants.SIGNIN_ACCOUNTPAGE_TITLE);
	}

	@Test(priority = 2)

	public void signAcctPageUrlTest() {
		String actualUrl = signInAccountPage.getSignInPageURL();
		Assert.assertEquals(actualUrl, Constants.SIGN_Page_URL_FRACTION);
	}

	@Test(priority = 3)

	public void forgotPwdLinkExistTest() throws InterruptedException {
		signInAccountPage.clickSignInLink();
		Assert.assertTrue(signInAccountPage.isForgotPwdLinkExists());
		signInAccountPage.closeSignInWindow();
	}

	@Test(priority = 4)

	public void createFreeAccountTest() throws InterruptedException {
		signInAccountPage.clickSignInLink();
		Assert.assertTrue(signInAccountPage.isCreateFreeAccountLinkExists());
		signInAccountPage.closeSignInWindow();

	}

	@Test(priority = 5)

	public void SignInTest() throws InterruptedException {

		MyAccountPage myAccPage = signInAccountPage.doLogin(prop.getProperty("username").trim(),
				prop.getProperty("password").trim());
		Thread.sleep(4000);
		String StringmyAccMenuText = myAccPage.getMyAccountMenuText();
		System.out.println("Account Menu Text " + StringmyAccMenuText);
		Assert.assertEquals(StringmyAccMenuText, Constants.MYACCOUNT_PAGE_MYACCOUNTMENU);
		Assert.assertTrue(myAccPage.isSignOutLinkExist());
		String LoggedInUserName = myAccPage.getLoggedInUser();
		Assert.assertEquals(LoggedInUserName, Constants.MYACCOUNT_PAGE_USERLOGGEDIN);

	}

}
