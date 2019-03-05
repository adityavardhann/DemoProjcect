package com.testCases;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.library.Library;

//import xls.ShineXlsReader;

public class Test456 extends Library {
	@BeforeClass
	public void bmethod(){
		if((ht.get("Test456")==null) || (!ht.get("Test456").equalsIgnoreCase("yes"))){
			throw new SkipException("This testcase  is not set for execution");
		}
	}
	@Test(dataProvider="getdata")
	public void testcase456(String cname,String pname,String pdesc,String pradio) throws Throwable{
		login();
		clickontask();
		clickonproandcustomer();
		clickoncreatenewproject();
		createproject(cname, pname, pdesc, pradio);
		verifysucessmsg();
		l.info("----------------------------------------------------------Test is completed------------------------------------------");
		assertall();
	}
	
	@DataProvider
	public Object[][] getdata() throws Throwable{
	//	ShineXlsReader xls=new ShineXlsReader(".\\src\\com\\excelFiles\\DataPool.xlsx");
		FileInputStream fi = new FileInputStream(new File(".\\src\\com\\excelFiles\\DataPool.xlsx"));
		XSSFWorkbook xls = new XSSFWorkbook(fi);
		int rcount = xls. getSheet("Test2").getLastRowNum();
		int ccount = xls.getSheet("Test2").getRow(0).getLastCellNum();
		Object obj[][]=new Object[rcount-1][ccount];
		for( int i=2;i<=rcount;i++){
			for( int j=0;j<ccount;j++){
				obj[i-2][j]=xls.getSheet("Test2").getRow(i).getCell(j).getStringCellValue();
			}
		}
		xls.close();
		return obj;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
