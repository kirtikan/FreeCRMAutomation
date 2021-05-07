package com.crm.qa.pages;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	// Page Factory - OR

	@FindBy(name = "email")
	WebElement email;

	@FindBy(name = "password")
	WebElement password;

//	@FindBy(xpath="//*[@class='ui fluid large blue submit button']")
//	WebElement loginBtn;

	@FindBy(xpath = "//div[contains(text(),'Login')]")
	WebElement loginBtn;

	@FindBy(xpath = "//a[contains(text(),'Sign Up')]")
	WebElement signUpLink;

	@FindBy(xpath = "//a[contains(text(),'Forgot your password?')]")
	WebElement forgotPwdLink;

	// intialzing the Page Objects
	public LoginPage() {

		PageFactory.initElements(driver, this);
	}

	// Actions:
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public int validateSignUpLink() {

		int resCode = 0;
		try {
			HttpURLConnection connection = (HttpURLConnection) new URL(signUpLink.getAttribute("href"))
					.openConnection();

			connection.connect();
			resCode = connection.getResponseCode();
			connection.disconnect();

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return resCode;
	}

	public HomePage login(String un, String pwd) {

		email.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();

		return new HomePage();
	}

}
