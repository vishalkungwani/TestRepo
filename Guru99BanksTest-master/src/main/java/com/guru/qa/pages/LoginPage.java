package com.guru.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.guru.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	
	@FindBy(name = "uid")
	WebElement username;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(name = "btnLogin")
	WebElement LoginBtn;
	
	@FindBy(xpath = "//h2[contains(text(),'Guru99 Bank')]")
	WebElement Guru99BankLabel;
	
	@FindBy(xpath = "//img[@src = \"/logo.png\"]")
	WebElement Guru99Logo;
	

	public LoginPage() {
		
		//the below statement means that all 'this' above WebElement object will get initialized with 'driver' which is present in the base class 
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public Boolean validateLoginPageLogo() {
		return Guru99Logo.isDisplayed();
	}
	
	public Boolean validateLoginPageLabel() {
		return Guru99BankLabel.isDisplayed();
	}
	
	public HomePage validateLogin(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		LoginBtn.click();
		return new HomePage();
	}
}
