package com.crm.vtiger.POMRepository.lib;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiger.GenericUtils.WebDriverUtility;

public class CreateCampaignPage extends WebDriverUtility
{
	WebDriver driver;
	public CreateCampaignPage(WebDriver driver)	
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name="campaignname")
	private WebElement campaignName;
	
	@FindBy(name ="campaigntype")
	private WebElement campaignType;
	
	@FindBy(xpath = "//input[@value='T']")
	private WebElement groupRadioButton;
	
	@FindBy(name = "assigned_group_id")
	private WebElement assignedToDropDown;
	
	@FindBy(name = "closingdate")
	private WebElement campaignClosingDate;
	
	@FindBy(name = "expectedresponse")
	private WebElement expectedResponse;
	
	@FindBy(name = "campaignstatus")
	private WebElement campaignStatus;
	
	@FindBy(xpath = "(//input[@name='button'])[1]")
	private WebElement saveButton;
	
	
	public WebElement getCampaignName() 
	{
		return campaignName;
	}

	public WebElement getCampaignType()
	{
		return campaignType;
	}

	public WebElement getGroupRadioButton()
	{
		return groupRadioButton;
	}
	
	public WebElement getAssignedToDropDown() 
	{
		return assignedToDropDown;
	}

	public WebElement getCampaignClosingDate() 
	{
		return campaignClosingDate;
	}

	public WebElement getExpectedResponse() 
	{
		return expectedResponse;
	}

	public WebElement getCampaignStatus() 
	{
		return campaignStatus;
	}

	public WebElement getSaveButton()
	{
		return saveButton;
	}
	 
	
	public void campaignTextField(String campName)
	{
		campaignName.sendKeys(campName);
	}  
	
	public void createCapm()
	{
		SelectOption(campaignType , "Advertisement");
		SelectOption(expectedResponse, "Excellent");
		SelectOption(campaignStatus, "Active");
		groupRadioButton.click();
		SelectOption(assignedToDropDown, "Team Selling");
		
		Date dateObj = new Date();
		String currentDate = dateObj.toString();
		int month = dateObj.getMonth();
		int date = dateObj.getDate();
		String year = currentDate.split("")[5];
		String actDate = year + "-" + month + "-" + date;
		WebElement closingDate = driver.findElement(By.name("closingdate"));
		closingDate.sendKeys(actDate);
		
	}

}
