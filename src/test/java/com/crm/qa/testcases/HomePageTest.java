package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	// DealsPage dealsPage;

	public HomePageTest() {
		super();
	}

	// test cases should be separated -- independent with each other
	// before each test case -- launch the browser and login
	// @Test -- execute your test case
	// after each test case -- close a browser

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));// login into the system to
																							// goto Home Page
	}

	@Test(priority = 1,groups="basic")
	public void validateHomePageTitleTest() {
		test = extent.createTest("Test HomePageTitle","Home Page Title");
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Cogmento CRM", "Home Page Title not matched1");
	}

	@Test(priority = 2,groups="main")
	public void validateCorrectUserNameTest() {
		
		test = extent.createTest("Test User","User Name");
		Assert.assertTrue(homePage.verifyCorrectUserName());
	}

	@Test(priority = 3,groups= {"basic","main"})
	public void verifyContactsLinkTest() {

		test = extent.createTest("Test ContactLink","Contacts Link");
		contactsPage = homePage.clickOnContactsLink();
		Assert.assertEquals(contactsPage.verifyContactsLabel(), "Contacts", "Contacts Label is not Present");
	}

}
