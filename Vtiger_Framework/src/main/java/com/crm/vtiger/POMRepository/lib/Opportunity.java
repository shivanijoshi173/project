package com.crm.vtiger.POMRepository.lib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Opportunity 
{
	public Opportunity(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@title='Create Opportunity...']")
	private WebElement OppIcon;

	public void getOppIcon() {
		OppIcon.click();
	}
	
	
	
	

}
