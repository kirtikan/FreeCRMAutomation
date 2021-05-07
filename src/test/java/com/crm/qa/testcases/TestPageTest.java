package com.crm.qa.testcases;

import org.testng.annotations.BeforeMethod;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LoginPage;

public class TestPageTest extends TestBase{
	
	public TestPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		//loginPage = new LoginPage();
	}
}
