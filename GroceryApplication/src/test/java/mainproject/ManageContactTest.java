package mainproject;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageContactPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class ManageContactTest extends Base
{
	HomePage hp;
	ManageContactPage mp;
	@Test
	public void verifyWhetherUserIsAbleToUpdateContact() throws IOException
	{
		String usernameValue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage lp = new LoginPage(driver);
		lp.enterUsername(usernameValue).enterPassword(passwordValue);
		hp=lp.clickLogin();
		mp=hp.clickContactMoreInfo();
		RandomDataUtility rd = new RandomDataUtility();
		String phoneNumberValue = rd.getRandomPhoneNumber();
		String emailIdValue = rd.generateRandomEmailId();
		String addressValue = ExcelUtility.getStringData(0, 0, "ContactAddress");
		mp.clickEdit();
		mp.editPhone(phoneNumberValue);
		mp.editEmailId(emailIdValue);
		mp.enterNewAddress(addressValue);
		mp.clickUpdate();
		String actual = mp.verifyAlertIsDisplayed();
		String expected = "×\nAlert!\nContact Updated Successfully";
		Assert.assertEquals(actual,expected, Constant.UPDATECONTACTERROR);
	}
}
