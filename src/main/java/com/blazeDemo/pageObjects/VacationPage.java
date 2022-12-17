package com.blazeDemo.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.blazeDemo.actionDriver.Action;
import com.blazeDemo.baseClass.Base;

public class VacationPage extends Base {

	Action action = new Action();

	@FindBy(xpath = "//*[contains(text(),'Destination')]")
	WebElement destination;
	
	@FindBy(xpath="//img")
	WebElement image;

	public VacationPage() {
		PageFactory.initElements(driver, this);
	}

	// TestCase1

	public String pageTitle() {
		String title = action.getTitle(driver);

		return title;
	}

	// TestCase2
	public String text() {
		String text = destination.getText();

		return text;
	}
	
	//TestCase3
	
	public boolean imageOnPage() {
		return action.isDisplayed(driver, image);
		
		
	}

}
