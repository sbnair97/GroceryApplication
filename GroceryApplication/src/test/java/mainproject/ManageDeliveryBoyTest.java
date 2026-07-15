package mainproject;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageDeliveryBoyPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class ManageDeliveryBoyTest extends Base
{
	HomePage hp;
	ManageDeliveryBoyPage mdb;
	@Test(description="User is trying to add new delivery boy")
	public void verifyWhetherUserIsAbleToAddNewDeliveryBoy() throws IOException
	{
		String usernameValue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage lp = new LoginPage(driver);
		lp.enterUsername(usernameValue).enterPassword(passwordValue);
		hp=lp.clickLogin();
		mdb=hp.clickDeliveryBoyMoreInfo();
		RandomDataUtility rd = new RandomDataUtility();
		String fullNameValue = rd.generateFullName();
		String emailIdValue = rd.generateRandomEmailId();
		String phoneNumberValue = rd.getRandomPhoneNumber();
		String addressValue = ExcelUtility.getStringData(0, 0, "ContactAddress");
		String newUsernameValue = rd.generateRandomUsername();
		String newPasswordValue = rd.generateRandomPassword();	
		mdb.clickNew().enterFullName(fullNameValue).enterEmailId(emailIdValue).enterPhone(phoneNumberValue).enterNewAddress(addressValue).enterNewUsername(newUsernameValue).enterNewPassword(newPasswordValue).clickSaveUser();
		String actual = mdb.verifyAlertIsDisplayed();
		String expected = "×\nAlert!\nDelivery Boy Details Created Successfully";
		Assert.assertEquals(actual,expected, Constant.UPDATECONTACTERROR);
	}
}
