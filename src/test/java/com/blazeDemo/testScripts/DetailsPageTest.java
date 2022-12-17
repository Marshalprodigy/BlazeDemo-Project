package com.blazeDemo.testScripts;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.blazeDemo.baseClass.Base;
import com.blazeDemo.pageObjects.DetailsPage;
import com.blazeDemo.pageObjects.IndexPage;
import com.blazeDemo.pageObjects.ReservePage;

public class DetailsPageTest extends Base {

	IndexPage ip = new IndexPage(driver);
	ReservePage rp;
	DetailsPage dp;

	@BeforeMethod
	public void setup() {
		launchApp();
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
		driver.quit();

	}

	@Test(priority =1 , groups="Smoke")
	public void verifyTitle() {
		rp = ip.selectFlight();
		dp = rp.clickonChooseBtn();
		String actualTitle = dp.pageTitle();

		Assert.assertEquals(actualTitle, prop.getProperty("titleDetails"));
	}

	@Test(priority =2 , groups="Smoke")
	public void verifyText() {
		rp = ip.selectFlight();
		dp = rp.clickonChooseBtn();
		String actualtext = dp.text();

		assertTrue(actualtext.contains("Your flight"));
	}

	@Test(priority =3 , groups="Smoke")
	public void verifyUrl() {
		rp = ip.selectFlight();
		dp = rp.clickonChooseBtn();
		String url = dp.getCurrentUrl();
		Assert.assertEquals(url, "https://blazedemo.com/purchase.php");
	}
	
	@Test(priority =4 , groups="Smoke")
	public void enterDetails() {
		rp = ip.selectFlight();
		dp = rp.clickonChooseBtn();
		dp.enterTravellerDetails();
		
	}

}
