package com.projectname.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

public class OrderVerificationPage {

	@FindBy(xpath = "//a[@class='ico-logout']") WebElement logOutLink;
	
	private WebDriver driver;
	private ExtentTest testLog;
	private WebDriverWait wait;
	
	public OrderVerificationPage(WebDriver driver, ExtentTest testLog) {
		this.driver = driver;
		this.testLog = testLog;
	}
	
	public void clickLogOutLick() {
		logOutLink.click();
	}
}
