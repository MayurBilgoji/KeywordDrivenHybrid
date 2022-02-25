package engine;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import base.Base;
import excelUtils.ExcelUtil;
import utility.Helper;

public class KeywordEngine 
{
	
	//public WebDriver driver;
	public Properties prop;
	//public static Workbook book;
	public XSSFWorkbook workbook;
	//public static Sheet sheet;
	public XSSFSheet sheet;
	public Base base;
	public WebElement element;
	public static WebDriver driver;
    
	public final String SCENARIO_SHEET_PATH="C:\\Users\\Asus\\eclipse-workspace\\JPG\\src\\main\\java\\scenarios\\JPGKeywordTests.xlsx";
    

	
	public void startExecution(String sheetName)
	{
		String LocatorType=null;
		String LocatorValue=null;
		FileInputStream fiss=null;
		try {
			fiss=new FileInputStream("C:\\Users\\Asus\\eclipse-workspace\\JPG\\src\\main\\java\\scenarios\\JPGKeywordTests.xlsx");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			//book=WorkbookFactory.create(fiss);
		    workbook = new XSSFWorkbook(fiss);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sheet=workbook.getSheet(sheetName);
		int k=0;
		System.out.println("Getting row data");
		for(int i=0;i<sheet.getLastRowNum()-1;i++)
		{
			 System.out.println(sheet.getRow(i+1).getCell(k+4));
			 LocatorType=sheet.getRow(i+1).getCell(k+4).toString().trim();
			 System.out.println("LocatorType is "+LocatorType);
			 LocatorValue=sheet.getRow(i+1).getCell(k+5).toString().trim();
			 System.out.println("LocatorValue is "+LocatorValue);
			 
			 String actionKeyword=sheet.getRow(i+1).getCell(k+6).toString().trim();
			 System.out.println("ActionKeyword is "+actionKeyword);
			 String value=sheet.getRow(i+1).getCell(k+7).toString().trim();
			 System.out.println("Value is "+value);
			 
			switch (actionKeyword) 
			{
			case "openBrowser":
				base=new Base();
				prop=base.init_properties();
				if(value.isEmpty()||value.equals("NA"))
				{
					driver=base.init_driver(prop.getProperty("browserName"));
				}
				else
				{
					driver=base.init_driver(value);
				}
				System.out.println("Browser Launched");
				break;
			case "getUrl":
				if(value.isEmpty()||value.equals("NA"))
				{
					driver.get(prop.getProperty("EnterURL"));
				}
				else
				{
					System.out.println("getting Url "+ value);
					/*try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}*/
					driver.get(value);
				}
				System.out.println("URL entered");
				break;
			case "quit"	:
				driver.quit();
				System.out.println("Browser closed");
		        break;
			case "checkTitle":
				String title=driver.getTitle();
				Assert.assertEquals(title, value);	
		        break;
			case "wait":
				  try {
					Thread.sleep(3000);
				} catch (InterruptedException e1)
				  {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}				
				  break;
	        
			default:
				break;
			}
			
			switch (LocatorType) {
			case "id":
				 element=driver.findElement(By.id(LocatorValue));
				if(actionKeyword.equalsIgnoreCase("sendKeys"))
				{   element.clear();
					element.sendKeys(value);
				}
				else if(actionKeyword.equalsIgnoreCase("Click"))
				{
					element.click();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				LocatorType=null;
				
				break;
				
			case "linkText":
				 element=driver.findElement(By.linkText(LocatorValue));
				 element.click();
				 LocatorType=null;
				 
			case "xpath":
				 element=driver.findElement(By.xpath(LocatorValue));
				if(actionKeyword.equalsIgnoreCase("sendKeys"))
				{   element.clear();
					element.sendKeys(value);
				}
				else if(actionKeyword.equalsIgnoreCase("Click"))
				{
					element.click();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				else if(actionKeyword.equalsIgnoreCase("verifyText"))
				{
					String text=element.getText();
					Assert.assertEquals(text, value);
				}
				LocatorType=null;
				break;

		default:
			break;
			}
		}

	
    }	
	
	
	//===============================Mutlitests in one sheet code start===============================================
	
	
	
	
	public void startExecution(String sheetName,int startRow,int endRow)
	
	{
		
		String LocatorType=null;
		
		String LocatorValue=null;
	
		//sheet=workbook.getSheet(sheetName);
		int k=0;
		System.out.println("Getting row data");
		for(int i=startRow;i<endRow+1;i++)
		{    ExcelUtil et=new ExcelUtil();
			// System.out.println(sheet.getRow(i+1).getCell(k+4));
			 LocatorType=et.getCellValue(sheetName,(k+4),i);
			 System.out.println("LocatorType is "+LocatorType);
			 LocatorValue=et.getCellValue(sheetName,(k+5),i);
			 System.out.println("LocatorValue is "+LocatorValue);
			 
			 //String actionKeyword=sheet.getRow(i+1).getCell(k+6).toString().trim();
			 String actionKeyword=et.getCellValue(sheetName,(k+6), (i));
			 System.out.println("ActionKeyword is "+actionKeyword);
			 //String value=sheet.getRow(i+1).getCell(k+7).toString().trim();
			 String value=et.getCellValue(sheetName, (k+7), (i));
			 System.out.println("Value is "+value);
			 
			 
			 
			switch (actionKeyword) 
			{
			case "openBrowser":
				base=new Base();
				prop=base.init_properties();
				if(value.isEmpty()||value.equals("NA"))
				{
					driver=base.init_driver(prop.getProperty("browserName"));
				}
				else
				{
					driver=base.init_driver(value);
				}
				System.out.println("Browser Launched");
				break;
			case "getUrl":
				if(value.isEmpty()||value.equals("NA"))
				{
					driver.get(prop.getProperty("EnterURL"));
				}
				else
				{
					System.out.println("getting Url "+ value);
					/*try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}*/
					driver.get(value);
				}
				System.out.println("URL entered");
				break;
			case "quit"	:
				driver.quit();
				System.out.println("Browser closed");
		        break;
			case "checkTitle":
				String title=driver.getTitle();
				Assert.assertEquals(title, value);	
		        break;
			case "wait":
				  try {
					Thread.sleep(3000);
				} catch (InterruptedException e1)
				  {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}				
				  break;
	        
			default:
				break;
			}
			
			switch (LocatorType) {
			case "id":
				 element=driver.findElement(By.id(LocatorValue));
				if(actionKeyword.equalsIgnoreCase("sendKeys"))
				{   element.clear();
					element.sendKeys(value);
				}
				else if(actionKeyword.equalsIgnoreCase("Click"))
				{
					element.click();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				LocatorType=null;
				
				break;
				
			case "linkText":
				 element=driver.findElement(By.linkText(LocatorValue));
				 element.click();
				 LocatorType=null;
				 
			case "xpath":
				 element=driver.findElement(By.xpath(LocatorValue));
				if(actionKeyword.equalsIgnoreCase("sendKeys"))
				{   element.clear();
					element.sendKeys(value);
				}
				else if(actionKeyword.equalsIgnoreCase("Click"))
				{
					element.click();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				else if(actionKeyword.equalsIgnoreCase("verifyText"))
				{
					String text=element.getText();
					Assert.assertEquals(text, value);
				}
				LocatorType=null;
				break;

		default:
			break;
			}
		}
		
		
		
		
		
	}
	
	//==================================MultiTests in one sheet end=======================================
	
	public static String captureScreenshot() 
	{
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String screenshotPath = System.getProperty("user.dir") + "/Screenshots/JPG" + Helper.getCurrentDateTime() + ".png";

		try {

			FileHandler.copy(src, new File(screenshotPath));
		    }
		catch (IOException e) 
		{
			System.out.println("Unable to capture screenshot" + e.getMessage());
		}
		return screenshotPath;
	}
	
	public static void closeBrowser()
	{
		driver.close();
	}
	

	


}
