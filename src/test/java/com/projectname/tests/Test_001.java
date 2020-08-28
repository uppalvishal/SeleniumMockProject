package com.projectname.tests;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.projectname.pages.LoginPage;

import com.projectname.baseclass.BaseTestSuite;
import com.projectname.pages.BooksPage;
import com.projectname.pages.HomePage;
import com.projectname.pages.PageName;
import com.projectname.pages.RegistrationPage;
import com.projectname.pages.SecondPageName;
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
		login.enterEmail("vuppal@gmail.com");
		testLog.log(LogStatus.INFO, testLog.addScreenCapture(createScreenshot()));
		login.enterPassword("test123");
		testLog.log(LogStatus.INFO, testLog.addScreenCapture(createScreenshot()));
		HomePage home=login.clickOnLoginButton();
		testLog.log(LogStatus.INFO, testLog.addScreenCapture(createScreenshot()));
        System.out.println("reached here");
		BooksPage bookspage=home.clickBooksLinkUnderCategories();
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
