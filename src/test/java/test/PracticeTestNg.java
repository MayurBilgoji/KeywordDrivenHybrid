package test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import practicetests.TestNgDataProvide;

public class PracticeTestNg 
{
	TestNgDataProvide testdata=null;

	@Test(dataProvider="ProvideData")
	public void Testss(String name,String Start,String End)
	{
		System.out.println(name+","+Start+","+End);
	}
     @DataProvider
     public Object[][] ProvideData() throws Exception
	  {
		    System.out.println("Data providing to test");
	        //Object[][] obj=testdata.sendData();
		    Object[][] obj=TestNgDataProvide.sendData();
		    	
		    		//new Object[][]
		    		//{
		    	   //     {"Test ID","1","8"},{"Test ID","9","14"}
		    		//};
			return obj;
	  }
     
     @AfterMethod
     public void After()
     {
    	 System.out.println("After method executed");
     }
     
     
     
     
}
