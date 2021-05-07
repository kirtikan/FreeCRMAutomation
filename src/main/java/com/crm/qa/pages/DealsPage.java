package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class DealsPage extends TestBase{
	
	//Page Factory or OR
	@FindBy(xpath = "//a[@href='/deals/new']/button")
	WebElement dealsNewBtn;
	
	@FindBy(name="title")
	WebElement titleField;
	
	@FindBy(xpath = "//div[@name='company']/input")
	WebElement companyField;
	
	@FindBy(name = "commission")
	WebElement commissionField;
	
	@FindBy(name = "amount")
	WebElement amountField;
	
	@FindBy(xpath = "//button[@class='ui linkedin button']")
	WebElement dealsSave;
	
	//Initializing the ORs
	public DealsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnDealsNewButton() {
		dealsNewBtn.click();
	}
	
	public void createNewDeal(String title, String commission,String amount) {
		titleField.sendKeys(title);
		//companyField.sendKeys(company);
		commissionField.sendKeys(commission);
		amountField.sendKeys(amount);
		dealsSave.click();
		System.out.println("Successfully Saved");
	}
	
	
}
