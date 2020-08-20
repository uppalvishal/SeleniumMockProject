package com.projectname.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentTest;

public class SecondPageName {

	@FindBy(xpath="//div[@id='login_link']//a") WebElement forgotpwdLink;
	//private String forgottenPassword = "//div[@id='login_link']//a";
	private WebDriver driver;
	private ExtentTest testLog;

	public SecondPageName(WebDriver driver, ExtentTest testLog) {
		this.driver = driver;
		this.testLog = testLog;
	}

	public String verifyForgottenPassword() {
		return forgotpwdLink.getText();
	}

}
