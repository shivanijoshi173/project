package testScripts;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.ExcelUtility;
import com.crm.vtiger.GenericUtils.FileUtility;
import com.crm.vtiger.GenericUtils.WebDriverUtility;

import junit.framework.Assert;

public class TC_01CreateOprWithIdDecisionMakers
{
	static 
	{
		System.setProperty("webdriver.chrome.driver","./driver/chromedriverN.exe");
	}
	@Test
	public static void CreateOprWithIdDecisionMakers()  throws Throwable
	{
	WebDriver driver=new ChromeDriver();
	//creating objects of FileUtility,WebdriverUtility,ExcelUtility to use there generic methods in this progrmas .
	//FILEUTILITY WE USED FOR ACCESSING DATA FROM JSON 
	FileUtility file=new FileUtility();
	//WEBDRIVERUTILITY WE USED FOR ACCESSING SELECT CLASS AND ACTIONS CLASS METHODS 
	WebDriverUtility webd=new WebDriverUtility();
	//ExcelUtility WE USED FOR ACCESSING DATA FROM EXCEL
	ExcelUtility eu=new ExcelUtility();
		
	driver.manage().window().maximize();
	//IMPLICIT WAIT
	webd.waitUntilPageLoad(driver);
	
	//TAKING DATA FROM JSON
	String url = file.getDataFromJson("url");
	String username = file.getDataFromJson("username");
	String password = file.getDataFromJson("password");
	driver.get(url);
	driver.findElement(By.name("user_name")).sendKeys(username);
	driver.findElement(By.name("user_password")).sendKeys(password);
	driver.findElement(By.id("submitButton")).click();  
	
	//homepage===>click on Opportunities
	driver.findElement(By.linkText("Opportunities")).click();
	
	String parent=driver.getWindowHandle();

	//organization homepage====>click on create new organization icon
	driver.findElement(By.xpath("//img[@title='Create Opportunity...']")).click();	
	
	//now on new Opportunities creation page will display..
	//fill all the details.
	String oprName=eu.getExcelData("Sheet1", 1, 1);
	System.out.println(oprName);
	//Thread.sleep(2000);
	driver.findElement(By.name("potentialname")).sendKeys(oprName);
	
	//selecting organization 
	WebElement relatedToDropdown = driver.findElement(By.name("related_to_type"));
	webd.SelectOption(relatedToDropdown, "Organizations");
	
	//clicking on (+)image icon for selecting organization
	driver.findElement(By.xpath("(//img[@src='themes/softed/images/select.gif'])[1]")).click();
	//switching window controls with WEBDRIVER UTILITY METHODS
	String actualTitle=driver.getTitle();
	System.out.println(actualTitle);
	webd.switchToWindows(driver, actualTitle);
	driver.findElement(By.xpath("//a[text()='Test Yantra']")).click();
	driver.switchTo().window(parent);
	
	driver.findElement(By.name("amount")).sendKeys("4544245");
	//using select class method(SelectOption) from WebDriverUtility class for dropdown menu selecting 
	//TYPE
	WebElement S1=driver.findElement(By.name("opportunity_type"));
	webd.SelectOption(S1,"New Business");
	
	driver.findElement(By.name("closingdate")).clear();
	driver.findElement(By.name("closingdate")).sendKeys("2021-10-10");
	
	//using select class method(SelectOption) from WebDriverUtility class for dropdown menu selecting 
	//LEADSOURCE
	WebElement S2=driver.findElement(By.name("leadsource"));
	webd.SelectOption(S2,"Partner");
	
	//changing checkbox from user to group
	driver.findElement(By.xpath("//input[@value='T']")).click();
		
	//using select class method(SelectOption) from WebDriverUtility class for dropdown menu selecting 
	//assigned_group_id
	WebElement S3=driver.findElement(By.name("assigned_group_id"));
	webd.SelectOption(S3, "Support Group");
	
	//using select class method(SelectOption) from WebDriverUtility class for dropdown menu selecting 
	//LEADSOURCE
	WebElement S4=driver.findElement(By.name("sales_stage"));
	webd.SelectOption(S4,"Id. Decision Makers");
	
	//selecting Campaign 
	driver.findElement(By.xpath("(//img[@src='themes/softed/images/select.gif'])[2]")).click();;
	String parent1=driver.getWindowHandle();
	Set<String> win1=driver.getWindowHandles();
	Iterator<String> it1=win1.iterator();
	while(it1.hasNext())
	{
		String winId=it1.next();
		if(!parent.equals(winId))
		{
			driver.switchTo().window(winId);
			System.out.println(driver.switchTo().window(winId).getTitle());
			driver.findElement(By.linkText("lucky draw")).click();
		}
	}	
	driver.switchTo().window(parent1);
	
	//Description
	String Des=eu.getExcelData("Sheet1", 1, 13);
	driver.findElement(By.name("description")).sendKeys(Des);
	
	//to save contacts
	driver.findElement(By.xpath("(//input[@name='button'][1])[2]")).click();
	Thread.sleep(1000);
	
	String expResult="Id. Decision Makers";
	String actResult = driver.findElement(By.xpath("//font[text()='Id. Decision Makers']")).getText();
	System.out.println("ACTUAL RESULT:-  "+actResult);
	Assert.assertEquals(expResult, actResult);
	
	 driver.close();

}}
