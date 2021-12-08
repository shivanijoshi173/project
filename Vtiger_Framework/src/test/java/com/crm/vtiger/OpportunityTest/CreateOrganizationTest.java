package com.crm.vtiger.OpportunityTest;

import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.BaseClass;
import com.crm.vtiger.POMRepository.lib.Homepage;
import com.crm.vtiger.POMRepository.lib.OrganizationPage;

public class CreateOrganizationTest extends BaseClass
{
	@Test(groups="smoke")
	public void createOrganizationTest() throws Throwable
	{
		//read test data from Excel
		String ORGNAME=elib.getExcelData("Sheet1",1,3)+jlib.getRamdomData();
		System.out.println(ORGNAME);
				
		//click on organization link
		Homepage hp=new Homepage(driver);
		hp.OrgLink();
		
		//click on create organization page
		OrganizationPage op=new OrganizationPage(driver);
		Thread.sleep(2000);
		op.clickOnCreateOrganizationImg();
		op.orgNameText(ORGNAME);
		
	}
	
}
