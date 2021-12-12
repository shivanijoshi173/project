package testScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class urbanladder 
{
	static 
	{
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	}
	@Test
	public static void demo() throws Throwable 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.urbanladder.com/");
		WebElement decor = driver.findElement(By.xpath("//span[text()='Decor']"));
		Actions a =new Actions(driver);
		a.moveToElement(decor);
		
		WebElement wallmirror = driver.findElement(By.xpath("//span[text()='Wall Mirrors']"));
		a.click(wallmirror);
		
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		js.executeScript("arguments[0].click();",decor);
		String title = driver.getTitle();
		System.out.println(title);
		String exptitle="https://www.urbanladder.com/decor-bestsellers?src=g_topnav_collections_best-sellers_decor";
		SoftAssert s=new SoftAssert();
		s.assertEquals(title,exptitle);
	
		//WebElement close = driver.findElement(By.xpath("//a[contains(text(),'Close')]"));
		//if(close.isDisplayed())
		//{
			//close.click();
		//}
		
//		WebElement wallmirror = driver.findElement(By.xpath("//span[text()='Wall Mirrors']"));
//		WebDriverWait wait=new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.elementToBeClickable(wallmirror));
		
		
		//driver.close();
	}

}
