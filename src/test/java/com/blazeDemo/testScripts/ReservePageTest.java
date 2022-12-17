package com.blazeDemo.testScripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.blazeDemo.baseClass.Base;
import com.blazeDemo.dataProvider.DataProviders;
import com.blazeDemo.pageObjects.IndexPage;
import com.blazeDemo.pageObjects.ReservePage;
import com.blazeDemo.utility.Log;

public class ReservePageTest extends Base {

	IndexPage ip = new IndexPage(driver);
	ReservePage rp;

	@BeforeMethod(groups = { "Smoke", "Sanity", "Regression" })
	public void setup() {
		launchApp();
	}

	@AfterMethod(groups = { "Smoke", "Sanity", "Regression" })
	public void tearDown() {
		driver.close();
		driver.quit();

	}

	@Test(groups = { "Sanity", "Smoke" })
	public void verifyTitle() {
		Log.startTestCase("verifyTitle");
		rp = ip.selectFlight();
		Log.info("User is selecting from and to options and clicking on Find Flights button");
		String title = rp.pageTitle();
		Assert.assertEquals(title, prop.getProperty("titleReserve"));
		Log.endTestCase("verifyTitle");
	}

	@Test(groups = "Sanity")
	public void verifySrcDest() {
		Log.startTestCase("verifySrcDest");
		rp = ip.selectFlight();
		Log.info("User is selecting from and to options and clicking on Find Flights button");
		String text = rp.srcDest();
		String array[] = text.split(" ");

		Assert.assertEquals(array[0], prop.getProperty("from"));
		Assert.assertEquals(array[1], prop.getProperty("to"));

		Log.endTestCase("verifySrcDest");

	}

	@Test(dataProvider = "fromToFlight", dataProviderClass = DataProviders.class, groups = "Smoke")
	public void getSrcDestFromExcel(String src, String dest) {
		Log.startTestCase("verifySrcDest");
		rp = ip.selectFlight(src, dest);
		Log.info("User is selecting from and to options and clicking on Find Flights button");
		String text = rp.srcDest();
		String array[] = text.split(" ");

		Assert.assertEquals(array[0], src);
		Assert.assertEquals(array[1], dest);

		Log.endTestCase("verifySrcDest");

	}
}
