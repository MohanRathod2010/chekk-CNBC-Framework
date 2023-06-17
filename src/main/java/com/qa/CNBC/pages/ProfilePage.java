package com.qa.CNBC.pages;

import java.security.PublicKey;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;

import com.qa.CNBC.Utils.Constants;
import com.qa.CNBC.Utils.ElementsUtil;

import net.bytebuddy.asm.Advice.Return;

public class ProfilePage {

	private WebDriver driver;
	private ElementsUtil eleUtil;

	private By profContactFirstname = By.id("firstname");
	private By profContactLastname = By.id("lastname");
	private By profContactEmail = By.name("email");
	private By profContactSaveChangesBtn = By.xpath("//button[@type='submit']");
	private By changesSavedSuccessMsg = By.xpath("//div[@class='ProfileForm-successMessage']");

	// Reset Password
	private By profOldPwd = By.name("oldPassword");
	private By profNewPwd = By.name("newPassword");
	private By profConfirmNewPwd = By.name("newPasswordConfirmation");
	private By profrstPwdSubmitBtn = By.name("signup");
	private By pwdResetconfirmMsg = By.xpath("//div[@class='ChangePassword-successMessage']");

	public ProfilePage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementsUtil(this.driver);
	}

	// public page methods

	public String profileUpdate(String firstName, String lastName, String emailId) throws InterruptedException {
		WebElement Firstname = eleUtil.waitForElementVisible(profContactFirstname,
				Constants.DEFAULT_ELEMENT_WAIT_TIME_OUT);
		Firstname.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		Firstname.sendKeys(Keys.DELETE);
		eleUtil.doSendKeys(profContactFirstname, firstName);
		Thread.sleep(4000);
		WebElement Lastname = eleUtil.waitForElementVisible(profContactLastname,
				Constants.DEFAULT_ELEMENT_WAIT_TIME_OUT);
		Lastname.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		Lastname.sendKeys(Keys.DELETE);
		eleUtil.doSendKeys(profContactLastname, lastName);
		Thread.sleep(4000);
		WebElement EmailID = eleUtil.waitForElementVisible(profContactEmail, Constants.DEFAULT_ELEMENT_WAIT_TIME_OUT);
		EmailID.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		EmailID.sendKeys(Keys.DELETE);
		eleUtil.doSendKeys(profContactEmail, emailId);
		eleUtil.doClick(profContactSaveChangesBtn);

		eleUtil.waitForElementVisible(changesSavedSuccessMsg, Constants.DEFAULT_ELEMENT_WAIT_TIME_OUT);
		String ChangesSavedScssMsg = eleUtil.doGetElementText(changesSavedSuccessMsg);
		System.out.println("Profile updated Success Message ->" + ChangesSavedScssMsg);
		if (ChangesSavedScssMsg.equals(Constants.PROFILE_UPDATE_SaveChangeSUCCESS_MESSG)) {
			System.out.println("Contact chnages has been saved -> " + ChangesSavedScssMsg);
		} else {
			System.out.println("Contact chnages has been not saved");

		}
		return ChangesSavedScssMsg;

	}

	public String resetPassword(String OldPwd, String NewPwd, String ConfirmNewPwd) throws InterruptedException {

		eleUtil.waitForElementVisible(profOldPwd, Constants.DEFAULT_ELEMENT_WAIT_TIME_OUT);

		eleUtil.doSendKeys(profOldPwd, OldPwd);
		eleUtil.waitForElementVisible(profNewPwd, Constants.DEFAULT_ELEMENT_WAIT_TIME_OUT);
		eleUtil.doSendKeys(profNewPwd, NewPwd);
		eleUtil.waitForElementVisible(profConfirmNewPwd, Constants.DEFAULT_ELEMENT_WAIT_TIME_OUT);
		eleUtil.doSendKeys(profConfirmNewPwd, ConfirmNewPwd);
		eleUtil.waitForElementVisible(profrstPwdSubmitBtn, Constants.DEFAULT_ELEMENT_WAIT_TIME_OUT);
		eleUtil.doClick(profrstPwdSubmitBtn);

		eleUtil.waitForElementVisible(pwdResetconfirmMsg, Constants.DEFAULT_ELEMENT_WAIT_TIME_OUT);

		String PasswordResetMessage = eleUtil.doGetElementText(pwdResetconfirmMsg);
		System.out.println("Password Reset Confirmation Message is ->" + PasswordResetMessage);
		if (PasswordResetMessage.equals(Constants.PASSWORDRESET_CONFIRMATION_MESSG)) {
			System.out.println("Password reset is successful ");
		} else {
			System.out.println("Password reset is not successful ");

		}
		return PasswordResetMessage;

	}
}
