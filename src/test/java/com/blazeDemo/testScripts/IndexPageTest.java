package com.blazeDemo.testScripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.blazeDemo.baseClass.Base;
import com.blazeDemo.pageObjects.IndexPage;
import com.blazeDemo.utility.Log;

public class IndexPageTest extends Base {

	IndexPage ip;
	
	@BeforeMethod(groups = { "Smoke", "Sanity", "Regression" })
	public void setup() {
		launchApp();
	}

	@AfterMethod(groups = { "Smoke", "Sanity", "Regression" })
	public void tearDown() {
		driver.close();
		driver.quit();

	}

	@Test(groups = "Smoke")
	public void verifyHomePage() {
		Log.startTestCase("verifyHomePage");
		ip = new IndexPage(driver);
		boolean res = ip.welcomeGreet();
		Log.info("User is on the Home/Landing Page");

		Assert.assertTrue(res);
		Log.endTestCase("verifyHomePage");
	}

	@Test(groups = "Smoke")
	public void verifyUrl() {
		Log.startTestCase("verifyUrl");
		ip = new IndexPage(driver);
		String actualUrl = ip.getCurrentUrl();

		Assert.assertEquals(actualUrl, prop.getProperty("url"));
		Log.endTestCase("verifyUrl");
	}

	@Test(groups = "Smoke")
	public void verifyTitleOfPage() {
		Log.startTestCase("verifyTitleHomePage");
		ip = new IndexPage(driver);
		String actualTitle = ip.getPageTitle();

		Assert.assertEquals(actualTitle, prop.getProperty("title"));
	}
	
	

}
