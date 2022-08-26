package com.adi.test;
 
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
 
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
 
public class ExcelSheetReader {
 
	private String FILE="";
	
	ExcelSheetReader(String file){
		this.FILE=file;
	}
	
	
    public  String GetData(String Type,int col, int row)  {
        //
        // An excel file name. You can create a file name with a full
        // path information.
        //
        String filename = FILE;
 
        //
        // Create an ArrayList to store the data read from excel sheet.
        //
       
        FileInputStream fis = null;
        try {
            //
            // Create a FileInputStream that will be use to read the
            // excel file.
            //
            fis = new FileInputStream(filename);
 
            //
            // Create an excel workbook from the file system.
            //
            HSSFWorkbook workbook = new HSSFWorkbook(fis);
            //
            // Get the first sheet on the workbook.
            //
            HSSFSheet sheet = workbook.getSheetAt(0);
            
            HSSFRow Row = sheet.getRow(row);
            HSSFCell Cell = Row.getCell((short)col);
            
            if(Type.equals("String"))
            {
            	return Cell.getStringCellValue();
            
            }
            if(Type.equals("Int"))
            {
            	
            	int x = (int) Cell.getNumericCellValue();
            	return String.valueOf(x);
            }       
            
          
            
            
            
        }
        catch(Exception ex){
        	ex.printStackTrace();
        }
 
 return null;      
    }
 
  
}