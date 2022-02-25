package excelUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import base.Base;

public class ExcelUtil 
{
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public Base base;
	
	public int GetRowNumber(String sheetName)
	{
		
		FileInputStream fiss=null;
		try {
			fiss=new FileInputStream("C:\\Users\\Asus\\Desktop\\MultiTestSheet.xlsx");
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
		int lastRow=sheet.getLastRowNum();
		return lastRow;
		
	}
	
	public String getCellValue(String sheetName,int col,int row)
	{

		FileInputStream fiss=null;
		try {
			fiss=new FileInputStream("C:\\Users\\Asus\\Desktop\\MultiTestSheet.xlsx");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
	
				workbook = new XSSFWorkbook(fiss);
			
		}
		 catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sheet=workbook.getSheet(sheetName);
		int lastRow=sheet.getLastRowNum();
		XSSFCell cell=sheet.getRow(row).getCell(col);
		if(cell!=null)
		{
			String cellValue=cell.toString().trim();
			return cellValue;
		}
		else
		  return "NA";
	}
    
}
