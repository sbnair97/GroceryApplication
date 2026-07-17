package mainproject;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;


public class ManageNewsTest extends Base
{
	HomePage hp;
	ManageNewsPage np;
	@Test
	public void verifyWhetherUserIsAbleToAddNewNews() throws IOException
	{
		String usernameValue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage lp = new LoginPage(driver);
		lp.enterUsername(usernameValue).enterPassword(passwordValue);
		hp=lp.clickLogin();
		np=hp.clickNewsMoreInfo();
		np.clickNew();
		String newNewsValue = ExcelUtility.getStringData(0, 0, "News");
		np.enterNewNews(newNewsValue).clickSaveNews();
		String actual = np.verifyAddNewsAlertIsDisplayed();
		String expected = "×\nAlert!\nNews Created Successfully";
		Assert.assertEquals(actual,expected, Constant.ADDNEWNEWSERROR);
	}
	@Test
	public void verifyWhetherUserIsAbleToSearchNewlyAddedNews()throws IOException
	{
		String usernameValue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage lp = new LoginPage(driver);
		lp.enterUsername(usernameValue).enterPassword(passwordValue);
		hp=lp.clickLogin();
		np=hp.clickNewsMoreInfo();
		np.clickSearch();
		String newNewsValue = ExcelUtility.getStringData(0, 0, "News");
		np.enterNewsToSearch(newNewsValue).clickSearchNews();
		String actual = np.verifySearchedNewsDisplayed();
		String expected = newNewsValue;
		Assert.assertEquals(actual,expected, Constant.NEWSNOTFOUNDERROR);
	}
}
