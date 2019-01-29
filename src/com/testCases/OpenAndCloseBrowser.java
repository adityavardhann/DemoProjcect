package com.testCases;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.testBase.TestBase;

public class OpenAndCloseBrowser extends TestBase{
	@BeforeSuite
	public void bsuite() throws Throwable{
		OpenBrowser();
		moduledriver();
	}
	@AfterSuite
	public void asuite(){
		CloseBrowser();
	}
}
