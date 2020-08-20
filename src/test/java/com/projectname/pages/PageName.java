package com.projectname.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class PageName {
	
	@FindBy(xpath="//button[@type='submit']") WebElement loginButton;
	@FindBy(id="email") WebElement usernameTextBox;
	//private String loginBtn = "//button[@type='submit']";
	//private String userName = "email";
	private WebDriver driver;
	private ExtentTest testLog;

	public PageName(WebDriver driver, ExtentTest testLog) {
		this.driver = driver;
		this.testLog = testLog;
	}

	public void enterUserName(String userName) {
		try {
			//driver.findElement(By.id(this.userName)).sendKeys(userName);
			usernameTextBox.sendKeys(userName);
			testLog.log(LogStatus.INFO, "Entered username as " + userName);
		} catch (Exception e) {
			Assert.fail("Unable to enter username as " + userName);
		}
	}

	public SecondPageName clickOnLoginButton() {
		try {
			//driver.findElement(By.xpath(loginBtn)).click();
			loginButton.click();
			testLog.log(LogStatus.INFO, "Clicked on login button");

		} catch (Exception e) {
			Assert.fail("Unable to click on login button");
		}
		SecondPageName second= new SecondPageName(driver, testLog);
		PageFactory.initElements(driver, second);
		return second;
	}

}
