package com.projectname.pages;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

public class ApparelAndShoesPage {

	private WebDriver driver;
	private ExtentTest testLog;

	public ApparelAndShoesPage(WebDriver driver, ExtentTest testLog) {
		this.driver = driver;
		this.testLog = testLog;
	}
}
