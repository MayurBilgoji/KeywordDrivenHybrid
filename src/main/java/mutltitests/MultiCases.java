package mutltitests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import engine.KeywordEngine;
import excelUtils.ExcelUtil;

public class MultiCases 
{
	public KeywordEngine keywordEngine;
	public String ExecuteTest(String testCase,String sheetName)
	{
		ExcelUtil et=new ExcelUtil();
		int startRow = 0;
		int endRow = 0;
		for(int i=0;i<et.GetRowNumber(sheetName);i++)
		{
			if(testCase.equalsIgnoreCase(et.getCellValue(sheetName,0,i)))
			{
				startRow=i;
				System.out.println(startRow);
				break;
			}
				
		}
		
		for(int j=startRow;j<et.GetRowNumber(sheetName);j++)
		{
			if(et.getCellValue(sheetName, 1, j+1).equalsIgnoreCase("TS_1")||et.getCellValue(sheetName, 1, j+1).equals("TESTEND"))
			{
				endRow=j;
				System.out.println(endRow);
				break;
			}
		}
		System.out.println(startRow);
		System.out.println(endRow);
		keywordEngine=new KeywordEngine();
		String currentTestName=et.getCellValue(sheetName,2,startRow);
		System.out.println(currentTestName);
		keywordEngine.startExecution(sheetName, startRow, endRow);
		
		return currentTestName;
		
		
		
	}
	
	
	
	
	
}
