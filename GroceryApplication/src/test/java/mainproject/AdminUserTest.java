package mainproject;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.AdminUserPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class AdminUserTest extends Base
{
	HomePage hp;
	AdminUserPage ap;
	@Test
	public void verifyWhetherUserIsAbleToAddNewAdminUser() throws IOException
	{
		String usernameValue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage lp = new LoginPage(driver);
		lp.enterUsername(usernameValue).enterPassword(passwordValue);
		hp=lp.clickLogin();
		ap=hp.clickAdminMoreInfo();
		ap.clickNew();
		RandomDataUtility rd = new RandomDataUtility();
		String newUsernameValue = rd.generateRandomUsername();
		String newPasswordValue = rd.generateRandomPassword();
		ap.enterNewUsername(newUsernameValue).enterNewPassword(newPasswordValue).selectUserType().clickSaveUser();
		String actual = ap.verifyAddUserAlertIsDisplayed();
		String expected = "×\nAlert!\nUser Created Successfully";
		Assert.assertEquals(actual,expected, Constant.ADDNEWADMINUSERERROR);
	}
	@Test
	public void verifyWhetherUserIsAbleToSearchNewlyAddedAdminUser()throws IOException
	{
		String usernameValue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage lp = new LoginPage(driver);
		lp.enterUsername(usernameValue).enterPassword(passwordValue);
		hp=lp.clickLogin();
		ap=hp.clickAdminMoreInfo();
		ap.clickSearch();	
		String usernameToSearch = ExcelUtility.getStringData(0, 0, "NewUser");
		ap.enterUsernameToSearch(usernameToSearch).selectSearchUserType().clickSearchUser();
		String actual = ap.verifySearchedUsernameDisplayed();
		String expected = usernameToSearch;
		Assert.assertEquals(actual,expected, Constant.ADMINUSERNOTFOUNDERROR);
	}
}
