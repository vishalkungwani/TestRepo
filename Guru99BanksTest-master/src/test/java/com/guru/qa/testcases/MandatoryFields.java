package com.guru.qa.testcases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class MandatoryFields {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver","F:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.rishtadilka.com/register.registerstep0");
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		WebElement NameLbl = driver.findElement(By.xpath("//h3[contains(text(),'Name')]"));
		WebElement MobLbl = driver.findElement(By.xpath("//h3[contains(text(),'Mobile')]"));
		WebElement LookingLbl = driver.findElement(By.xpath("//h3[contains(text(),'Looking for ')]"));
		WebElement GenderLbl = driver.findElement(By.xpath("//h3[contains(text(),'Gender')]"));
		WebElement MandatoryList = driver.findElement(By.xpath("//span[contains(text(),'*')]"));
		
		//Function for getting all the expected values
		List<WebElement> ExpList = List.of(LookingLbl,GenderLbl,MandatoryList,NameLbl,MobLbl );
		System.out.println("Expected list size is : " +ExpList.size());
		System.out.println("Expected list of Web Elements below : ");
		for(WebElement expElem : ExpList) {
			System.out.println(expElem.getText());
		}
		System.out.println("********************************************************");
		
		//Function for getting all the actual values
		List<WebElement> ActList = driver.findElements(By.xpath("//h3[contains(text(),'')]"));
		System.out.println("WebElement list size is : " +ActList.size()); // Actual list contains 5 values of which one value will be filtered below
		System.out.println("Actual list of Web Elements below : ");
		for(WebElement elem : ActList) {
			if(elem.getText().contains("*")) { //filetring values containing * - so the list will become 4
				System.out.println(elem.getText());
			}			
		}
		System.out.println("********************************************************");
		
		//Function for comparing Actual with Expected values
		for (WebElement expected: ExpList) {
			if (ActList.contains(expected)) {
				System.out.println("Values Matched : "+expected.getText());
			} else {
				System.out.println("Unmatched Value is  :"+expected.getText());
			}
		}
	}
}
