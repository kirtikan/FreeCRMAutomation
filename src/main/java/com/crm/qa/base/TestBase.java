package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
//import org.testng.ITestResult;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterSuite;
//import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.crm.qa.util.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public final static String current_dir = System.getProperty("user.dir");

	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;

	public TestBase() {
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream(
					"C:\\Users\\Kirti\\eclipse-workspace\\FreeCRM\\src\\test\\resources\\config.properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void initialization() {

		driver = TestUtil.getDriver();
		System.out.println("driver is -->" + driver);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICITLY_WAIT, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));

	}

	@BeforeSuite
	public void setExtentReport() {

		htmlReporter = new ExtentHtmlReporter(current_dir + "\\test-output\\extentReports\\extentReport.html");
		htmlReporter.config().setDocumentTitle("FreeCRM Automation Report");
		htmlReporter.config().setReportName("FreeCRM Functional Report");
		htmlReporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("HostName", "Localhost");
		extent.setSystemInfo("Tester", "Kirti");
		extent.setSystemInfo("OS", "Windows10");
		extent.setSystemInfo("Browser", prop.getProperty("browser"));
	}

//
	@AfterMethod
	public void tearDown(ITestResult result) throws Exception {
		System.out.println("Result is =" + result.getStatus());
		if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "Test Case PASSED is " + result.getName());
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "Test Case SKIPPED is " + result.getName());
		} else if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "Test Case FAILED is :" + result.getName());
			test.log(Status.FAIL, "Test Case FAILED is :" + result.getThrowable());

			// ADDING SCREENSHOT TO IT
			String scPath = TestUtil.getScreenshotAtEndOfTest(result.getName());
			test.addScreenCaptureFromPath(scPath);
		}
		driver.quit();
	}

	@AfterSuite
	public void endExtentReport() {

		extent.flush();
		
	}
}
