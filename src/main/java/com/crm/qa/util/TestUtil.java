package com.crm.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase{

	
	public TestUtil() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	public static String TESTDATA_SHEET_PATH="C:\\Users\\USER\\Desktop\\javaworkspace\\FreeCRM\\src\\main\\java\\com\\crm\\qa\\testdata\\freecrmtestdata.xlsx";
	public static long Page_Load_Timeout=70;
	public static long Implicit_Wait=50;
	public static Sheet sheet;
	public static Workbook book;
	public void switchToFrame()
	{
		driver.switchTo().frame("mainpanel");
	}
	
	public static Object[][] getTestData(String sheetName)
	
	{
		FileInputStream file=null;
	try {
		file=new FileInputStream(TESTDATA_SHEET_PATH);
	}catch(FileNotFoundException e) {e.printStackTrace();}
	try {book= WorkbookFactory.create(file);}
	catch(InvalidFormatException e) {e.printStackTrace();}
	catch(IOException e) {e.printStackTrace();}
	sheet=book.getSheet(sheetName);
	Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	for (int i=0; i<sheet.getLastRowNum();i++)
	{
	for (int k=0;k<sheet.getRow(0).getLastCellNum();k++)
	{
	data[i][k]= sheet.getRow(i+1).getCell(k).toString();
	}
	}return data;
	
}}
