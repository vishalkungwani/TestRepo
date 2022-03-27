package com.guru.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.guru.qa.base.TestBase;

public class DepositPage extends TestBase {
	
	@FindBy(xpath = "//input[@name = 'accountno']")
	WebElement DepAcctNo;
	
	@FindBy(xpath = "//input[@name = 'ammount']")
	WebElement DepAmount;
	
	@FindBy(xpath = "//input[@name = 'desc']")
	WebElement DepDesc;
	
	@FindBy(xpath = "//input[@name = 'AccSubmit']")
	WebElement SubmitBtn;
	
	public DepositPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void getDepositData(String depAcct, String depAmt ,String depDesc) {
		
		DepAcctNo.sendKeys(depAcct);
		DepAmount.sendKeys(depAmt);
		DepDesc.sendKeys(depDesc);
		
		SubmitBtn.click();
	}

}
