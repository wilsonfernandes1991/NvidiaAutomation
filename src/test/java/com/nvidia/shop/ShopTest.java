package com.nvidia.shop;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.nvidia.genericLib.Constants;

import junit.framework.Assert;

public class ShopTest {
	
	WebDriver driver = null;
	
	@BeforeClass
	public void lauchBrowser()
	{
		System.setProperty("webdriver.chrome.driver","Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test(priority=1)
	public void navigateToShopPage()
	{
		driver.get(Constants.url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Reporter.log("Page Loaded Successfully", true);
	}
	
	@Test(dependsOnMethods="navigateToShopPage")
	public void validatePageTitle()
	{
		Assert.assertEquals("Welcome to the Official NVIDIA Store", driver.getTitle());
		Reporter.log("Page Title verified",true);
	}
	
	@Test
	public void hbsdf()
	{
		Assert.assertTrue(true);
	}
	
	@Test
	public void hbsdfs()
	{
		Assert.assertTrue(true);
	}
	
	
	@AfterClass
	public void closeBrowser()
	{
		driver.quit();
		Reporter.log("Browser Closed",true);
	}
	
}
