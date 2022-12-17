package com.blazeDemo.pageObjects;

import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.blazeDemo.actionDriver.Action;
import com.blazeDemo.baseClass.Base;

public class ConfirmationPage extends Base {

	Action action = new Action();

	@FindBy(xpath = "//h1")
	WebElement heading;

	@FindBy(xpath = "//a[contains(text(),'Travel')]")
	WebElement index;

	By info = By.xpath("//tbody//tr");

	public ConfirmationPage(WebDriver driver) {
		Base.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// TestCase1

	public String pageTitle() {
		String title = action.getTitle(driver);
		return title;
	}

	// TestCase2

	public String getCurrentUrl() {
		String url = action.getCurrentURL(driver);
		return url;
	}

	// TestCase3
	public void getInfoOfTicket() {
		List<WebElement> list = driver.findElements(info);
		String id = list.get(0).getText();
		String amount = list.get(2).getText();
		String date = list.get(6).getText();

		System.out.println(id);
		System.out.println(amount);
		System.out.println(date);
	}

	public IndexPage goToHomePage() {
		action.click(driver, index);
		return new IndexPage(driver);
	}
	
	public String getHeading() {
		String text = heading.getText();
		
		return text;
	}

}
