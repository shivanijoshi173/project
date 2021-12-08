package com.crm.vtiger.POMRepository.lib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login 
{
	WebDriver driver;
	public Login(WebDriver driver)
	{
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(name="user_name")
	private WebElement UserName;
	
	@FindBy(name="user_password")
	private WebElement UserPassword;
	
	@FindBy(id="submitButton")
	private WebElement Submit;

	public WebElement getUserName() {
		return UserName;
	}

	public WebElement getUserPassword() {
		return UserPassword;
	}

	public WebElement getSubmit() {
		return Submit;
	}
	
	public void logintovtiger(String un,String pwd)
	{
		//driver.manage().window().maximize();
		UserName.sendKeys(un);
		UserPassword.sendKeys(pwd);
		Submit.click();
	}
	
	
}
