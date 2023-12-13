package TestNgPractice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestAnnotationbyTwoTest {
		
		@BeforeSuite 
		public void configu_BS()
		{
			System.out.println("---Connect to Database---");
		}
		@BeforeClass
		public void Configu_BC()
		{
			System.out.println("---Launch the Browsewr----");
		}
		@BeforeMethod
		public void Configu_BM()
		{
			System.out.println("---Open the Application");
		}
		@Test
		public void LoginAsAdmin() {
			System.out.println("---Logged in Successfully---");
		}
		@AfterMethod
		public void Configu_AM()
		{
			System.out.println("---Logout from the Application");
		}
		@AfterClass
		public void Configu_AC()
		{
			System.out.println("----close the Browser---");
		}
		@AfterSuite
		public void Configu_AS()
		{
			System.out.println("---Disconnect from Database...");
		}
		@Test
		public void Loginasuser()
		{
			System.out.println("----Successfully logged in as User---");
		}
		

	}



