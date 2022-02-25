package test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import base.Base;
import engine.KeywordEngine;
import excelUtils.ExcelUtil;
import mutltitests.MultiCases;
import utility.Helper;

public class Tests
{
	
	 public KeywordEngine keywordEngine;
	 public ExtentReports report;
	 public ExtentTest logger;
	 public  WebDriver driver;
	
	 
	 
	@BeforeSuite
	public void setUp()
	{
	 System.out.println("Before Suite executed");
	 ExtentHtmlReporter extent=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/JPG"+Helper.getCurrentDateTime()+".html"));
	 report=new ExtentReports();
	 report.attachReporter(extent);

	}
	
  
	/*@Test (dataProvider="ProvideDataToTest")
	 public void TestExecutor(String sheetName) throws InterruptedException
	 {  
		 logger=report.createTest(sheetName+"Testsssssssssss validate");
         System.out.println("Test method");
		 keywordEngine= new KeywordEngine();
		 keywordEngine.startExecution(sheetName);
		 logger.info("starting application");
		 logger.info("Test executed success "+sheetName);
		 
	 }
	 
	 @DataProvider
     public Object[][] ProvideDataToTest() throws Exception
	  {
		    System.out.println("Data providing to test");
	        Object[][] obj=new Object[][]
	   			{
		         {"JPTests1"},{"JPTests2"},{"JPTests3"}
			    };
			return obj;
	  }
	 */
	 
	 
	 @Test
	 public void tc_1()
	 {  
		 String testcase="TC_1";
		 logger=report.createTest(testcase);
	     String sheetName="TestSheet1";
	     ExcelUtil eu=new ExcelUtil();
		 MultiCases mcs=new MultiCases();
		 String testname=mcs.ExecuteTest(testcase,sheetName); 
		 logger.info("Test executed success "+testname);
	 }
	 
	 @Test
	 public void tc_2()
	 {  
		 String testcase="TC_2";
		 logger=report.createTest(testcase);
	     String sheetName="TestSheet1";
		 MultiCases mcs=new MultiCases();
		 String testname= mcs.ExecuteTest(testcase,sheetName); 
		 logger.info("Test executed success "+testname);

	 }
	 
	 @Test
	 public void tc_3()
	 {  
		 String testcase="TC_3";
		 logger=report.createTest(testcase);
	     String sheetName="TestSheet1";
		 MultiCases mcs=new MultiCases();
		 String testname= mcs.ExecuteTest(testcase,sheetName); 
		 logger.info("Test executed success "+testname);

	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 @AfterMethod
	 public void TearDown(ITestResult result) throws IOException
	 {  
		 
		 System.out.println("After Method executing");
		if(result.getStatus()==ITestResult.FAILURE)
		 {
			
			 logger.fail("Test Failed",MediaEntityBuilder.createScreenCaptureFromPath(KeywordEngine.captureScreenshot()).build());
			 logger.fail("Test Failed");
		 }
		 else if(result.getStatus()==ITestResult.SUCCESS)
		 {
			 logger.pass("Test Passed",MediaEntityBuilder.createScreenCaptureFromPath(KeywordEngine.captureScreenshot()).build());
			 logger.pass("Test Passed");
		 }
		 
		 report.flush();
		// driver.close();
		// KeywordEngine.closeBrowser();
	 }
	 
	 

}
