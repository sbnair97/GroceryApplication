package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import utilities.PageUtility;

public class AdminUserPage 
{
	public WebDriver driver;
	PageUtility pu = new PageUtility();
	public AdminUserPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	  
	}

	@FindBy(xpath="//a[@onclick='click_button(1)']") WebElement newUser;
	@FindBy(xpath="//input[@id='username']") WebElement newUsername;
	@FindBy(xpath="//input[@id='password']") WebElement newPassword;
	@FindBy(xpath="//select[@id='user_type']") WebElement userType;
	@FindBy(xpath="//button[@name='Create']") WebElement saveUser;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement successText;
	@FindBy(xpath="//a[@onclick='click_button(2)']") WebElement searchUser;
	@FindBy(xpath="//input[@id='un']") WebElement searchUsername;
	@FindBy(xpath="//select[@id='ut']") WebElement searchUserType;
	@FindBy(xpath="//button[@name='Search']") WebElement search;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td[1]") WebElement usernameResult;
	
	public AdminUserPage clickNew()
	{
		newUser.click();
		return this;
	}
	public AdminUserPage enterNewUsername(String newUsernameValue)
	{
		newUsername.sendKeys(newUsernameValue);
		return this;
	}
	public AdminUserPage enterNewPassword(String newPasswordValue)
	{
		newPassword.sendKeys(newPasswordValue);
		return this;
	}
	public AdminUserPage selectUserType() 
	{
		pu.selectDropdownWithVisibleText(userType, "Admin");
		return this;
	}
	public AdminUserPage clickSaveUser()
	{
		saveUser.click();
		return this;
	}
	public String verifyAddUserAlertIsDisplayed()
	{
		return successText.getText();
	}
	public AdminUserPage clickSearch()
	{
		searchUser.click();
		return this;
	}
	public AdminUserPage enterUsernameToSearch(String usernameToSearch)
	{
		searchUsername.sendKeys(usernameToSearch);
		return this;
	}
	public AdminUserPage selectSearchUserType() 
	{
	    pu.selectDropdownWithVisibleText(searchUserType, "Admin");
	    return this;
	}
	public AdminUserPage clickSearchUser()
	{
		search.click();
		return this;
	}
	public String verifySearchedUsernameDisplayed()
	{
		return usernameResult.getText();
	}
}
