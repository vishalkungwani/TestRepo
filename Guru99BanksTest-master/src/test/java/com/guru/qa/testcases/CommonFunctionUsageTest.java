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

public class CommonFunctionUsageTest extends TestBase {
	
	TestUtility testUtility;
	CommonFunctionUsage commonFunctionUsage;
	String sheetName1 = "AutoCompleteSampleSheet";
	
	public CommonFunctionUsageTest() {
		super();
	}
	
	@BeforeMethod(alwaysRun=true)
	public void setUp() {
		initialization();
		Log.info("Application Launched Successfully");
		commonFunctionUsage = new CommonFunctionUsage();
		testUtility = new TestUtility();
	}
	
	//To run below test case go to config.properties file and uncomment url = https://jqueryui.com/autocomplete/. comment all other url's
	@DataProvider
	public Object[][] getAutoCompleteTestData() throws InvalidFormatException {
		Object data[][] = TestUtility.getTestData(sheetName1);
		return data;
	}
	
	@Test(priority =1 , dataProvider = "getAutoCompleteTestData" )
	public void validateAutoCompleteDataFromExcel(String autoCompleteDDValue) throws InterruptedException {
		commonFunctionUsage.autoCompleteTB(autoCompleteDDValue);
	}
	
	@AfterMethod
	public void tearDown() {
		//driver.close();
	}
}
