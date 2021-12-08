package com.crm.vtiger.POMRepository.lib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunityInfoPage 
{
	public OpportunityInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath ="//font[text()='Closed Lost']")
	private WebElement salesStageActual;

	public WebElement getSalesStageActual() 
	{
		return salesStageActual;
	}
}
