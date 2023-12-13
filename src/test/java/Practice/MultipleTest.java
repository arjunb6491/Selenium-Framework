package Practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class MultipleTest {

	public static void main(String[] args) throws Throwable, IOException {

		
			FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
			Workbook book = WorkbookFactory.create(fis);
			Sheet bk = book.getSheet("Sheet5");
			Sheet sh = book.getSheet("Sheet5");
			int r = book.getSheet("Sheet5").getLastRowNum();
			int cellnum = book.getSheet("Sheet5").getRow(r).getLastCellNum();
			for(int i=0;i<=r;i++)
			{
				
				Row row;
				for(int j=0;j<=cellnum;j++)
				{
			     row  = sh.getRow(i);
				Cell c = row.getCell(j);
				//	String value = c.getStringCellValue();
					String value = c.toString();
					System.out.println(value);
					
		}

	}

}}