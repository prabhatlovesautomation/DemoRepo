package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

 
	
	@FindBy(xpath="//td[contains(text(),'User: Prabhat Chaturvedi')]")
    WebElement userNameLabel;
 	@FindBy(linkText="CONTACTS")
 	WebElement contactsLink;
 	@FindBy(linkText="DEALS")
 	WebElement dealsLink ;
 	@FindBy(linkText="TASKS")
 	WebElement tasksLink; 	
 	@FindBy(xpath="//*[@id=\"navmenu\"]/ul/li[4]/ul/li[1]/a")
 	WebElement newcontactsLink;
 	
 	
 	public	HomePage() throws IOException
 	 {
 		PageFactory.initElements(driver, this);
 	 }
   
 	public String verifyHomePageTitle()
     {
    return driver.getTitle();
     }
    public ContactsPage clickOnCOntactsLink() throws IOException
    {
    contactsLink.click();
    return new ContactsPage();
    }
    public DealsPage clickOnDealsLink() throws IOException
    {
    dealsLink.click();
    return new DealsPage();
    }
    public TasksPage clickOntasksLink() throws IOException
    {
    tasksLink.click();
    return new TasksPage();
    }
    public boolean verifyCorrectUsername()
    {
    	return userNameLabel.isDisplayed();
    }
    
    
    public void clickonNewContacts() throws InterruptedException
    {
    	Actions action= new Actions(driver);
    	
    	action.moveToElement(contactsLink).build().perform();
    	
    	newcontactsLink.click();
    }	


}	