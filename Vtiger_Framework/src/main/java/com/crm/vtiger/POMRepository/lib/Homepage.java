package com.crm.vtiger.POMRepository.lib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiger.GenericUtils.WebDriverUtility;

public class Homepage extends WebDriverUtility
{
	WebDriver driver;
	public Homepage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText="Opportunities")
	private WebElement OpportunitiesLink;
	
	@FindBy(linkText="Organizations")
	private WebElement OrganizationsLink;

	@FindBy(id="qccombo")
	private WebElement quickCreate;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminIcon;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement logout;
	
	
	public WebElement getQuickCreate() 
	{
		return quickCreate;
	}

	public WebElement getOpportunitiesLink() 
	{
		return OpportunitiesLink;
	}
	
	public WebElement getOrganizationsLink() {
		return OrganizationsLink;
	}
	public void OrgLink()
	{
		OrganizationsLink.click();
	}
	public void OppLink()
	{
		OpportunitiesLink.click();
	}

	public WebElement getAdminIcon() 
	{
		return adminIcon;
	}
	
	public void clickonAdminIcon()
	{
		adminIcon.click();
	}
	
	public WebElement getLogout() 
	{
		return logout;
	}

	public void quickCreate()
	{
		SelectOption(quickCreate, "New Campaign");
	}
	public void signout()
	{
	WebDriverUtility webd=new WebDriverUtility();
	webd.mouseOver(driver,adminIcon );
	logout.click();
	}
	
	
	
}
