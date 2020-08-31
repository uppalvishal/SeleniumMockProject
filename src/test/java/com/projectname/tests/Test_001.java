package com.projectname.tests;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.projectname.pages.LoginPage;
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
	public void tcase1() {
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
        System.out.println("reached here");
		BooksPage bookspage = home.clickBooksLinkUnderCategories();
		ProductPage product = bookspage.clickOnSelectedProduct();
		product.clickAddToCartButton();
		product.hoverShoppingCart();
		ShoppingCartPage shoppingcart = product.clickGoToCart();
		shoppingcart.clickTermsOfServiceCheckbox();
		CheckoutPage checkout = shoppingcart.clickCheckoutButton();
		checkout.clickbillingaddresscontinuebutton();
		checkout.clickshippingaddresscontinuebutton();
		checkout.clickshippingmethodcontinuebutton();
		checkout.clickpaymentmethodscontinuebutton();
		checkout.clickpaymentinformationcontinuebutton();
		OrderVerificationPage orderverify = checkout.clickconfirmordercontinuebutton();
		orderverify.clickLogOutLick();
		System.out.println("testing feature branch");
		System.out.println("testing feature branch2");
		System.out.println("testing feature branch3003");
		System.out.println("testing feature branch3005 vishal");
		System.out.println("testing feature branch3006 vishal");
		

		//Fin
         
	}
	
	/*@Test
	public void tcase2() {
			//this is on facebook, make sure to change url in properties
		testLog = extent.startTest(this.getClass().getSimpleName());
		String[][] data = excelData.readData("LoginPage");
		PageName pageClassName = new PageName(driver, testLog);
		PageFactory.initElements(driver, pageClassName);
		pageClassName.enterUserName(data[0][0]);
		SecondPageName secondPageName = pageClassName.clickOnLoginButton();
		assertEquals("Forgotten password?", secondPageName.verifyForgottenPassword());
	}*/
	
	
}
