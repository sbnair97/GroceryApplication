package pages;


//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class ManageContactPage 
{

	public WebDriver driver;
	PageUtility pu = new PageUtility();
	public ManageContactPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	  
	}
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/contact/edit_contact?edit=1' and @role='button']") WebElement edit;
	@FindBy(xpath="//input[@id='phone']") WebElement phoneNumber;
	@FindBy(xpath="//input[@id='email']") WebElement emailId;
	@FindBy(xpath="//textarea[@placeholder='Enter the Address']") WebElement address;	
	@FindBy(xpath="//button[@class='btn btn-block-sm btn-info']") WebElement update;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement successText;
	public ManageContactPage clickEdit()
	{
		edit.click();
		return this;
	}
	public ManageContactPage editPhone(String phoneNumberValue)
	{
		phoneNumber.sendKeys(phoneNumberValue);
		return this;
	}
	public ManageContactPage editEmailId(String emailIdValue)
	{
		emailId.sendKeys(emailIdValue);
		return this;
	}
	public ManageContactPage enterNewAddress(String newAddressValue)
	{
		address.sendKeys(newAddressValue);
		return this;
	}
	public ManageContactPage clickUpdate()
	{
		//JavascriptExecutor js = (JavascriptExecutor)driver;
		//js.executeScript("arguments[0].click();",update);
		pu.click(driver, update);
		return this;
	}
	public String verifyAlertIsDisplayed()
	{
		return successText.getText();
	}
}
