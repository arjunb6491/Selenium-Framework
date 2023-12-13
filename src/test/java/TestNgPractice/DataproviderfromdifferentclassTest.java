package TestNgPractice;

import org.testng.annotations.Test;

public class DataproviderfromdifferentclassTest
{
	@Test(dataProviderClass = Dataprovidertest.class,dataProvider ="data")
	
		public void getData(String src, String dst, int Price)
	{
		System.out.println("From---->"+src+"  To---->"+dst+" price---->"+Price);
		
	}
	
	@Test(dataProviderClass = Dataprovidertest.class,dataProvider ="data1")
	
	public void getData1(String name, String Native, int age)
	{
	System.out.println("Name---->"+name+"  Living---->"+Native+" Age---->"+age);
	
}
}
