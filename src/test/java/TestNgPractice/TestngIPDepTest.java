package TestNgPractice;

import org.testng.annotations.Test;

public class TestngIPDepTest {
	@Test(dependsOnMethods = "deletedata")
	public void createdata(){
		System.out.println("...Create Data...");
	}
	 
	@Test(priority = 1 )
	public void editdata()
	{
		System.out.println("...editdata...");
	}
	@Test(priority = 2)
	public void deletedata()
	{
		System.out.println("...deletedata...");
	}	
		
	}


