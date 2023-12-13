package TestNgPractice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dataprovidertest {
	
	@Test(dataProvider = "data")
	public void getData(String src, String dst, int Price)
	{
		System.out.println("From---->"+src+"  To---->"+dst+" price---->"+Price);
	}
	
	
	@DataProvider
	public Object[][] data()
	{
		Object [][] obj=new Object[2][3];
		obj[0][0]="Banglore";
		obj[0][1]="Rajajinagara";
		obj[0][2]=400;
		
		
		obj[1][0]="pune";
		obj[1][1]="chennai";
		obj[1][2]=400;
		return obj;
		
		
	}
	@DataProvider
	public Object[][] data1()
	{
		Object[][] obj= new Object[3][3];
		
		obj[0][0]="Chethan";
		obj[0][1]="Nelamangala";
		obj[0][2]=34;
		
		
		obj[1][0]="shivamma";
		obj[1][1]="Challakere";
		obj[1][2]=32;
		
		obj[2][0]="Aishani Chethan";
		obj[2][1]="Banglore";
		obj[2][2]=4;
		return obj;
	
	}

}
