package com.crm.vtiger.OpportunityTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.ExcelUtility;
import com.crm.vtiger.GenericUtils.FileUtility;
import com.crm.vtiger.POMRepository.lib.CreateCampaignPage;
import com.crm.vtiger.POMRepository.lib.CreateOpportunity;
import com.crm.vtiger.POMRepository.lib.Homepage;
import com.crm.vtiger.POMRepository.lib.Login;
import com.crm.vtiger.POMRepository.lib.Opportunity;

public class TC_03CreateOprWithProposalPriceQuotePOM 
{	

	@Test(groups = "regression")
	public void CreateOprWithProposalPriceQuote() throws Throwable
	{
		WebDriver driver=new ChromeDriver();
		ExcelUtility elib=new ExcelUtility();
		FileUtility file=new FileUtility();
		
		String url = file.getDataFromJson("url");
		String username = file.getDataFromJson("username");
		String password = file.getDataFromJson("password");
		driver.get(url);
	   Login l=new Login(driver); 
	   l.logintovtiger(username,password);
	   Homepage hp=new Homepage(driver);
	   hp.quickCreate();
	   
	   Thread.sleep(5000);
	   CreateCampaignPage ccp = new CreateCampaignPage(driver);
	   String campName = elib.getExcelData("Sheet2", 1, 1);
	   ccp.campaignTextField(campName);
	   ccp.createCapm();
	   ccp.getSaveButton().click();
	   hp.OppLink();
	   Opportunity opr=new Opportunity(driver);
	   opr.getOppIcon();
	   
	   CreateOpportunity copr=new CreateOpportunity(driver);
	   String opnm=elib.getExcelData("Sheet1", 1, 1);
	   copr.oppnm(opnm);
	   
	   copr.getOgrIcon();
	   String amt=elib.getExcelData("Sheet1", 1, 4);
	   copr.Amount(amt);
	   String optyp=elib.getExcelData("Sheet1", 1, 5);
	   copr.opptype(optyp);
	   
	   copr.closeDate();
	   copr.leadSource();
	   copr.checkbox();
	   copr.sgroup();
	   copr.stage3();
	   copr.selectcampaign();
	  // copr.save();
	  // hp.clickonAdminIcon();
	   //hp.signout();
	   driver.close();
		
	}

}
