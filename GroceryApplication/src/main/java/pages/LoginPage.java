package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class LoginPage 
{
public WebDriver driver;
WaitUtility wu = new WaitUtility();
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	  
	}
	//Syntax : @FindBy(locator = "attribute value") WebElement name;
	@FindBy(xpath="//input[@placeholder='Username']") WebElement username;
	@FindBy(xpath="//input[@placeholder='Password']") WebElement password; 
	@FindBy(xpath="//button[text()='Sign In']") WebElement login;
	@FindBy(xpath="//p[text()='Dashboard']") WebElement dashboard;
	@FindBy(xpath="//b[text()='7rmart supermarket']") WebElement text;
	public LoginPage enterUsername(String usernameValue)
	{
		username.sendKeys(usernameValue);
		return this;
	}
	public LoginPage enterPassword(String passwordValue)
	{
		password.sendKeys(passwordValue);
		return this;
	}
	public HomePage clickLogin()
	{
		wu.waitUntilElementToBeClickable(driver, login);
		login.click();
		return new HomePage(driver);
	}
	public boolean verifyWhetherDashboardIsDisplayed()
	{
		return dashboard.isDisplayed();
	}
	public String verifyLoginTextIsDisplayed()
	{
		return text.getText();
	}
	
}
