package com.guru.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.guru.qa.base.TestBase;

public class HomePage extends TestBase{
	
	//Page Factory - OR for Home page
	
	//Horizontal bar buttons
	
	@FindBy(xpath = "//a[contains(text(),'Insurance Project')]")
	WebElement InsProjBtn;
	
	@FindBy(xpath = "//a[contains(text(),'Agile Project')]")
	WebElement AgileProjBtn;
	
	@FindBy(xpath = "//*[@id=\"navbar-brand-centered\"]/ul/li[5]/a")
	WebElement BankProjBtn;
	
	@FindBy(xpath = "//a[contains(text(),'Security Project')]")
	WebElement SecurityProjBtn;
	
	@FindBy(xpath = "//a[contains(text(),'Telecom Project')]")
	WebElement TcomProjBtn;
	
	@FindBy(xpath = "//a[contains(text(),'Payment Gateway Project')]")
	WebElement PayGateProjBtn;
	
	@FindBy(xpath = "//a[contains(text(),'New Tours')]")
	WebElement NewToursProjBtn;
	
	@FindBy(xpath = "//*[@id=\"navbar-brand-centered\"]/ul/li[11]/a")
	WebElement SEOBtn;
	
	@FindBy(xpath = "//*[@id=\"navbar-brand-centered\"]/ul/li[1]/a")
	WebElement SeleniumBtn;
	
	//Vertical bar buttons
	
	@FindBy(xpath ="//a[contains(text(),'New Customer')]")
	WebElement NewCustomerBtn;
	
	@FindBy(xpath ="//a[contains(text(),'New Account')]")
	WebElement NewAcctBtn;
	
	@FindBy(xpath ="//a[contains(text(),'Deposit')]")
	WebElement DepositBtn;
	
	@FindBy(xpath = "//div[@id = 'closeBtn']")
	WebElement CloseAdBtn;
	
	@FindBy(xpath = "//div[@id = 'transparentInner']")
	WebElement Ad;
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	
	public boolean validateInsProjBtnDisplay() {
		return InsProjBtn.isDisplayed();
	}
	
	public boolean validateAgileProjBtnDisplay() {
		return AgileProjBtn.isDisplayed();
	}
	
	public boolean validateBankProjBtnDisplay() {
		return BankProjBtn.isDisplayed();
	}
	public boolean validateSecurityProjBtnDisplay() {
		return SecurityProjBtn.isDisplayed();
	}
	
	public boolean validateTcomProjBtnDisplay() {
		return TcomProjBtn.isDisplayed();
	}
	
	public boolean validateAPayGateProjBtnDisplay() {
		return PayGateProjBtn.isDisplayed();
	}
	
	public boolean validateNewTourseProjBtnDisplay() {
		return NewToursProjBtn.isDisplayed();
	}
	
	public boolean validateSEOProjBtnDisplay() {
		return SEOBtn.isDisplayed();
	}
	
	public boolean validateSeleniumProjBtnDisplay() {
		return SeleniumBtn.isDisplayed();
	}
	
	
	//*****************************************************************
	//Below functions are for the buttons/pages on the left side vertical bar
	
	public NewCustomerPage clickOnNewCustomerlink() {
		NewCustomerBtn.click();
		return new NewCustomerPage();
	}
	
	public NewAccountPage clickOnNewAccountLink() {
		NewAcctBtn.click();
		return new NewAccountPage();
	}
	
	public DepositPage clickOnDepositLink() {
		
		//I am trying to switch to the frame which contains video ad and trying to click on the close button of that ad
		
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[title='Flow Close Button']")));
		Boolean frameClose = driver.findElement(By.xpath("//div[@id = 'closeBtn']")).isDisplayed();
		System.out.println(frameClose);
		
		//In the below line of code I am waiting for the close btn in the add to appear before clicking on it.
		
		new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id = 'closeBtn']"))).click();
	
		// Switching back from the frame to the original web page.
		
		driver.switchTo().defaultContent();
		
		DepositBtn = driver.findElement(By.xpath("//a[contains(text(),'Deposit')]"));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", DepositBtn);
		
	//	DepositBtn.click();
		return new DepositPage();
	}
}
