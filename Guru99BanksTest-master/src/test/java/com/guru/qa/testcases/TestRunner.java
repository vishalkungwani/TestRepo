package com.guru.qa.testcases;

import org.testng.TestNG;

public class TestRunner {
	
	static TestNG testNg;

	public static void main(String[] args) {
		
		testNg = new TestNG();
		
		testNg.setTestClasses(new Class[] {LoginPageTest.class,HomePageTest.class});
		testNg.run();
		
		// TODO Auto-generated method stub

	}

}
