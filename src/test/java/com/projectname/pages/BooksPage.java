package com.projectname.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BooksPage {
	
	//locates the 'add to cart' button under the 'Computing and internet' item. Does not 
	//@FindBy(xpath = "//div[@class='product-grid']/div[1]/div/div[2]/div[3]/div[2]") WebElement itemLink;
	@FindBy(xpath = "//div[@class='product-grid']/div[1]/div[1]/div[1]") WebElement itemLink;
		
	private WebDriver driver;
	private ExtentTest testLog;
	
	public BooksPage(WebDriver driver, ExtentTest testLog) {
		this.driver = driver;
		this.testLog = testLog;
	}
	
	public ProductPage clickOnSelectedProduct() {
		itemLink.click();
		ProductPage product = new ProductPage(driver, testLog);
		PageFactory.initElements(driver, product);
		return product;
	}
}
