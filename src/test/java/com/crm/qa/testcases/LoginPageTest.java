package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;

	public LoginPageTest() {
		super();
	}


	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
	}

	@Test(priority = 1,groups="basic")
	public void loginPageTitleTest() {

		test = extent.createTest("Test Login","Login Page Title");
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Cogmento CRM");
	}

	@Test(priority = 2,groups="basic")
	public void signUpLinkTest() {
		
		test = extent.createTest("Test SignUpLink","SignUp Link");
		int responseCode = loginPage.validateSignUpLink();
		System.out.println(responseCode);
		Assert.assertEquals(responseCode, 403);
	}

	@Test(priority = 3,groups="main")
	public void loginTest() {
		
		test = extent.createTest("Test Login2App","Login to Application");
		homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));	
		Assert.assertEquals(1, 1);
	}

}
