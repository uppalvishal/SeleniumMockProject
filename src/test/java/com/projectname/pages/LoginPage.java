package com.projectname.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LoginPage {
	@FindBy(xpath="//*[@class='ico-login']") WebElement loginLink;
	@FindBy(xpath="//*[@id='Email']") WebElement emailTextBox;
	@FindBy(xpath="//input[@id='Password']") WebElement passwordTextBox;
	@FindBy(xpath="//input[@value='Log in' and @type='submit']") WebElement loginButton;
	@FindBy(xpath="//div[@class='header-links']/ul/li[3]/a") WebElement shoppingCartLink;
	
	private WebDriver driver;
	private ExtentTest testLog;
	private WebDriverWait wait;
	
	public LoginPage(WebDriver driver, ExtentTest testLog) {
		this.driver = driver;
		this.testLog = testLog;
	}
	
	public void clickLoginLink() {
		try {
			Thread.sleep(2000);
			loginLink.click();
			testLog.log(LogStatus.INFO, "Clicked log in link");
		
		} catch (Exception e) {
			Assert.fail("Unable to click login link");
		}
	}
	
	public void enterEmail(String email) {
		try {
			//Thread.sleep(2000);
			emailTextBox.sendKeys(email);
			testLog.log(LogStatus.INFO, "Entered Email as " + email);
		} catch (Exception e) {
			Assert.fail("Unable to enter Email as " + email);
		}
	}
	
	public void enterPassword(String password) {
		try {
			//Thread.sleep(2000);
			passwordTextBox.sendKeys(password);
			testLog.log(LogStatus.INFO, "Entered password as " + password);
		} catch (Exception e) {
			Assert.fail("Unable to enter password as " + password);
		}
	}
	

	public HomePage clickOnLoginButton() {
		try {
			Thread.sleep(2000);
			loginButton.click();
			testLog.log(LogStatus.INFO, "Clicked on login button");

		} catch (Exception e) {
			Assert.fail("Unable to click on login button");
		}
		HomePage home= new HomePage(driver, testLog);
		PageFactory.initElements(driver, home);
		return home;
	}
	
	

}
