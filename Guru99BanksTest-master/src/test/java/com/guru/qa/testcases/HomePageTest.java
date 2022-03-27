package com.guru.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.guru.qa.base.TestBase;
import com.guru.qa.pages.DepositPage;
import com.guru.qa.pages.HomePage;
import com.guru.qa.pages.LoginPage;
import com.guru.qa.pages.NewAccountPage;
import com.guru.qa.pages.NewCustomerPage;

public class HomePageTest extends TestBase {
	
	HomePage homePage;
	LoginPage loginPage;
	NewCustomerPage newCustomerPage;
	NewAccountPage newAccountPage;
	DepositPage depositPage;
	
	//calling TestBase class constructor to initialize the property class 
	public HomePageTest() {
		super();
	}

	@BeforeMethod(alwaysRun=true)
	public void setUp() {
		
		initialization();
		Log.info("Application Launched Successfully");
		newCustomerPage = new NewCustomerPage();
		newAccountPage = new NewAccountPage();
		depositPage = new DepositPage();
		loginPage = new LoginPage();
		homePage = loginPage.validateLogin(property.getProperty("username"), property.getProperty("password"));	
	}
	
	@Test(priority = 1)
	public void validateSeleniumBtnTest() {
		
		Boolean flag = homePage.validateSeleniumProjBtnDisplay();
		Assert.assertTrue(flag);
		System.out.println(flag);
		Log.info("Verified validateSeleniumBtnTest");
	}
	
	@Test(priority = 2)
	public void validateInsPrjBtnTest() {
		
		Boolean flag = homePage.validateInsProjBtnDisplay();
		Assert.assertTrue(flag);
		System.out.println(flag);
		Log.info("Verified validateInsPrjBtnTest");
	}
	
	@Test(priority = 3)
	public void validateAgilePrjBtnTest() {
		
		Boolean flag = homePage.validateAgileProjBtnDisplay();
		Assert.assertTrue(flag);
		System.out.println(flag);
		Log.info("Verified validateAgilePrjBtnTest");
	}
	
	@Test(priority = 4)
	public void validateBankPrjBtnTest() {
		
		Boolean flag = homePage.validateBankProjBtnDisplay();
		Assert.assertTrue(flag);
		System.out.println(flag);
		Log.info("Verified validateBankPrjBtnTest");
	}
	
	@Test(priority = 5)
	public void validateSecPrjBtnTest() {
		
		Boolean flag = homePage.validateSecurityProjBtnDisplay();
		Assert.assertTrue(flag);
		System.out.println(flag);
		Log.info("Verified validateSecPrjBtnTest");
	}
	
	@Test(priority = 6)
	public void validateTcomPrjBtnTest() {
		
		Boolean flag = homePage.validateTcomProjBtnDisplay();
		Assert.assertTrue(flag);
		System.out.println(flag);
		Log.info("Verified validateTcomPrjBtnTest");
	}
	
	@Test(priority = 7)
	public void validatePayGatPrjBtnTest() {
		
		Boolean flag = homePage.validateAPayGateProjBtnDisplay();
		Assert.assertTrue(flag);
		System.out.println(flag);
		Log.info("Verified validatePayGatPrjBtnTest");
	}
	
	@Test(priority = 8)
	public void validateNewToursPrjBtnTest() {
		
		Boolean flag = homePage.validateNewTourseProjBtnDisplay();
		Assert.assertTrue(flag);
		System.out.println(flag);
		Log.info("Verified validateNewToursPrjBtnTest");
	}
	
	@Test(priority = 9)
	public void validateSEOBtnTest() {
		
		Boolean flag = homePage.validateSEOProjBtnDisplay();
		Assert.assertTrue(flag);
		System.out.println(flag);
		Log.info("Verified validateSEOBtnTest");
	}
	
	
//************************Test Cases for left side vertical bar**************************
	
	@Test(priority = 10)
	public void clickOnNewCustomerLinkTest() {
		
		newCustomerPage = homePage.clickOnNewCustomerlink();
		Log.info("Verified clickOnNewCustomerLinkTest");
	}
	
	@Test(priority = 11)
	public void clickOnNewAccountPageTest() {
		
		newAccountPage = homePage.clickOnNewAccountLink();
		Log.info("Verified clickOnNewAccountPageTest");
	}
	
	@Test(priority = 12)
	public void clickOnDepositPageTest() {
		
		depositPage = homePage.clickOnDepositLink();
		Log.info("Verified clickOnDepositPageTest");
	}
	
	@Test(priority = 13)
	public void functionality1Test2() {
		//extentTest = extent.startTest("functionality1Test2");
		Assert.assertEquals("vishal", "gupta");
	}
	
	/*@AfterTest
	public void tearDown() {
		driver.quit();
	}*/
}
