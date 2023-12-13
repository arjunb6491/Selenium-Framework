package com.hms.GenericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	/** This method is used to get the data from Excel
	 *@author Shivamma A 
	 * @param Sheetname
	 * @param rowNo
	 * @param celNo
	 * @return
	 * @throws Throwable
	 */
	public String readDataFromExcel( String Sheetname, int rowNo, int celNo) throws Throwable
	{
		FileInputStream fis = new FileInputStream(Ipathconstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		String value = wb.getSheet(Sheetname).getRow(rowNo).getCell(celNo).getStringCellValue();
		return value;
		
	}
	/** This method is used to store the data in Excel
	 * @author Shivamma A
	 * @param Sheetname
	 * @param rowNo
	 * @param celNo
	 * @param Data
	 * @throws Throwable
	 */
	public void writeDataintoExcel( String Sheetname, int rowNo, int celNo,String Data) throws Throwable
	{
		FileInputStream fi = new FileInputStream(Ipathconstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		 wb.getSheet(Sheetname).createRow(rowNo).createCell(celNo).setCellValue(Data);
		 FileOutputStream fos=new FileOutputStream(Ipathconstants.ExcelPath);
		 wb.write(fos);
		 wb.close();
	}
	/**This method is used to Get last row number in Excel
	 * @author shivamma A
	 * @param SheetName
	 * @return
	 * @throws Throwable
	 */
	public int getLastRowNo(String SheetName) throws Throwable
	{
		FileInputStream fi = new FileInputStream(Ipathconstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		int Count = wb.getSheet(SheetName).getLastRowNum();
		return Count;
	}
	public HashMap<String,String> getMultipleDataFromExcel(String Sheetname, int keyCelNo, int Valuecelno) throws Throwable
	{
		FileInputStream fi = new FileInputStream(Ipathconstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(Sheetname);
		int Count = sh.getLastRowNum();
		HashMap<String, String> map = new HashMap<String, String>();
		for(int i=0; i<=Count; i++)
		{
			String Key = sh.getRow(i).getCell(keyCelNo).getStringCellValue();
			
			String value = sh.getRow(i).getCell(Valuecelno).getStringCellValue();
			map.put(Key, value);
		}
		return map;
	}
	
	public  Object[][]getDatafromDataProvider(String Sheetname) throws Throwable
	{
		FileInputStream fis= new FileInputStream(Ipathconstants.ExcelPath);
		Workbook Book = WorkbookFactory.create(fis);
		Sheet sh = Book.getSheet(Sheetname);
		int lastRow = sh.getLastRowNum()+1;
		int lastCell = sh.getRow(0).getLastCellNum();
		Object[][] Obj = new Object[lastRow][lastCell];
		for (int i = 0; i <lastRow; i++) 
		{
			for (int j = 0; j <lastCell; j++)
			{
				Obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
				
				
			}
			
		}
		return Obj;			
	}

	

}
