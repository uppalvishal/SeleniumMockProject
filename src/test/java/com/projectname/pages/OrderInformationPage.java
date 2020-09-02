package com.projectname.pages;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

public class OrderInformationPage {

	@FindBy(xpath = "//div[@class='order-number']") WebElement orderNumber;
	
	private WebDriver driver;
	private ExtentTest testLog;
	private WebDriverWait wait;
	
	public OrderInformationPage(WebDriver driver, ExtentTest testLog) {
		this.driver = driver;
		this.testLog = testLog;
	}
	
	public String getOrderNumber() {
		return StringUtils.removeStart(orderNumber.getText(), "Order #");
	}
	
	
}
