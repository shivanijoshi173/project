package com.crm.vtiger.POMRepository.lib;

import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiger.GenericUtils.ExcelUtility;
import com.crm.vtiger.GenericUtils.WebDriverUtility;

public class CreateOpportunity extends WebDriverUtility
{
	WebDriver driver;
	ExcelUtility eu=new ExcelUtility();
	public CreateOpportunity(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(name="potentialname")
	private WebElement OPPName;
	
	@FindBy(xpath="(//img[@src='themes/softed/images/select.gif'])[1]")
	private WebElement ogrIcon;
	
	@FindBy(name="amount")
	private WebElement amount;
	
	@FindBy(name="opportunity_type")
	private WebElement opp_type;
	
	@FindBy(name="closingdate")
	private WebElement closedate;
	
	@FindBy(name="leadsource")
	private WebElement lead;
	
	@FindBy(xpath="//input[@value='T']")
	private WebElement chbox;
	
	public WebElement getOPPName() 
	{
		return OPPName;
	}
	
	public void oppnm(String opnm)
	{
		OPPName.sendKeys(opnm);
	}
	
	
	
	
	public void getOgrIcon() 
	{	
		String parent=driver.getWindowHandle();
		ogrIcon.click();
		String actualTitle=driver.getTitle();
		System.out.println(actualTitle);
		switchToWindows(driver, actualTitle);
		driver.findElement(By.xpath("//a[text()='Test Yantra']")).click();
		driver.switchTo().window(parent);
	}
	
	
	public WebElement getAmount() 
	{
		return amount;
	}
	public void Amount(String amt)
	{
		amount.sendKeys(amt);
	}
	
	
	public WebElement getOpp_type() 
	{
		return opp_type;
	}
	public void opptype(String optyp)
	{
		opp_type.sendKeys(optyp);
		//SelectOption(opp_type,"New Business");
	}
	
	
	public WebElement getClosedate() 
	{
		return closedate;
	}
	public void closeDate()
	{
		//closedate.clear();
		Date dataObj=new Date();
		String CurrentTimeAndDate=dataObj.toString();
		//System.out.println(CurrentTimeAndDate);
		int month=dataObj.getMonth()+1;
		int Datee=dataObj.getDate();
		String[] year=CurrentTimeAndDate.split("\\s+");
		//System.out.println(year[5]);
		String actualDate=year[5]+"-"+month+"-"+Datee;
		closedate.sendKeys(actualDate);
		//System.out.println("\n"+actualDate);
		
	}
	
	
	public WebElement getLead()
	{
		return lead;
	}
	public void leadSource()
	{
		SelectOption(lead, "Partner");
	}
	
	
	public WebElement getChbox() {
		return chbox;
	}
	public void checkbox()
	{
	chbox.click();
	}
	
	@FindBy(name="assigned_group_id")
	private WebElement group;
	public WebElement getGroup() {
		return group;
	}
	public void sgroup()
	{
		SelectOption(group,"Support Group");
	}

	@FindBy(name="sales_stage")
	private WebElement salesstage1;
	public WebElement getSalesstage() {
		return salesstage1;
	}
	public void stage1()
	{
		 SelectOption(salesstage1,"Id. Decision Makers");
		
	}
	
	@FindBy(name="sales_stage")
	private WebElement salesstage2;
	
	
	public WebElement getSalesstage2() {
		return salesstage2;
	}
	public void stage2()
	{
		SelectOption(salesstage1,"Perception Analysis");
	}

	@FindBy(name="sales_stage")
	private WebElement salesstage3;
	public WebElement getSalesstage3() {
		return salesstage3;
	}
	public void stage3() 
	{
		SelectOption(salesstage3,"Proposal/Price Quote");
	}

	
	@FindBy(name="sales_stage")
	private WebElement salesstage4;
	public WebElement getSalesstage4() {
		return salesstage4;
	}
	public void stage4() {
		SelectOption(salesstage4,"Negotiation/Review");
	}
	
	@FindBy(name="sales_stage")
	private WebElement salesstage5;
	public WebElement getSalesstage5() {
		return salesstage5;
	}
	public void stage5()
	{
		SelectOption(salesstage5,"Closed Won");
	}



	@FindBy(xpath="(//img[@src='themes/softed/images/select.gif'])[2]")
	private WebElement campaignselection;
	public WebElement getCampaignselection() {
		return campaignselection;
	}
	public void selectcampaign()
	{
		String parent=driver.getWindowHandle();

		driver.switchTo().window(parent);
		
		campaignselection.click();
		switchToWindows(driver, "Campaigns&action");
//		CampaignPage cp = new CampaignPage(driver);
//		cp.getSearchTextField().sendKeys(campName);
//		cp.getSearchButton().click();
		driver.findElement(By.xpath("//a[text()='ROAD SHOW'][1]")).click();
		
		driver.switchTo().window(parent);
	}
	
	@FindBy(xpath="(//input[@name='button'][1])[2]")
	private WebElement savebtn;
	public WebElement getSavebtn() {
		return savebtn;
	}
	public void save()
	{
		savebtn.click();
	}

	
	
	
}
