package com.blazeDemo.testScripts;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.blazeDemo.baseClass.Base;
import com.blazeDemo.dataProvider.DataProviders;
import com.blazeDemo.pageObjects.ConfirmationPage;
import com.blazeDemo.pageObjects.DetailsPage;
import com.blazeDemo.pageObjects.IndexPage;
import com.blazeDemo.pageObjects.ReservePage;
import com.blazeDemo.utility.Log;

public class EndToEndTest extends Base {

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

	@Test(groups = "Regression")
	public void endToEndTest() {
		Log.startTestCase("endToEndTest");
		Log.info("User is on the Home/Landing Page");
		Log.info(" ");
		Log.info("User is clicking on Find Flight Button");
		rp = ip.selectFlight();
		Log.info("User is on the Reserve Page ...");
		dp = rp.clickonChooseBtn();
		Log.info("User is on the Details Page ...");
		Log.info("User is going to enter his Details ....");
		cp = dp.enterTravellerDetails();

		Log.info("User is on The Final Confirmation Page ..");
		String finalText = cp.getHeading();

		Assert.assertEquals(finalText, "Thank you for your purchase today!");
		Log.endTestCase("endToEndTest");

	}

	@Test(dataProvider = "detailsPage" , dataProviderClass = DataProviders.class , enabled = false)
	public void endToEndTest2(HashMap<String , String> hashMap) {
		Log.startTestCase("endToEndTest2");
		Log.info("User is on the Home/Landing Page");
		Log.info(" ");
		Log.info("User is clicking on Find Flight Button");
		rp = ip.selectFlight();
		Log.info("User is on the Reserve Page ...");
		dp = rp.clickonChooseBtn();
		Log.info("User is on the Details Page ...");
		Log.info("User is going to enter his Details ....");
		cp  = dp.enterTravellerDetails(
				hashMap.get("Name"),
				hashMap.get("Address"),
				hashMap.get("City"),
				hashMap.get("State"),
				hashMap.get("ZipCode"),
				hashMap.get("CardType"),
				hashMap.get("CreditCard"),
				hashMap.get("Month"),
				hashMap.get("Year"),
				hashMap.get("NameOnCard"));
		
		Log.info("User is on The Final Confirmation Page ..");
		String finalText = cp.getHeading();

		Assert.assertEquals(finalText, "Thank you for your purchase today!");
		Log.endTestCase("endToEndTest");
		
	}

}
