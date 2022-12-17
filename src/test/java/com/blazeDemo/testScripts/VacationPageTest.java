package com.blazeDemo.testScripts;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.blazeDemo.baseClass.Base;
import com.blazeDemo.pageObjects.IndexPage;
import com.blazeDemo.pageObjects.VacationPage;
import com.blazeDemo.utility.Log;

public class VacationPageTest extends Base {

	IndexPage ip = new IndexPage(driver);
	VacationPage vp;

	@BeforeMethod
	public void setup() {
		launchApp();
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
		driver.quit();

	}

	@Test(groups="Smoke")
	public void verifyTitle() {
		Log.startTestCase("verifyTitle");
		vp = ip.goToVacationPage();
		Log.info("User is on the Vacation Page ...");
		String title = vp.pageTitle();

		Assert.assertTrue(title.equalsIgnoreCase(prop.getProperty("titleVacation")));
	}

	@Test(groups="Smoke")
	public void verifyText() {
		vp = ip.goToVacationPage();
		Log.startTestCase("verifyText");
		String text = vp.text();
		Log.info("User is on the Vacation Page ...");
		Assert.assertEquals(text, "Destination of the week: Hawaii !");
		Log.endTestCase("verifyText");
	}

	@Test(groups="Smoke")
	public void verifyImageonPage() {
		Log.startTestCase("verifyImageOnpage");
		vp = ip.goToVacationPage();
		boolean res = vp.imageOnPage();
		Log.info("User is able to see an image on the Page");
		assertTrue(res);
		Log.endTestCase("verifyImageOnPage");
	}

}
