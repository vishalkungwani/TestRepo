package com.guru.qa.testcases;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.guru.qa.Utilities.Xls_Reader;
import com.guru.qa.Utilities.TestUtility;
import com.guru.qa.base.TestBase;
import com.guru.qa.pages.HomePage;
import com.guru.qa.pages.LoginPage;
import com.guru.qa.pages.NewCustomerPage;


public class NewCustomerPageTest extends TestBase {

	
	LoginPage loginPage;
	HomePage homePage;
	NewCustomerPage newCustomerPage;
	String sheetName = "NewCustomers";
	int rowNumber =2;
	
	public NewCustomerPageTest() {
		super();
	}
	
	@BeforeMethod(alwaysRun=true)
	public void setUp() {
		
		initialization();
		Log.info("Application Launched Successfully");
		homePage = new HomePage();
		newCustomerPage = new NewCustomerPage();
		loginPage = new LoginPage();
		homePage = loginPage.validateLogin(property.getProperty("username"), property.getProperty("password"));
		newCustomerPage = homePage.clickOnNewCustomerlink();
	}
	
	@DataProvider
	public Object[][] getGuru99NewCustomerTestData() throws InvalidFormatException {
		Object data[][] = TestUtility.getTestData(sheetName);
		return data;
	}
	
	@Test(priority = 1 , dataProvider = "getGuru99NewCustomerTestData")
	public void validateNewCustomerTestData(String CustName,String gender,String dob,String DOB_Year,String add,String city,
			String state,String pinCode,String mobNo,String email,String password) throws IOException {
		
		newCustomerPage.createNewCustomer(CustName, gender, dob, DOB_Year, add, city, state, pinCode,
				mobNo, email, password);
		
		NewCustomerPage.printDataOnExcel(rowNumber);
		rowNumber++;
		TestUtility.takeScreenshotAtEndOfTest();
		Log.info("Verified validateNewCustomerTestData");
	}
	
	/*@AfterMethod
	public void tearDown() {
		driver.quit();
	}*/
}
