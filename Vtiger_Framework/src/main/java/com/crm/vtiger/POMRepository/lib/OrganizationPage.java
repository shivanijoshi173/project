package com.crm.vtiger.POMRepository.lib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage 
{
	public OrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createOrganizationButton;
	
	@FindBy(name="accountname")
	private WebElement orgName;
	
	public WebElement getOrgName() {
		return orgName;
	}
	public WebElement getCreateOrganizationButton() 
	{
		return createOrganizationButton;
	}
	
	public void clickOnCreateOrganizationImg()
	{
		createOrganizationButton.click();
	}

	public void  orgNameText(String orgnm)
	{
		orgName.sendKeys(orgnm);
	}
	
}
