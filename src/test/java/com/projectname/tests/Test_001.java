package com.projectname.tests;
import static org.testng.Assert.assertEquals;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.projectname.pages.LoginPage;
import com.projectname.pages.OrderInformationPage;
import com.projectname.pages.OrderVerificationPage;
import com.projectname.baseclass.BaseTestSuite;
import com.projectname.pages.ApparelAndShoesPage;
import com.projectname.pages.BooksPage;
import com.projectname.pages.CheckoutPage;
import com.projectname.pages.HomePage;
import com.projectname.pages.PageName;
import com.projectname.pages.ProductPage;
import com.projectname.pages.RegistrationPage;
import com.projectname.pages.SecondPageName;
import com.projectname.pages.ShoppingCartPage;
import com.relevantcodes.extentreports.LogStatus;

public class Test_001 extends BaseTestSuite {

	@Test
	public void tcase1() throws InterruptedException {
		testLog = extent.startTest(this.getClass().getSimpleName());
		String[][] logindata = excelData.readData("LoginPage");
		LoginPage login = new LoginPage(driver, testLog);
		PageFactory.initElements(driver, login);
		login.clickLoginLink();
		testLog.log(LogStatus.INFO, testLog.addScreenCapture(createScreenshot()));
		login.enterEmail(logindata[0][0]);
		testLog.log(LogStatus.INFO, testLog.addScreenCapture(createScreenshot()));
		login.enterPassword(logindata[0][1]);
		testLog.log(LogStatus.INFO, testLog.addScreenCapture(createScreenshot()));
		HomePage home=login.clickOnLoginButton();
		testLog.log(LogStatus.INFO, testLog.addScreenCapture(createScreenshot()));
		
		//Reset cart to 0 item count
		ShoppingCartPage shoppingcart = home.clickGoToCart();
		shoppingcart.resetShoppingCart();
		
		//Assertion #1
		Assert.assertEquals(home.shoppingCartQuantity(), "0", "Shopping cart before adding product is not empty!");
		
		BooksPage bookspage = home.clickBooksLinkUnderCategories();
		ProductPage product = bookspage.clickOnSelectedProduct();
		product.clickAddToCartButton();
		Thread.sleep(3500);//wait for cart to update before next step
		
		//Assertion #2
		Assert.assertEquals(home.shoppingCartQuantity(), "1", "Cart product count is incorrect");
		
		product.hoverShoppingCart();
		shoppingcart = product.clickGoToCart();
		
		//Assertion #3
		Assert.assertEquals(shoppingcart.verifyShoppingCartSubTotal(), true, "Sub totals of products do not match");
		
		//Assertion #4
		Assert.assertEquals(shoppingcart.verifyShoppingCartPageTotals(), true, "Sub total does not match total");
		
		
		shoppingcart.clickTermsOfServiceCheckbox();
		CheckoutPage checkout = shoppingcart.clickCheckoutButton();
		checkout.clickbillingaddresscontinuebutton();
		checkout.clickshippingaddresscontinuebutton();
		checkout.clickshippingmethodcontinuebutton();
		checkout.clickpaymentmethodscontinuebutton();
		checkout.clickpaymentinformationcontinuebutton();
		OrderVerificationPage orderverify = checkout.clickconfirmordercontinuebutton();
		String verificationPageOrderNumber = orderverify.getVerificationPageOrderNumber();
		OrderInformationPage orderInfoPage = orderverify.clickOrderDetailsLink();
		
		//Assertion #5
		Assert.assertEquals(orderInfoPage.getOrderNumber(), verificationPageOrderNumber, "Order numbers do not match");
		
		Thread.sleep(3500);
		orderverify.clickLogOutLink();

		//End of TC_001
		}
	
//	public void resetShoppingCart(HomePage home) {
//		ShoppingCartPage shoppingcartpage = home.clickShoppingCartLink();
//		WebElement table = shoppingcartpage.getProductsTbl();
//
//		// get all rows
//		List < WebElement > rows_table = table.findElements(By.tagName("tr"));
//		int rows_count = rows_table.size();
//		//Loop will execute till the last row of table.
//		for (int row = 0; row < rows_count; row++) { 
//			// iterate through the rows
//			// get the rowCells in each row
//			driver.findElement(By.xpath("(//*[@class='remove-from-cart'])["+(row+1)+"]/span/following-sibling::input")).click();
//		}
//	
//	
//}
}
