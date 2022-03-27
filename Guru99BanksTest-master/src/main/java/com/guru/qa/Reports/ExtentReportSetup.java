package com.guru.qa.Reports;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.guru.qa.base.TestBase;
import com.guru.qa.Utilities.TestUtility;

public class ExtentReportSetup extends TestBase
{	
	public static ExtentReports extent;
	public static ExtentTest extentTest;
	public static ExtentSparkReporter sparkReport;
		
	public static ExtentReports extentReportSetup()
	{
		//sparkReport = new ExtentSparkReporter(System.getProperty("user.dir") + "\\Guru99ExtentResults\\Guru99ExtentReport" + TestUtility.getSystemDate() + ".html");
		sparkReport = new ExtentSparkReporter(System.getProperty("user.dir") + File.separator + "Guru99ExtentResults" + File.separator + "Guru99ExtentReport" + TestUtility.getSystemDate() + ".html");
		
		extent = new ExtentReports();
		extent.attachReporter(sparkReport);
		
		sparkReport.config().setTheme(Theme.STANDARD);
		sparkReport.config().setReportName("Test Automation Report");
		sparkReport.config().setDocumentTitle("Test Automation Report");
		
		return extent;
	}
}
