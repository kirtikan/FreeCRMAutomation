package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class ContactsPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;

	public ContactsPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		System.out.println("fsteye1111111");
		initialization();
		System.out.println("1111111111111");
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
		contactsPage = homePage.clickOnContactsLink();
	}

	@Test(priority = 1, groups = "basic")
	public void validateContactsLabelTest() {
		System.out.println("hiiiiiiiiiiiiii");
		
		test = extent.createTest("Test ContactLabel", " Contacts Label");
		
		System.out.println("noooooooooooooo");
		Assert.assertEquals(contactsPage.verifyContactsLabel(), "Contacts");

	}

	@Test(priority = 2, groups = { "basic", "main" }, enabled = false)
	public void selectContactsByNameTest() {
		test = extent.createTest("Test SelectByName", " Select Contacts By Name");
		contactsPage.selectContactsByName("test1 test1");
		Assert.assertEquals(1, 1);
	}

}
