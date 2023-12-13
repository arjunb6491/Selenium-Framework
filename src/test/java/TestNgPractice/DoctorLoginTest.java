package TestNgPractice;

import org.testng.annotations.Test;

import com.hms.GenericUtility.BaseClass;

public class DoctorLoginTest extends BaseClass {
	@Test(groups = {"Smoke"})
	public void LoginasDoctors()
	{
		System.out.println("---loggedin successfully as a Doctores");
	}
	@Test(priority = 2)
	public void LogoutasDoctors()
	{
		System.out.println("---loggedout successfully as a Doctores");
	}

}
