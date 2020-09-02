package com.projectname.pages;

import java.util.List;
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
	@FindBy(xpath="//table[@class='cart']/tbody") WebElement productsTable;
	@FindBy(xpath ="//input[@name='updatecart']")WebElement updateShoppingCartButton;
	@FindBy(xpath = "//div[@class='header-logo']") WebElement homeLogoLink;
	@FindBy(xpath="//span[@class='cart-qty']") WebElement shoppingCartQuantity;
	@FindBy(xpath ="//span[@class='product-unit-price']") WebElement productUnitPrice;
	@FindBy(xpath ="//td[@class='qty nobr']/input") WebElement productQuantity;
	@FindBy(xpath = "//span[@class='product-subtotal']") WebElement productSubTotalPrice;
	@FindBy(xpath = "//table[@class='cart-total']/tbody[1]/tr[1]/td[2]/span[1]/span[1]") WebElement shoppingCartTotalPrice;
	
	
	private WebDriver driver;
	private ExtentTest testLog;

	public ShoppingCartPage(WebDriver driver, ExtentTest testLog) {
		this.driver = driver;
		this.testLog = testLog;
	}
	
	public boolean verifyShoppingCartSubTotal() {
		float i = Float.parseFloat(productUnitPrice.getText());
		int j = Integer.parseInt(productQuantity.getAttribute("value"));
		float k = Float.parseFloat(productSubTotalPrice.getText());

		if(i*j==k) {
			return true;
		}
		return false;	
	}
	
	public boolean verifyShoppingCartPageTotals() {
		float i = Float.parseFloat(productSubTotalPrice.getText());
		float j = Float.parseFloat(shoppingCartTotalPrice.getText());
		
		if(i==j) {
			return true;
		}
		return false;
	}
	
	public void resetShoppingCart(){
		if(!(StringUtils.substringBetween(shoppingCartQuantity.getText(), "(", ")").equalsIgnoreCase("0"))) {
			// get all rows
			List <WebElement> rows_table = productsTable.findElements(By.tagName("tr"));
			//List < WebElement > rows_table = productsTable.findElements(By.tagName("tr"));
			int rows_count = rows_table.size();
			//Loop will execute till the last row of table.
			for (int row = 0; row < rows_count; row++) { 
				// iterate through the rows
				// get the rowCells in each row
				driver.findElement(By.xpath("(//*[@class='remove-from-cart'])["+(row+1)+"]/span/following-sibling::input")).click();
			}
			updateShoppingCartButton.click();
		}
		homeLogoLink.click();
	}
	
	public String shoppingCartQuantity() {
		return StringUtils.substringBetween(shoppingCartQuantity.getText(), "(", ")");
	}
	
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