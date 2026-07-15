package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage 
{
	public WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	  
	}
	
	@FindBy(xpath="//img[@class='img-circle']") WebElement admin;
	@FindBy(xpath="//i[@class='ace-icon fa fa-power-off']") WebElement logout;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']") WebElement moreInfo;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='small-box-footer']") WebElement newsMoreInfo;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact' and @class='small-box-footer']") WebElement contactMoreInfo;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-deliveryboy' and @class='small-box-footer']") WebElement manageDeliveryBoyInfo;
	public HomePage clickAdmin()
	{
		admin.click();
		return this;
	}
	public LoginPage clickLogout()
	{
		logout.click();
		return new LoginPage(driver);
	}
	public AdminUserPage clickAdminMoreInfo()
	{
		moreInfo.click();
		return new AdminUserPage(driver);
	}
	public ManageNewsPage clickNewsMoreInfo()
	{
		newsMoreInfo.click();
		return new ManageNewsPage(driver);
	}
	public ManageContactPage clickContactMoreInfo()
	{
		contactMoreInfo.click();
		return new ManageContactPage(driver);
	}
	public ManageDeliveryBoyPage clickDeliveryBoyMoreInfo()
	{
		manageDeliveryBoyInfo.click();
		return new ManageDeliveryBoyPage(driver);
	}
}
