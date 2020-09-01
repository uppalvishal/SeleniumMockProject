package com.projectname.pages;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

public class OrderVerificationPage {

	@FindBy(xpath = "//a[@class='ico-logout']") WebElement logOutLink;
	@FindBy(xpath = "//ul[@class='details']/li[2]/a") WebElement orderDetailsLink;
	@FindBy(xpath = "//ul[@class='details']/li[1]") WebElement orderNumber;
	
	
	private WebDriver driver;
	private ExtentTest testLog;
	private WebDriverWait wait;
	
	public OrderVerificationPage(WebDriver driver, ExtentTest testLog) {
		this.driver = driver;
		this.testLog = testLog;
	}
	
	public String getVerificationPageOrderNumber() {
		return StringUtils.removeStart(orderNumber.getText(), "Order number: ");
	}
	
	public OrderInformationPage clickOrderDetailsLink() {
		orderDetailsLink.click();
		
		OrderInformationPage orderInfoPage = new OrderInformationPage(driver, testLog);
		PageFactory.initElements(driver, orderInfoPage);
		return orderInfoPage;
	}
	
	public void clickLogOutLink() {
		logOutLink.click();
	}
}
