package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.crm.qa.util.TestUtil;

public class TestBase {

	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() throws IOException
	{
		try {
		prop= new Properties();
		FileInputStream ip= new FileInputStream("C:\\Users\\USER\\Desktop\\javaworkspace\\FreeCRM\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
		prop.load(ip);
		} catch(FileNotFoundException e)
		{e.printStackTrace();}
		catch(IOException e) {e.printStackTrace();}
		
	}

	public void initialization() throws IOException
	{
		
	String browserName=prop.getProperty("browser");

	if (browserName.equals("chrome"))
	{
	System.setProperty("webdriver.chrome.driver","C:\\Selenium\\selenium-3.7.1\\chromedriver_win32\\chromedriver.exe");
	driver = new ChromeDriver();
	}
	else if (browserName.equals("firefox"))
	{
		System.setProperty("webdriver.gecko.driver","C:\\Selenium\\selenium-3.7.1\\geckodriver-v0.19.1-win64\\geckodriver.exe");	
		driver = new FirefoxDriver();
	}
	else if (browserName.equals("IE"))
	{
		System.setProperty("webdriver.ie.driver","C:\\Selenium\\selenium-3.7.1\\IEDriverServer_x64_3.7.0\\IEDriverServer.exe");
	    driver = new InternetExplorerDriver();
	}
    
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_Timeout, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_Wait, TimeUnit.SECONDS);
	driver.get(prop.getProperty("URL"));
	
	}
	}
	
	
	

