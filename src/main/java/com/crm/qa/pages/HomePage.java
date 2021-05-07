package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	// Page Factory - OR

	// "//span[contains(text(),'"+prop.getProperty("username")+"')]")
	//@FindBy(xpath = "//span[contains(text(),'Kirti Kanojiya')]")
	//WebElement userNameLabel;	
	//@FindBy(xpath = "//a//span[contains(text(),'Contacts')]")
	//@FindBy(xpath = "//a[@href='/contacts']")
	
	@FindBy(linkText = "Contacts")
	//@CacheLookup
	WebElement contactsLink;

	@FindBy(linkText ="Deals")
	WebElement dealsLink;

	@FindBy(linkText = "Tasks")
	WebElement tasksLink;

	// Initialization of Page Objects
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyCorrectUserName() {
		WebElement userNameLabel = driver.findElement(By.xpath("//span[contains(text(),'"+prop.getProperty("username")+"')]"));
		return userNameLabel.isDisplayed();
	}
	
	public ContactsPage clickOnContactsLink() {
		contactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink() {
		dealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTasksPage() {
		tasksLink.click();
		return new TasksPage();
	}
	
	

}
