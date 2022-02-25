package test;

import java.io.FileInputStream;

import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.thread.ITestNGThreadPoolExecutor;

public class MultiTest 
{
	
	/*@Test(dataProvider="ProvideData")
	public void TestExecution(String testname,int startRow,int endRow)
	{
		System.out.print(testname);
		System.out.print(startRow);
		System.out.print(endRow);
	}
	 @DataProvider
     public Object[][] ProvideData() throws Exception
	  {
		    System.out.println("Data providing to test");
	        Object[][] obj=new Object[][]
	   			{
		         {"JPTests1",1,4},{"JPTests2",5,8},{"JPTests3",9,15}
			    };
			return obj;
	  }*/
	 final int x=5;
	 @Test(invocationCount=x)
	 public void NewTest(ITestContext testContext)
	 {   
		String sheetname="sheet";
		int count= testContext.getAllTestMethods()[0].getCurrentInvocationCount();
		System.out.println(count);
		
		testExecutor(count,sheetname);
		/*if(count==0)
		{
			 System.out.println("1St");
		//	TestExecutor(String SheetName,int start,int end)
		}
		else if(count==1)
		{
			 System.out.println("2St");
		}
		else if(count==2)
		{
			 System.out.println("3St");
		}
		else if(count==3)
		{
			 System.out.println("4St");
		}
		else if(count==4)
		{
			 System.out.println("5St");
		}
		*/
		
		
		 
	 }
	 
	 @Test(invocationCount=5)
	 public void NewTest2(ITestContext testContext)
	 {   
		String sheetname="sheet2";
		int count= testContext.getAllTestMethods()[1].getCurrentInvocationCount();
		System.out.println(count);
		
		testExecutor(count,sheetname);
		/*if(count==0)
		{
			 System.out.println("1St");
		//	TestExecutor(String SheetName,int start,int end)
		}
		else if(count==1)
		{
			 System.out.println("2St");
		}
		else if(count==2)
		{
			 System.out.println("3St");
		}
		else if(count==3)
		{
			 System.out.println("4St");
		}
		else if(count==4)
		{
			 System.out.println("5St");
		}*/
	 }
	 
	 
	 
	 @Test
	 public void tc_1()
	 {   String TC_1;
		 ExecuteTest(TC_1);
		 for(int i=0;i<lastrow;i++)
		 {
			 if(row.equals(TC_1)
			  int row=i;
			  break;
		 }
		 String TestCase=getcellValueat(i)
				 for(int k=row;k<lastrow;k++)
				 {
					 if(row.equals(TC_1)||row.equlas null)
						 end row=k-1;
						 
				 }
		 startExecution(Testcase,row,end);
	 }
	 
	  
	 @AfterMethod
	 public void tearDown()
	 {
		 System.out.println("After Method Executed");
	 }
	 
	 public void testExecutor(int row,String sheet)
	 {
		 System.out.println((row+1)+sheet);
		 //SheetName
		 //getstartrow
		 //getEndRow
		 //TestExecutor(Sheetname,startRow,EndRow);
		 
	 }
}
