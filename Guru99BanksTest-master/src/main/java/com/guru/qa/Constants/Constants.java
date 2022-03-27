package com.guru.qa.Constants;

public class Constants 
{
	public static final String CHROME_DRIVER_PATH = System.getProperty("user.dir") + "/Drivers/chromedriver.exe";
	public static final String INTERNET_EXPLORER_DRIVER_PATH = System.getProperty("user.dir") + "/Drivers/IEDriverServer.exe";
	public static final String FIREFOX_DRIVER_PATH = System.getProperty("user.dir") + "/Drivers/geckodriver.exe";
	
	public static final long PAGE_LOAD_TIMEOUT = 30;
	public static final long IMPLICIT_WAIT = 15;
	public static final long EXPLICIT_WAIT = 15;

	public static final int SHORT_WAIT = 3000;
	public static final int MEDIUM_WAIT = 6000;
	public static final int LONG_WAIT = 10000;
	
/*	public static final String LOGIN_PAGE_TITLE = "CRMPRO - CRM software for customer relationship management, sales, and support.";
	public static final String HOME_PAGE_TITLE = "CRMPRO";*/

	public static final String TEST_DATA_SHEET_PATH = System.getProperty("user.dir") + "/src/main/java/com/guru/qa/testdata/Guru99_NewCustomerCreationPage_FRAMEWORK.xlsx";
	
	// Below four strings are used in CommonFunctionUsage class
	public static final String ListDropdownLocator = "//ul[@id=\"ui-id-1\"]//li";
	public static final String ListDropdownLocatorSeleniumEasy = "//select[@id='select-demo']//option";
	
	public static final String SelectaFileDDLocator = "//div[@id = 'ui-id-2']";
	public static final String SelectaFileDDValue = "ui.jQuery.js";
}
