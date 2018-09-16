package com.crm.qa.testcases;

import java.io.IOException;



import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homepage;
	TestUtil testutil;
	
	ContactsPage contactspage= new ContactsPage();
	String sheetName="contacts";
	public ContactsPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeMethod
	public void setup() throws IOException, InterruptedException {
		initialization();
		testutil= new TestUtil();
		loginPage = new LoginPage();
		homepage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        testutil.switchToFrame();
        contactspage=homepage.clickOnCOntactsLink();
		
	}
	
	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][]=TestUtil.getTestData(sheetName);
	return data;
	}

    /*@Test(priority=3)
	public void verifyContactsPageLabel()
	{
	Assert.assertTrue(contactspage.verifyContactsLabel());
	}
	
    @Test(priority=2)
	public void selectContactsTest() throws InterruptedException
	{
    	contactspage.selectContacts("test2 test2");
	Thread.sleep(5000);
	}*/
	
    @Test(priority=1, dataProvider="getCRMTestData")
	public void validateCreateNewContact(String Title, String FirstName, String LastName, String Company) throws InterruptedException
	{
		homepage.clickonNewContacts();
		contactspage.createNewContact(Title,FirstName,LastName,Company);
    }
	
	
	@AfterMethod
	public void teardown() {
		//driver.quit();
	}
}
