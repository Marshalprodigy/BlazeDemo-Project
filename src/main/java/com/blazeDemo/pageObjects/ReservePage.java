package com.blazeDemo.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.blazeDemo.actionDriver.Action;
import com.blazeDemo.baseClass.Base;

public class ReservePage extends Base {

	Action action = new Action();

	@FindBy(xpath = "//h3")
	WebElement srcDestDetail;

	@FindBy(xpath = "//tr[3]/td[1]/input")
	WebElement chooseBtn;

	public ReservePage() {
		PageFactory.initElements(driver, this);
	}

	// TestCase1
	public String pageTitle() {
		String title = action.getTitle(driver);

		return title;
	}

	// TestCase2
	public String srcDest() {
		String text = srcDestDetail.getText();
		String array[] = text.split(" ");

		String src = "";
		if (text.contains("New") || text.contains("Buenos")) {
			src = array[2] + " " + array[3];
		} else {
			src = array[2];
		}
		String dest = "";
		if (text.contains("New") || text.contains("Buenos")) {
			dest = array[4] + " " + array[5];
			dest = array[4] + " " +dest.substring(0, dest.length() - 1);
		} else {
			dest = array[4];
			dest = dest.substring(0,dest.length()-1);

		}

		return src + " " + dest;
	}

	public DetailsPage clickonChooseBtn() {
		action.click(driver, chooseBtn);

		return new DetailsPage(driver);
	}

}
