package TestNgPractice;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hms.GenericUtility.ExcelUtility;

public class DPGeneric_Test {
	@Test(dataProvider = "GenericData")
	public void exceldata(String name, String Loc)
	{
		System.out.println("name--->"+name+"Answer-->"+Loc);
	}

	@Test(dataProvider = "GenericMData")
	public void excelMdata(String name, String Loc, String Org)
	{
		System.out.println("name--->"+name+"Answer-->"+Loc+"Org---->"+Org);
	}
	@DataProvider
	public Object[][] GenericData() throws Throwable
	{
		ExcelUtility elib= new ExcelUtility();
		Object[][] value = elib.getDatafromDataProvider("Data");
		return value;
				
	}
	@DataProvider
	public Object[][] GenericMData() throws Throwable
	{
		ExcelUtility elib= new ExcelUtility();
		Object[][] value = elib.getDatafromDataProvider("Mdata");
		return value;
				
	}
}
