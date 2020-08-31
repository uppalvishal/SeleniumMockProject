package com.projectname.pages;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

public class ElectronicsPage {
	
	private WebDriver driver;
	private ExtentTest testLog;

	public ElectronicsPage(WebDriver driver, ExtentTest testLog) {
		this.driver = driver;
		this.testLog = testLog;
	}

}
