package com.guru.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.guru.qa.base.TestBase;

public class NewAccountPage extends TestBase {
	
	@FindBy(xpath ="//input[@name = 'cusid']")
	WebElement CustomerId;
	
	@FindBy(xpath = "//input[@name = 'inideposit']")
	WebElement InitialDeposit;
	
	@FindBy(xpath = "//input[@type= 'submit']")
	WebElement SubmitBtn;
	
	public NewAccountPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void addNewAccount(String custId,String AccountType , String initDeposit) {
		CustomerId.sendKeys(custId);
		
		Select select = new Select(driver.findElement(By.name("selaccount")));
		select.selectByVisibleText(AccountType);
		
		InitialDeposit.sendKeys(initDeposit);
		
		SubmitBtn.click();
						
	}

}
