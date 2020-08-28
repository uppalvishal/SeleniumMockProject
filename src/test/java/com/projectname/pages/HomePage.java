package com.projectname.pages;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class HomePage {
	@FindBy(xpath="//div[@class='block block-category-navigation']/div[2]/ul/li[1]/a") WebElement booksLink;
	@FindBy(xpath="//div[@class='block block-category-navigation']/div[2]/ul/li[3]/a") WebElement electronicsLink;
	@FindBy(xpath="//div[@class='block block-category-navigation']/div[2]/ul/li[4]/a") WebElement apparelandshoesLink;
	@FindBy(xpath="//div[@class='header-links']/ul/li[3]/a") WebElement shoppingCartLink;

	private WebDriver driver;
	private ExtentTest testLog;

	public HomePage(WebDriver driver, ExtentTest testLog) {
		this.driver = driver;
		this.testLog = testLog;
	}

	public String verifyShoppingcartCountBeforeAddingProduct(){
		return StringUtils.substringBetween(shoppingCartLink.getText(), "(", ")");
	}
	
	
	public BooksPage clickBooksLinkUnderCategories() {
		try {
			//Thread.sleep(2000);
			booksLink.click();
			testLog.log(LogStatus.INFO, "Clicked Books linkk inn categories");
		} catch (Exception e) {
			Assert.fail("Unable to click Books link under categories");
		}
		BooksPage bookspage= new BooksPage(driver, testLog);
		PageFactory.initElements(driver, bookspage);
		return bookspage;
	}

	
}
