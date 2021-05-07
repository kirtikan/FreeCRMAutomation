package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{
	
	//@FindBy(xpath ="//div[contains(text(),'Contacts')]")
	@FindBy(xpath = "//div[text()='Contacts']")
	WebElement contactsLabel;
	
	//@FindBy(xpath = "//td[contains(text(),'test1 test1')]//preceding-sibling::td//div")
	
	//intialize Page Objects
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyContactsLabel() {
		return contactsLabel.getText();
	}
	
	public void selectContactsByName(String name) {
			driver.navigate().refresh();
			WebElement element = driver.findElement(By.xpath("//td[contains(text(),'"+name+"')]//preceding-sibling::td/div"));
			element.click();
	}
	
	public void selectMultipleContactsByName() {
		//driver.navigate().refresh();
		//2 times calls the method selectContactsByName but its has refresh code in this method
	}
	
	
}
