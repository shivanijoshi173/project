package com.crm.vtiger.POMRepository.lib;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organization 
{
	public Organization(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	} 
	
	@FindBy(name="accountname")
	private WebElement organizationName;
	
	@FindBy(xpath="(//input[@value='  Save  '])[1]")
	private WebElement saveButton;

	public WebElement getOrganizationName() 
	{
		return organizationName;
	}

	public WebElement getSaveButton() 
	{
		return saveButton;
	}
	
	public void createOrg(String orgName)
	{
		organizationName.sendKeys(orgName);
		saveButton.click();
	}
}