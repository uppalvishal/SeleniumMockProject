package com.projectname.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

public class ProductPage {
	
	@FindBy(xpath = "//input[@id='add-to-cart-button-13']") WebElement addToCartButton;
	@FindBy(xpath = "//span[text()='Shopping cart']") WebElement shoppingCartLink;
	@FindBy(xpath = "//div[@class='mini-shopping-cart']/div[4]/input[1]") WebElement goToCartLink;
	
	private WebDriver driver;
	private ExtentTest testLog;

	public ProductPage(WebDriver driver, ExtentTest testLog) {
		this.driver = driver;
		this.testLog = testLog;
	}
	
	public void clickAddToCartButton() {
		addToCartButton.click();
	}
	
	public void hoverShoppingCart() {
		Actions act = new Actions(driver);
		act.moveToElement(shoppingCartLink).perform();
	}
	
	public ShoppingCartPage clickGoToCart() {
		goToCartLink.click();
		ShoppingCartPage shoppingcart = new ShoppingCartPage(driver, testLog);
		PageFactory.initElements(driver, shoppingcart);
		return shoppingcart;
	}
}
