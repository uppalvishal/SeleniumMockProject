package com.projectname.tests;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.projectname.baseclass.BaseTestSuite;
import com.projectname.pages.PageName;
import com.projectname.pages.RegistrationPage;
import com.projectname.pages.SecondPageName;

public class Test_001 extends BaseTestSuite {

	@Test
	public void tcase1() {
		testLog = extent.startTest(this.getClass().getSimpleName());
		RegistrationPage register = PageFactory.initElements(driver, RegistrationPage.class);
		register.enterUsername();
		register.enterPassword();
		register.enterEmail();
		System.out.println("changes by vishal");	
		System.out.println("updated");
		System.out.println("Phil's changes #2");
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
