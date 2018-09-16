package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;



public class HomePageTEST extends TestBase {

	LoginPage loginPage;
	HomePage homepage;
    TestUtil testutil;
    ContactsPage contactspage;
	public HomePageTEST() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeMethod
	public void setup() throws IOException, InterruptedException {
		initialization();
		
		loginPage = new LoginPage();
		homepage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        testutil= new TestUtil();
	}

	
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() 
	{
		String HomepageTitle=homepage.verifyHomePageTitle();
	    Assert.assertEquals(HomepageTitle, "CRMPRO");	
	}
	@Test(priority=2) 
	public void verifyUserNameTest()
    {
		testutil.switchToFrame();
    	Assert.assertTrue(homepage.verifyCorrectUsername());
    }
	@Test(priority=3)
	public void verifyContactsLinkTest() throws IOException, InterruptedException
	{
		testutil.switchToFrame();
		contactspage=homepage.clickOnCOntactsLink();
	    Thread.sleep(5000);
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
