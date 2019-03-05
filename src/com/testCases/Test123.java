package com.testCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.library.Library;

//import xls.ShineXlsReader;

public class Test123 extends Library {
	@BeforeClass
	public void bmethod(){
		if((ht.get("Test123")==null) || (!ht.get("Test123").equalsIgnoreCase("yes"))){
			throw new SkipException("This testcase  is not set for execution");
		}
	}
	@Test(dataProvider="getdata")
	public void testcase123(String cname,String cdesc,String cradio) throws Throwable{
		login();
		clickontask();
		clickonproandcustomer();
		clickoncreatenewcustomer();
		createcustomer(cname, cdesc, cradio);
		verifysucessmsg();
		l.info("----------------------------------------------------------Test is completed------------------------------------------");
		assertall();
	}
	
	@DataProvider
	public Object[][] getdata() throws Throwable{
		FileInputStream fi = new FileInputStream(new File(".\\\\src\\\\com\\\\excelFiles\\\\DataPool.xlsx"));
		XSSFWorkbook xls = new XSSFWorkbook(fi);
		//ShineXlsReader xls=new ShineXlsReader(".\\src\\com\\excelFiles\\DataPool.xlsx");
		int rcount =xls. getSheet("Test1").getLastRowNum();
		int ccount = xls.getSheet("Test1").getRow(0).getLastCellNum();
		Object obj[][]=new Object[rcount-1][ccount];
		for( int i=2;i<=rcount;i++){
			for( int j=0;j<ccount;j++){
				obj[i-2][j]=xls.getSheet("Test1").getRow(i).getCell(j).getStringCellValue();
				
			}
			
		}
		xls.close();
		return obj;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
