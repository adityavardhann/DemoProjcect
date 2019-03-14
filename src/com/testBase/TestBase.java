package com.testBase;

import java.io.File;
import java.io.FileInputStream;
import java.util.Hashtable;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.asserts.SoftAssert;

//import xls.ShineXlsReader;



public class TestBase {
	
	public static Properties prop;
	public static FileInputStream fip;
	public static WebDriver driver;
	public static String Browser;
	public static Logger l;
	public static SoftAssert st;
	public static int tc=0;
	//public static ShineXlsReader Mxls;
	public static Workbook Mxls;
	public static Hashtable<String, String> ht;
	public static void OpenBrowser() throws Throwable{
		st=new SoftAssert();
		l=Logger.getLogger("devpinoyLogger");
		fip=new FileInputStream(".\\src\\com\\config\\Or.Properties");
		prop=new Properties();
		prop.load(fip);
		Browser=prop.getProperty("Browser");
		l.info("Browser choosen is "+Browser);
		if(Browser.equalsIgnoreCase("ie")){
			System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
			 driver=new InternetExplorerDriver();
			 System.out.println("IE Browser is launched...");
			 l.info("IE Browser is launched...");
		}else if(Browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			 driver=new ChromeDriver(); //openBrowser
                         System.out.println("chrome Browser is launched...");
			 l.info("chrome Browser is launched...");
		}else if(Browser.equalsIgnoreCase("mozilla")){
			//System.setProperty("webdriver.firefox.marionette", "geckodriver.exe");
			System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
			driver=new FirefoxDriver();
			 l.info("Firefox Browser is launched...");
		}
		driver.get("http://localhost:9000/login.do"); //openurl
		 l.info("url is opened");
		driver.manage().window().maximize(); //maximize browser
		 l.info("Browser is maximized");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		l.info("Implicit wait is set");
	}
	public static void moduledriver() throws Throwable{
		ht=new Hashtable<String, String>();
		
		FileInputStream fi = new FileInputStream(new File(".\\src\\com\\excelFiles\\Moduledriver.xlsx"));
		Mxls = new XSSFWorkbook(fi);
		int modulecount = Mxls.getSheet("Mainsheet").getLastRowNum();
		for( int i=2;i<=modulecount;i++){
			String modulename = Mxls.getSheet("Mainsheet").getRow(i).getCell(0).getStringCellValue();
			String exestatus = Mxls.getSheet("Mainsheet").getRow(i).getCell(1).getStringCellValue();
			if(exestatus.equalsIgnoreCase("yes")){
				int testcount = Mxls.getSheet(modulename).getLastRowNum();
				for(int j=2;j<=testcount;j++){
					String testid =  Mxls.getSheet(modulename).getRow(j).getCell(0).getStringCellValue();
					String runstatus = Mxls.getSheet(modulename).getRow(j).getCell(1).getStringCellValue();
					ht.put(testid, runstatus);
				}
			}
		}
	}
	public static void CloseBrowser(){
		driver.quit();
		l.info("Browser closed...");
	}
}
//hot key to import packages ---> ctlr+shift+o