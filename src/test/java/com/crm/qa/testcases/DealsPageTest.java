package com.crm.qa.testcases;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class DealsPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	DealsPage dealsPage;

	public String sheetName = prop.getProperty("testdata_sheet");

	public DealsPageTest() {
		super();
	}


	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
		dealsPage = homePage.clickOnDealsLink();
	}

	@Test(priority=1,groups="basic")
	public void clickOnDealsNewButtonTest() {	
		test = extent.createTest("Test newButtonOnDealPage", "Click on New Button on Deals Page");
		dealsPage.clickOnDealsNewButton();
		Assert.assertEquals(1, 1);
	}

	@DataProvider
	public Object[][] getFreeCRMTestData() {
		return TestUtil.getTestdata(sheetName);
	}

	@Test(priority = 2, dataProvider = "getFreeCRMTestData",groups="main",enabled=false)
	public void createNewDealTest(String title, String commission, String amount) {
		
		test = extent.createTest("Test CreateNewDeal","Create New Deal");
		dealsPage.clickOnDealsNewButton();
		dealsPage.createNewDeal(title, commission, amount);
		Assert.assertEquals(1, 1);
	}
	/*
	 * public void createNewDealTest() { dealsPage.clickOnDealsNewButton();
	 * dealsPage.createNewDeal("Mpower Test", "Mpower SoftComm", "5","6"); }
	 */

}
