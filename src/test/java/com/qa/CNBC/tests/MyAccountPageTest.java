package com.qa.CNBC.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.CNBC.Utils.Constants;
import com.qa.CNBC.base.BaseTest;
import com.qa.CNBC.pages.MyAccountPage;
import com.qa.CNBC.pages.SignInAccountPage;

public class MyAccountPageTest extends BaseTest {

	// On what basis you certify that you logged in successfully

	@BeforeClass
	public void myAccSetupPage() throws InterruptedException {
		myAccPage = signInAccountPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		Thread.sleep(4000);
	}

	@Test(priority = 1)

	public void myAccPageTitleTest() {
		Assert.assertEquals(myAccPage.getmyAccPageTitle(), Constants.MYACC_PAGE_TITLE);
	}

	@Test(priority = 2)

	public void MyAccountMenuExistsTest() throws InterruptedException {
		Thread.sleep(5000);
		String actualMyAccMenuText = myAccPage.getMyAccountMenuText();
		Assert.assertEquals(actualMyAccMenuText, Constants.MYACCOUNT_PAGE_MYACCOUNTMENU);
	}

	@Test(priority = 3)

	public void SignOutLinkExistTest() throws InterruptedException {

		Assert.assertTrue(myAccPage.isSignOutLinkExist());
	}

	@Test(priority = 4)
	public void SigOutTest() throws InterruptedException {
		myAccPage.clickOnSignoutt();
	}

}
