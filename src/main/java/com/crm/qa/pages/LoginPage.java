package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{

	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginbtn;
	
	@FindBy(linkText="Sign Up")
	WebElement signUpBtn;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;
	
	public LoginPage()throws IOException
	
	{
	PageFactory.initElements(driver, this);
	}

	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean validateCrmImage()
	
	{return crmLogo.isDisplayed();}
	
	public HomePage login(String un, String pwd) throws InterruptedException, IOException
	{
	username.sendKeys(un);
	Thread.sleep(5000);
	password.sendKeys(pwd);
	Thread.sleep(5000);
	loginbtn.click();
	return new HomePage();
	}
}
