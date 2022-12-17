package com.blazeDemo.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.blazeDemo.actionDriver.Action;
import com.blazeDemo.baseClass.Base;

public class DetailsPage extends Base {

	Action action = new Action();

	@FindBy(xpath = "//h2")
	WebElement heading;

	By name = By.id("inputName");
	By address = By.name("address");
	By city = By.xpath("//*[@placeholder='Anytown']");
	By state = By.xpath("//input[@name='state']");
	By zipCode = By.cssSelector("#zipCode");
	By cardType = By.tagName("select");
	By creditCard = By.xpath("//div//label[contains(text(),'Credit')]//following-sibling::div//input");
	By month = By.name("creditCardMonth");
	By year = By.id("creditCardYear");
	By nameOnCard = By.xpath("//input[@type='text' and @name='nameOnCard']");
	By checkBox = By.xpath("//*[@type='checkbox']");
	By submit = By.xpath("//input[@type='submit']");

	public DetailsPage(WebDriver driver) {
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

	public String text() {
		String text = heading.getText();

		return text;
	}

	// Method
	public ConfirmationPage enterTravellerDetails() {
		driver.findElement(name).sendKeys("Marshal Mathers");
		driver.findElement(address).sendKeys("Vaima Heritage 7 Hills");
		driver.findElement(city).sendKeys("Pune");
		driver.findElement(state).sendKeys("Maharashtra");
		driver.findElement(zipCode).sendKeys("802101");

		WebElement drop = driver.findElement(cardType);
		Select sel = new Select(drop);
		sel.selectByVisibleText("American Express");

		driver.findElement(creditCard).sendKeys("123456789");
		WebElement months = driver.findElement(month);
		months.clear();
		months.sendKeys("12");

		WebElement yrs = driver.findElement(year);
		yrs.clear();
		yrs.sendKeys("2025");

		driver.findElement(nameOnCard).sendKeys("MARSHAL MATHERS");
		driver.findElement(checkBox).click();
		driver.findElement(submit).click();

		return new ConfirmationPage(driver);
	}

	// Method Overloading
	
	public ConfirmationPage enterTravellerDetails(String names, String addresss, String citys, String states,
			String zipCodes, String cardTypes, String creditCards, String mont, String years, String nameOnCards) {
		driver.findElement(name).sendKeys(names);
		driver.findElement(address).sendKeys(addresss);
		driver.findElement(city).sendKeys("Pune");
		driver.findElement(state).sendKeys(citys);
		driver.findElement(zipCode).sendKeys(zipCodes);

		WebElement drop = driver.findElement(cardType);
		Select sel = new Select(drop);
		sel.selectByVisibleText(cardTypes);

		driver.findElement(creditCard).sendKeys(creditCards);
		WebElement months = driver.findElement(month);
		months.clear();
		months.sendKeys(mont);

		WebElement yrs = driver.findElement(year);
		yrs.clear();
		yrs.sendKeys(years);

		driver.findElement(nameOnCard).sendKeys(nameOnCards);
		driver.findElement(checkBox).click();
		driver.findElement(submit).click();

		return new ConfirmationPage(driver);
	}

}
