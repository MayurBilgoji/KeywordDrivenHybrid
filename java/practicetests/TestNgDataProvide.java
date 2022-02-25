package practicetests;

import java.util.ArrayList;

public class TestNgDataProvide 
{
  public static String[][] sendData()
  
  {   
	  String a="Test ID";
      String b="1";
      String c="8";
      String d="Test ID";
      String e="9";
      String f="14";
      String g="Test ID";
      String h="15";
   //   String i="23";
    		  
  /* ArrayList<String> list=new ArrayList<String>();
     list.add("Test ID");
     list.add("1");
     list.add("8");
     list.add("Test ID");
     list.add("9");
     list.add("8");*/
      
     int NumberOfTestCases=3;
     String[][] str=new String[NumberOfTestCases][4];
     
     for(int i=0;i<NumberOfTestCases;i++)
     {
    	 for(int j=0;j<4;j++)
    	 {
    		 str[i][j]="TestID";
    	 }
     }
      
     System.out.println(str);
      
	  //String[][] srt=  {{"Test ID","1","8"},{"Test ID","9","14"},{"Test ID","15","23"}};
	  return str;
  }
	
}
