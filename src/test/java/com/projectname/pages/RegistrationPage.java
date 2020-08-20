package com.projectname.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {

	@FindBy(name="fld_username") WebElement usernameTextBox;
	@FindBy(name="fld_email") WebElement emailTextBox;
	@FindBy(xpath="//input[@type='password']") WebElement passwordTextBox;
	WebDriverWait wait;
	WebDriver driver;

	public RegistrationPage(WebDriver driver) {
		this.driver= driver;
		this.wait=new WebDriverWait(driver,20);
	}

	public void enterUsername() {
		wait.until(ExpectedConditions.visibilityOf(usernameTextBox));
		usernameTextBox.sendKeys("Testing");
	}

	public void enterEmail() {
		emailTextBox.sendKeys("Testing");
	}

	public void enterPassword() {
		passwordTextBox.sendKeys("abcd123");
	}

}
