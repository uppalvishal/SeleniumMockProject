package com.projectname.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

public class CheckoutPage {
	
	@FindBy(xpath = "//li[@id='opc-billing']/div[2]/div[1]/input[1]") WebElement billingAddressContinueButton;
	@FindBy(xpath = "//li[@id='opc-shipping']/div[2]/div[1]/input[1]") WebElement shippingAddressContinueButton;
	@FindBy(xpath = "//input[@class='button-1 shipping-method-next-step-button']") WebElement shippingMethodContinueButton;
	@FindBy(xpath = "//input[@class='button-1 payment-method-next-step-button']") WebElement paymentMethodContinueButton;
	@FindBy(xpath = "//input[@class='button-1 payment-info-next-step-button']") WebElement paymentInformationContinueButton;
	@FindBy(xpath ="//input[@class='button-1 confirm-order-next-step-button']") WebElement confirmOrderContinueButton;
	
	
	private WebDriver driver;
	private ExtentTest testLog;

	public CheckoutPage(WebDriver driver, ExtentTest testLog) {
		this.driver = driver;
		this.testLog = testLog;
	}
	
	public void clickbillingaddresscontinuebutton() {
		billingAddressContinueButton.click();
	}
	
	public void clickshippingaddresscontinuebutton() {
		shippingAddressContinueButton.click();
	}
	
	public void clickshippingmethodcontinuebutton() {
		shippingMethodContinueButton.click();
	}
	
	public void clickpaymentmethodscontinuebutton() {
		paymentMethodContinueButton.click();
	}
	
	public void clickpaymentinformationcontinuebutton() {
		paymentInformationContinueButton.click();
	}
	
	public OrderVerificationPage clickconfirmordercontinuebutton() {
		confirmOrderContinueButton.click();
		OrderVerificationPage orderVerify= new OrderVerificationPage(driver, testLog);
		PageFactory.initElements(driver, orderVerify);
		return orderVerify;
	}

}
