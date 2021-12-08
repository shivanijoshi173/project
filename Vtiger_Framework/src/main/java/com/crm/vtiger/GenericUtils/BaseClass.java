  package com.crm.vtiger.GenericUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.crm.vtiger.POMRepository.lib.Homepage;
import com.crm.vtiger.POMRepository.lib.Login;

public class BaseClass 
{
	public WebDriver driver;
	public ExcelUtility elib=new ExcelUtility();
	public FileUtility file=new FileUtility();
	public JavaUtility jlib=new JavaUtility();
	public WebDriverUtility wlib=new WebDriverUtility();
	public DataBaseUtility dlib=new DataBaseUtility();
	
	
	@BeforeSuite
	public void connectDB()
	{
		//DLIB.connectToDB();
		System.out.println("======DB CONNECTION IS SUCCESSFULL======");
	}
	
	@Parameters(value= {"brouser"})//chrome,firefox
	@BeforeClass(groups="smoke")
	public void launchBrowser(@Optional("chrome") String BROWSERVALUE) throws Throwable
	{
		// read data from property file
		
		
		//String BROWSER =file.getDataFromJson("Browser");
		System.out.println("LAUNCHING BROWSER:-"+BROWSERVALUE);
		String url = file.getDataFromJson("url");
		
		if(BROWSERVALUE.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(BROWSERVALUE.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else
		{
			System.out.println("====INVALID BROWSER NAME====");
		}
		System.out.println("=====BROWSER LAUNCH SUCCESSFULL=====");
		driver.manage().window().maximize();
		wlib.waitUntilPageLoad(driver);
		driver.get(url);
	}
	
	@BeforeMethod(groups="smoke")
	public void loginToApp() throws Throwable
	{
		//read data from property file
		String username = file.getDataFromJson("username");
		String password = file.getDataFromJson("password");
		
		//login to app
		Login lp=new Login(driver);
		lp.logintovtiger(username, password);
		System.out.println("================LOGIN SUCCESSFULL===============");
	}
	
	@AfterMethod(groups="smoke")
	public void LogoutFromApp()
	{
		//signout from homepage
		Homepage hp=new Homepage(driver);
		hp.signout();
		System.out.println("=======SIGNOUT SUCCESSFULL========");
	}
	
	@AfterClass(groups="smoke")
	public void closeBrowser()
	{
		driver.close();
		System.out.println("=====BROWSER CLOSED SUCCESSFULLY=====");
	}
	
	@AfterSuite
	public void closeDB()
	{
		//dlib.close();
		System.out.println("====D CONNECTION CLOSED SUCCESSFULLY=====");
	}
	
	

}
