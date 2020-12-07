package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class ParallelTests
{
	private WebDriver driver;
	
	@Test(groups = "Chrome")
	public void launchChrome()
	{
		System.setProperty("webdriver.chrome.driver","/Users/cajetanfernandes/OneDrive/Documents/Studies and Certs/Automation Testing Masters/Phase 2/Jars/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
		driver.manage().window().maximize();
		try
		{
			Thread.sleep(2000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Test(groups = "Chrome", dependsOnMethods = "launchChrome")
	public void actionFBONChrome()
	{
		driver.findElement(By.name("login")).click();
	}
	
	@Test(groups = "Firefox")
	public void launchFirefox()
	{

		System.setProperty("webdriver.gecko.driver","/Users/cajetanfernandes/OneDrive/Documents/Studies and Certs/Automation Testing Masters/Phase 2/Jars/geckodriver");
		driver = new FirefoxDriver();
		driver.get("https://www.facebook.com");
		driver.manage().window().maximize();
		try
		{
			Thread.sleep(2000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Test(groups = "Firefox", dependsOnMethods = "launchFirefox")
	public void actionFBONFirefox()
	{
		driver.findElement(By.name("login")).click();
	}
	
	@AfterTest
	public void closeBrowsers()
	{
		driver.quit();
	}
}
