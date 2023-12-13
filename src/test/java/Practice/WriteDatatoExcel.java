package Practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDatatoExcel {

	public static void main(String[] args) throws Throwable, IOException {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet("Sheet2");
		Row r = sh.createRow(0);
		Cell c = r.createCell(1);
		c.setCellValue("shivamma");
	FileOutputStream fos = new FileOutputStream(".\\\\src\\\\test\\\\resources\\\\TestData.xlsx");
	book.write(fos);
		
		
		

	}

}
