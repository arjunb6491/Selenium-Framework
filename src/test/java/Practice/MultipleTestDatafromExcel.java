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

public class MultipleTestDatafromExcel {

	public static void main(String[] args) throws Throwable, IOException {
		int Row=0;

		
			FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData1.xlsx");
			Workbook book = WorkbookFactory.create(fis);
			Sheet bk = book.getSheet("Sheet1");
			int r = book.getSheet("Sheet1").getLastRowNum();
			for(int i=Row;i<=r;i++)
			{
			Row row = bk.getRow(i);
					Cell c = row.getCell(0);
				//	String value = c.getStringCellValue();
					String value = c.toString();
					System.out.println(value);
					
		}

	}

}
