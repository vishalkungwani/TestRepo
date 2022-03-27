package com.guru.qa.testcases;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.guru.qa.Utilities.TestUtility;
import com.guru.qa.base.TestBase;
import com.guru.qa.pages.CommonFunctionUsage;

public class CommonFunctionUsageTestSelEasy extends TestBase {
	
	TestUtility testUtility;
	CommonFunctionUsage commonFunctionUsage;
	String sheetName2 = "DataFromSeleniumEasyURL";
	String sheetName3 = "DDDataFromSeleniumEasyURL";
	
	public CommonFunctionUsageTestSelEasy() {
		super();
	}
	
	@BeforeMethod(alwaysRun=true)
	public void setUp() {
		initialization();
		Log.info("Application Launched Successfully");
		commonFunctionUsage = new CommonFunctionUsage();
		testUtility = new TestUtility();
	}
	
	//To run below set of test cases go to config.properties file and uncomment url = https://www.seleniumeasy.com/test/. comment all other url's
	@DataProvider
	public Object[][] getSeleEasyTestData() throws InvalidFormatException {
		Object data[][] = TestUtility.getTestData(sheetName3);
		return data;
	}
	
	/*@Test(priority = 1)
	public void verifyAlertHandling() throws InterruptedException {
		commonFunctionUsage.handleAlerts();
	}
	
	@Test(priority = 2 , dataProvider = "getSeleEasyTestData")
	public void verifyWindowsHandlingAndDatePicker(String childEmail, String datePickerValue) {
		commonFunctionUsage.handleWindowPopUp(childEmail);
		commonFunctionUsage.datePicker(datePickerValue);
	}*/
	
	@Test(priority = 1 , dataProvider = "getSeleEasyTestData")
	public void verifySeleniumEasyDDValue(String Days) {
		
		commonFunctionUsage.clickOnSeleniumEasyDD();	
		WebElement dropdownLocatorSeleniumEasy = driver.findElement(By.id("select-demo"));
		List<String> expectedDropDownValues = Arrays.asList("Please select","Sunday", "Monday","Tuesday","Wednesday","Thursday","Friday","Saturday");
		List<String> actualDropDownValues = TestUtility.dropDownValuesValidation(dropdownLocatorSeleniumEasy);
		try {
				Assert.assertEquals(actualDropDownValues, expectedDropDownValues);
			}	
		catch (AssertionError e) {
				System.out.println("Not equal");
				throw e;
			}
		System.out.println("Equal");
		commonFunctionUsage.seleniumEasyDD(Days);
	}
	
	@AfterMethod
	public void tearDown() {
		//driver.close();
	}
}
