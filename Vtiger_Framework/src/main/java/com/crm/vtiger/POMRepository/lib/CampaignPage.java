package com.crm.vtiger.POMRepository.lib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignPage 
{
	public CampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "search_text")
	private WebElement searchTextField;
	
	@FindBy(name = "search")
	private WebElement searchButton;

	public WebElement getSearchTextField() 
	{
		return searchTextField;
	}

	public WebElement getSearchButton() 
	{
		return searchButton;
	}


}
