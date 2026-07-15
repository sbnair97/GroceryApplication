package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ManageNewsPage 
{

	public WebDriver driver;
	public ManageNewsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	  
	}

	@FindBy(xpath="//a[@onclick='click_button(1)']") WebElement addNewNews;
	@FindBy(xpath="//textarea[@id='news']") WebElement enterNewNews;
	@FindBy(xpath="//button[@name='create']") WebElement saveNews;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement successText;
	@FindBy(xpath="//a[@onclick='click_button(2)']") WebElement search;
	@FindBy(xpath="//input[@name='un']") WebElement newsTitle;
	@FindBy(xpath="//button[@name='Search']") WebElement searchNews;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td[1]") WebElement searchNewsResult;
	
	public ManageNewsPage clickNew()
	{
		addNewNews.click();
		return this;
	}
	public ManageNewsPage enterNewNews(String newNewsValue)
	{
		enterNewNews.sendKeys(newNewsValue);
		return this;
	}
	public ManageNewsPage clickSaveNews()
	{
		saveNews.click();
		return this;
	}
	public String verifyAddNewsAlertIsDisplayed()
	{
		return successText.getText();
	}
	public ManageNewsPage clickSearch()
	{
		search.click();
		return this;
	}
	public ManageNewsPage enterNewsToSearch(String newsToSearch)
	{
		newsTitle.sendKeys(newsToSearch);
		return this;
	}
	
	public ManageNewsPage clickSearchNews()
	{
		searchNews.click();
		return this;
	}
	public String verifySearchedNewsDisplayed()
	{
		return searchNewsResult.getText();
	}
}
