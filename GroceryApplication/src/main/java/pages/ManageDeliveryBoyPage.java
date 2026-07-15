package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageDeliveryBoyPage 
{
	public WebDriver driver;
	public ManageDeliveryBoyPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	  
	}
	@FindBy(xpath="//a[@onclick='click_button(1)']") WebElement newDeliveryBoy;
	@FindBy(xpath="//input[@id='name']") WebElement deliveryBoyName;
	@FindBy(xpath="//input[@id='email']") WebElement emailId;
	@FindBy(xpath="//input[@id='phone']") WebElement phoneNumber;
	@FindBy(xpath="//textarea[@placeholder='Enter the Address']") WebElement address;	
	@FindBy(xpath="//input[@id='username']") WebElement newUsername;
	@FindBy(xpath="//input[@id='password']") WebElement newPassword;
	@FindBy(xpath="//button[@class='btn btn-danger']") WebElement saveDeliveryBoy;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement successText;
	
	public ManageDeliveryBoyPage clickNew()
	{
		newDeliveryBoy.click();
		return this;
	}
	public ManageDeliveryBoyPage enterFullName(String fullNameValue)
	{
		deliveryBoyName.sendKeys(fullNameValue);
		return this;
	}
	public ManageDeliveryBoyPage enterEmailId(String emailIdValue)
	{
		emailId.sendKeys(emailIdValue);
		return this;
	}
	public ManageDeliveryBoyPage enterPhone(String phoneNumberValue)
	{
		phoneNumber.sendKeys(phoneNumberValue);
		return this;
	}
	
	public ManageDeliveryBoyPage enterNewAddress(String newAddressValue)
	{
		address.sendKeys(newAddressValue);
		return this;
	}
	public ManageDeliveryBoyPage enterNewUsername(String newUsernameValue)
	{
		newUsername.sendKeys(newUsernameValue);
		return this;
	}
	public ManageDeliveryBoyPage enterNewPassword(String newPasswordValue)
	{
		newPassword.sendKeys(newPasswordValue);
		return this;
	}
	public ManageDeliveryBoyPage clickSaveUser()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",saveDeliveryBoy);
		return this;
	}
	public String verifyAlertIsDisplayed()
	{
		return successText.getText();
	}
}
