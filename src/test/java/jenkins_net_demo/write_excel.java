package jenkins_net_demo;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class write_excel {

	
	
	
	public void writeExcel(String filePath,String fileName,String sheetName,String[] dataToWrite) throws IOException{
		//Create an object of File class to open xlsx file
		File file =    new File(filePath+"\\"+fileName);
		//Create an object of FileInputStream class to read excel file
		FileInputStream inputStream = new FileInputStream(file);
		Workbook guru99Workbook = null;
		//Find the file extension by splitting  file name in substring and getting only extension name
		String fileExtensionName = fileName.substring(fileName.indexOf("."));
		//Check condition if the file is xlsx file
		if(fileExtensionName.equals(".xlsx")){
		//If it is xlsx file then create object of XSSFWorkbook class
		guru99Workbook = new XSSFWorkbook(inputStream);
		}

		//Check condition if the file is xls file
		else if(fileExtensionName.equals(".xls")){
		//If it is xls file then create object of XSSFWorkbook class
		guru99Workbook = new HSSFWorkbook(inputStream);
		}  
		//Read excel sheet by sheet name    
		Sheet sheet = guru99Workbook.getSheet(sheetName);
		//Get the current count of rows in excel file
		int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
		//Get the first row from the sheet
		Row row = sheet.getRow(0);
		//Create a new row and append it at last of sheet
		Row newRow = sheet.createRow(rowCount+1);
		//Create a loop over the cell of newly created Row
		for(int j = 0; j < row.getLastCellNum(); j++){
		//Fill data in row
		Cell cell = newRow.createCell(j);
		cell.setCellValue(dataToWrite[j]);
		}
		//Close input stream
		inputStream.close();
		//Create an object of FileOutputStream class to create write data in excel file
		FileOutputStream outputStream = new FileOutputStream(file);
		//write data in the excel file
		guru99Workbook.write(outputStream);
		//close output stream
		outputStream.close();
		}
	
	
	
	
}

	
	
	
	
	
	
	
	
	
	
	
//	
//	public void writedata(ArrayList<String> email,ArrayList<String> password)
//	{
//		 XSSFWorkbook workbook = new XSSFWorkbook();
//		 
//		 XSSFSheet sheet = workbook.createSheet("NetFlix");
//		    Object[][] bookData = {
//	                {email,password},
//	        };
//	 
//	        int rowCount = 0;
//	         
//	        for (Object[] aBook : bookData) {
//	            Row row = sheet.createRow(++rowCount);
//	             
//	            int columnCount = 0;
//	             
//	            for (Object field : aBook) {
//	                Cell cell = row.createCell(++columnCount);
//	                if (field instanceof String) {
//	                    cell.setCellValue((String) field);
//	                } else if (field instanceof Integer) {
//	                    cell.setCellValue((Integer) field);
//	                }
//	            }
//	             
//	        }
//	         
//	         
//	        try 
//	        {
//	        	FileOutputStream outputStream = new FileOutputStream("D:\\Sheet\\JavaBooks.xlsx");
//	        	workbook.write(outputStream);
//	        }
//	        catch(Exception e)
//	        {
//	        	e.getStackTrace();
//	        }
		
		
		
		
		
		
		
		
		
//	}
//	
//	
//	
//	
//	
//
//}
