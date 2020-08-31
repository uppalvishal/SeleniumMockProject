package com.projectname.pages;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ShoppingCartPage {
		
	@FindBy(xpath = "//span[@class='product-price order-total']") WebElement totalPrice;
	@FindBy(id = "termsofservice") WebElement termsOfSerivceCheckbox;
	@FindBy(xpath = "//button[@id='checkout']") WebElement checkoutButton;
	
	private WebDriver driver;
	private ExtentTest testLog;

	public ShoppingCartPage(WebDriver driver, ExtentTest testLog) {
		this.driver = driver;
		this.testLog = testLog;
	}
	
	/*
	 * #### Add method that verifies total values
	 */
	public void clickTermsOfServiceCheckbox() {
		termsOfSerivceCheckbox.click();
	}
	
	public CheckoutPage clickCheckoutButton() {
		checkoutButton.click();
		CheckoutPage checkout = new CheckoutPage(driver, testLog);
		PageFactory.initElements(driver, checkout);
		return checkout;
	}
	
}