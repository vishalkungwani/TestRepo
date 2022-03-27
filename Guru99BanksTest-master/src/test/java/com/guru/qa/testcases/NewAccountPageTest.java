package com.guru.qa.testcases;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.guru.qa.Utilities.TestUtility;
import com.guru.qa.base.TestBase;
import com.guru.qa.pages.HomePage;
import com.guru.qa.pages.LoginPage;
import com.guru.qa.pages.NewAccountPage;

public class NewAccountPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	NewAccountPage newAccountPage;
	String sheetName = "NewAccounts";
	public NewAccountPageTest() {
		super();
	}
	
	@BeforeMethod(alwaysRun=true)
	public void setUp() {
		
		initialization();
		Log.info("Application Launched Successfully");
		homePage = new HomePage();
		loginPage = new LoginPage();
		newAccountPage = new NewAccountPage();
		homePage = loginPage.validateLogin(property.getProperty("username"), property.getProperty("password"));
		newAccountPage = homePage.clickOnNewAccountLink();
	}
	
	
	@DataProvider
	public Object[][] getGuru99NewAccountTestData() throws InvalidFormatException {
		Object data[][] = TestUtility.getTestData(sheetName);
		return data;
	}
	
	@Test(priority =1 , dataProvider = "getGuru99NewAccountTestData")
	public void validateNewAccountTestData (String custId, String AccountType
			, String initDeposit) throws IOException {
		newAccountPage.addNewAccount(custId,AccountType ,initDeposit);
		TestUtility.takeScreenshotAtEndOfTest();
		Log.info("Verified validateNewAccountTestData");
	}
	
	/*@AfterMethod
	public void tearDown() {
		driver.quit();
	}*/

}
