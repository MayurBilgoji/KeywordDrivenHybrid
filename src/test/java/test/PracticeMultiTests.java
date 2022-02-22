package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class PracticeMultiTests {
	public static ArrayList<Integer> list=null;

	public static void main(String[] args) throws IOException 
	{
		// TODO Auto-generated method stub
		String sheetName="TestSheet1";
		
		FileInputStream fiss=new FileInputStream("C:\\Users\\Asus\\Desktop\\MultiTestSheet.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fiss);
		XSSFSheet sheet=workbook.getSheet(sheetName);
		int k=0;
		System.out.println("Getting row data");
		int count=0;
		list=new ArrayList<Integer>();
		for(int i=0;i<sheet.getLastRowNum();i++)
		{
			String ss=sheet.getRow(i+1).getCell(k+1).toString().trim();
	        if(ss.equals("TS_1")||ss.equals("TS_END"))
	        {   System.out.println("New test start at "+(i+1));
	          list.add(i+1);
	          count++;	
	       
	  		
	        }
		    	
		}
		System.out.println("Number of tests" +(count-1));
		System.out.println(list);
		
		for(int i=0;i<3;i++)
		{  
		    int start=list.get(i);
		    String sk=sheet.getRow(start).getCell(k+2).toString().trim();
			System.out.println(start);
			System.out.println(sk);
		    int End=list.get(i+1)-1 ;
			System.out.println(End);
			//Object[i][3]= {start,sk,End};
			//Write this data into csv or excel file and read from dataprovider
			
		}
		
		

	}

}
