package practicetests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GetTotalNumberOfTestCases 
{

	public static void main(String[] args) 
	{
		  FileInputStream fis=null;
		  XSSFWorkbook  workbook=null;
		  XSSFSheet sheet;
		// TODO Auto-generated method stub
		try {
			   fis=new FileInputStream("C:\\Users\\Asus\\eclipse-workspace\\JPG\\src\\main\\java\\scenarios\\JPGKeywordTests.xlsx");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			 workbook = new XSSFWorkbook(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//	int NumberofSheets=workbook.getNumberOfSheets();
		int NumberofTests=0;
		//for(int i=0;i<NumberofSheets;i++)
		
			sheet=workbook.getSheetAt(0);
			int k=1;
			for(int j=0;j<sheet.getLastRowNum();j++)
			{ 
				String CellValue=sheet.getRow(j).getCell(k).toString().trim();
				if(CellValue.equals("TS_01"))
				{ 
					NumberofTests=NumberofTests+1;
			        String testname=sheet.getRow(j).getCell(k+1).toString();
			        System.out.println(testname);
					System.out.println("Test starts at "+j);
					for(int m=j+1;m<sheet.getLastRowNum();m++)
					{
						if(sheet.getRow(m).getCell(k).toString().trim().equals("TS_01"))
						{
							System.out.println(testname+"Ends at"+ (m-1));
						}
						else if(sheet.getRow(m).getCell(k).toString().trim().isEmpty()||sheet.getRow(m).getCell(k).toString().trim().isBlank())
						{
							System.out.println(testname+"Ends at"+sheet.getLastRowNum());
						}
					}
				}
		
			}
		/*	for(int j=2;j<sheet.getLastRowNum();j++)
			{ 
				String CellValue=sheet.getRow(j).getCell(k).toString().trim();
				if(CellValue.equals("TS_01"))
				{ 
					//NumberofTests=NumberofTests+1;
			       // String testname=sheet.getRow(j).getCell(k+1).toString();
			       // System.out.println(testname);
					System.out.println("Test ends at"+ (j-1));
				}
				else if(CellValue.equals(null)||CellValue.isEmpty())
				{
					System.out.println("Test ends at"+ sheet.getLastRowNum());
				}
			}*/
			
		System.out.println(NumberofTests);
	}

	
}
