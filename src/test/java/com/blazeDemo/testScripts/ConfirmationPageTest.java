package com.blazeDemo.testScripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.blazeDemo.baseClass.Base;
import com.blazeDemo.pageObjects.ConfirmationPage;
import com.blazeDemo.pageObjects.DetailsPage;
import com.blazeDemo.pageObjects.IndexPage;
import com.blazeDemo.pageObjects.ReservePage;

public class ConfirmationPageTest extends Base {

	IndexPage ip = new IndexPage(driver);
	ReservePage rp;
	DetailsPage dp;
	ConfirmationPage cp;

	@BeforeMethod
	public void setup() {
		launchApp();
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
		driver.quit();

	}

	@Test(groups= {"Sanity" , "Smoke"})
	public void verifyTitle() {
		rp = ip.selectFlight();
		dp = rp.clickonChooseBtn();
		cp = dp.enterTravellerDetails();
		String actualtitle = cp.pageTitle();

		Assert.assertEquals(actualtitle, prop.getProperty("titleConfirmation"));
	}

	@Test(groups= {"Sanity","Regression"})
	public void verifyUrl() {
		rp = ip.selectFlight();
		dp = rp.clickonChooseBtn();
		cp = dp.enterTravellerDetails();
		String actualUrl = cp.getCurrentUrl();

		Assert.assertEquals(actualUrl, "https://blazedemo.com/confirmation.php");
	}

	@Test(groups= {"Sanity" , "Smoke"})
	public void getInfoDetails() {
		rp = ip.selectFlight();
		dp = rp.clickonChooseBtn();
		cp = dp.enterTravellerDetails();

		cp.getInfoOfTicket();
	}

}
