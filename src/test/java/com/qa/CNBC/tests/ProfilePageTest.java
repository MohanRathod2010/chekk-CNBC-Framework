package com.qa.CNBC.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.CNBC.Utils.Constants;
import com.qa.CNBC.base.BaseTest;

public class ProfilePageTest extends BaseTest {

	@BeforeClass
	public void profSetUp() throws InterruptedException {
		myAccPage = signInAccountPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		Thread.sleep(5000);
		myAccPage.clickOnMyAccountMenu();
		Thread.sleep(5000);
		myAccPage.clickOnProfile();
	}

	@Test

	public void ProfileUpdateTest() throws InterruptedException {
		String myAccMenuText = myAccPage.getMyAccountMenuText();
		Assert.assertEquals(myAccMenuText, Constants.MYACCOUNT_PAGE_MYACCOUNTMENU);
		String contactChangesSavedMsg = profPage.profileUpdate(prop.getProperty("firstName").trim(),
				prop.getProperty("lastName").trim(), prop.getProperty("emailId").trim());
		Assert.assertEquals(contactChangesSavedMsg, Constants.PROFILE_UPDATE_SaveChangeSUCCESS_MESSG);

		String pwdResetMsg = profPage.resetPassword(prop.getProperty("OldPwd").trim(),
				prop.getProperty("NewPwd").trim(), prop.getProperty("ConfirmNewPwd").trim());
		Assert.assertEquals(pwdResetMsg, Constants.PASSWORDRESET_CONFIRMATION_MESSG);

	}
}
