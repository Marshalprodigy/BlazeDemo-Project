package com.blazeDemo.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.blazeDemo.actionDriver.Action;
import com.blazeDemo.baseClass.Base;

public class IndexPage extends Base {

	Action action = new Action();

	// Page Objects

	@FindBy(xpath = "//h1")
	WebElement welcomeGreet;

	By vacation = By.partialLinkText("destination");
	By from = By.name("fromPort");
	By to = By.name("toPort");
	By clickBtn = By.xpath("//*[@type='submit']");

	// Constructor
	public IndexPage(WebDriver driver) {
		Base.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Methods

	public VacationPage goToVacationPage() {
		driver.findElement(vacation).click();

		return new VacationPage();

	}

	public void selectFrom() {
		Select s = new Select(driver.findElement(from));
		s.selectByVisibleText(prop.getProperty("from"));

	}

	public void selectTo() {
		Select s = new Select(driver.findElement(to));
		s.selectByVisibleText(prop.getProperty("to"));

	}

	public ReservePage selectFlight() {
		selectFrom();
		selectTo();
		driver.findElement(clickBtn).click();

		return new ReservePage();
	}

	// Method Overloading

	// Data Driven Testing using Data Provider Annotation
	public ReservePage selectFlight(String src, String dest) {
		Select s = new Select(driver.findElement(from));
		s.selectByVisibleText(src);
		Select s1 = new Select(driver.findElement(to));
		s1.selectByVisibleText(dest);
		driver.findElement(clickBtn).click();

		return new ReservePage();
	}

	// TestCase1
	public boolean welcomeGreet() {
		String txt = welcomeGreet.getText();

		return txt.contains("Welcome to the Simple Travel Agency!");

	}

	// TestCase2
	public String getCurrentUrl() {
		String url = action.getCurrentURL(driver);
		return url;
	}

	// TestCase3
	public String getPageTitle() {
		String title = action.getTitle(driver);
		return title;
	}

}
