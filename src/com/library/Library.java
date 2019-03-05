package com.library;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import com.testBase.TestBase;

public class Library extends TestBase {
	
	public static void login(){
		driver.findElement(By.xpath(prop.getProperty("username"))).sendKeys("admin");
	    l.info("username is entered");
		driver.findElement(By.xpath(prop.getProperty("password"))).sendKeys("manager");
		l.info("password is entered");
		driver.findElement(By.xpath(prop.getProperty("loginnow"))).click();
		l.info("clicked on login button");
	}
	
	public static void clickontask(){
		driver.findElement(By.xpath(prop.getProperty("task"))).click();
		l.info("clicked on task ");
	}
	
	public static void clickonproandcustomer(){
		driver.findElement(By.xpath(prop.getProperty("gotoproandcustomer"))).click();
		l.info("clicked on proandcustomer ");
	}
	public static void clickoncreatenewcustomer(){
		driver.findElement(By.xpath(prop.getProperty("createnewcustomer"))).click();
		l.info("clicked on createnewcustomer ");
	}
	public static void clickoncreatenewproject(){
		driver.findElement(By.xpath(prop.getProperty("createnewproject"))).click();
		l.info("clicked on createnewproject ");
	}
	
	public static void createcustomer(String cname,String cdesc,String cradio){
		driver.findElement(By.xpath(prop.getProperty("Entercustomer"))).sendKeys(cname);
		l.info("Entered customer name as "+cname);
		driver.findElement(By.xpath(prop.getProperty("EntercustomerDescripion"))).sendKeys(cdesc);
		l.info("Entered customer description as "+cdesc);
		driver.findElement(By.xpath(prop.getProperty(cradio))).click();
		l.info("Selected "+cradio);
		driver.findElement(By.xpath(prop.getProperty("createcustomer"))).click();
		l.info("clicked on createcutomer button");
	}

	public static void createproject(String cname,String pname,String pdesc,String pradio){
		driver.findElement(By.xpath(prop.getProperty("select"))).sendKeys(cname);
		l.info("selected "+cname);
		driver.findElement(By.xpath(prop.getProperty("Enterproject"))).sendKeys(pname);
		l.info("Entered project name as "+pname);
		driver.findElement(By.xpath(prop.getProperty("Enterprojectdescription"))).sendKeys(pdesc);
		l.info("Entered project description as "+pdesc);
		driver.findElement(By.xpath(prop.getProperty(pradio))).click();
		l.info("Selected radio button as "+pradio);
		driver.findElement(By.xpath(prop.getProperty("createproject"))).click();
		l.info("clicked on createproject button");
	}
	
	public static void verifysucessmsg() throws Throwable{
		try{
			driver.findElement(By.xpath(prop.getProperty("successmsg"))).isDisplayed();
			l.info("Success msg displayed...");
			File  srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(srcFile,new File(".\\src\\com\\screenshots\\Test"+(tc=tc+1)+"_Pass.png"));
			driver.findElement(By.xpath(prop.getProperty("logout"))).click();//logout
			l.info("Clicked on logout");
			}catch(Throwable t){
				File  srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileHandler.copy(srcFile,new File(".\\src\\com\\screenshots\\Test"+(tc=tc+1)+"_Fail.png"));
				st.fail("Sucess msg does not displayed...");
				l.info("Success msg does not displayed...");
				driver.findElement(By.xpath(prop.getProperty("logout"))).click();//logout
				l.info("Clicked on logout");
				driver.findElement(By.xpath(prop.getProperty("cancelcustomercreation"))).click();//cancel creation
				l.info("Clicked on cancel creation");
				
			}
	}
	
	public static void assertall(){
		l.info("Executed assertall statement");
		st.assertAll();
	}
}

//driver.findElement(By.xpath(prop.getProperty("")))