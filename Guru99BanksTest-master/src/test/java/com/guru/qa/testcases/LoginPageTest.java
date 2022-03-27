package com.guru.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.guru.qa.base.TestBase;
import com.guru.qa.pages.HomePage;
import com.guru.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest() {
		super();
	}

	@BeforeMethod(alwaysRun=true)
	public void setUp() {
		initialization();
		Log.info("Application Launched Successfully");
		loginPage = new LoginPage();
		homePage = new HomePage();
	}
	
	@Test(priority = 1)
	public void loginPageTitleTest() {
		String Title = loginPage.validateLoginPageTitle();
		String ExpectedTitle = "Guru99 Bank Home Page";
		
		//Boolean flag = Assert.assertEquals(Title, "Guru99 Bank Home Page");
		if(	Title.equals(ExpectedTitle)) {
			System.out.println("Actual and Expected title are matching");
		}
		else {
			System.out.println("Title is not matching");
		}
		Log.info("Verified loginPageTitleTest");
	}
	
	@Test(priority = 2)
	public void loginPageLogoTest() {
		Boolean flag = loginPage.validateLoginPageLogo();
		Assert.assertTrue(flag);	
		System.out.println(flag);
		Log.info("Verified loginPageLogoTest");
	}
	
	@Test(priority = 3)
	public void loginPageLabelTest() {
		Boolean flag = loginPage.validateLoginPageLabel();
		Assert.assertTrue(flag);
		System.out.println(flag);
		Log.info("Verified loginPageLabelTest");
	}
	
	@Test(priority = 4)
	public void loginTest() {
		homePage = loginPage.validateLogin(property.getProperty("username"), property.getProperty("password"));
		System.out.println("Login Successful");
		Log.info("Verified loginTest");
	}
	
	@Test(priority = 5)
	public void functionality1Test2() {
		//extentTest = extent.startTest("functionality1Test2");
		Assert.assertEquals("vishal", "gupta");
	}
	/*@AfterMethod
	public void tearDown() {
		driver.quit();
	}*/
}
