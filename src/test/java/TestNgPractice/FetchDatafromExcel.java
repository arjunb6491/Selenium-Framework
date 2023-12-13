package TestNgPractice;

import java.awt.print.Book;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.remote.NewSessionPayload;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hms.GenericUtility.Ipathconstants;

public class FetchDatafromExcel {
	@Test(dataProvider ="getDatafromExcel" )
	public void fetchData(String name, String Loc)
	{
		System.out.println("name--->"+name+"Answer-->"+Loc);
	}
	
	@DataProvider
	public  Object[][]getDatafromExcel() throws Throwable
	{
		FileInputStream fis= new FileInputStream(Ipathconstants.ExcelPath);
		Workbook Book = WorkbookFactory.create(fis);
		Sheet sh = Book.getSheet("Data");
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
