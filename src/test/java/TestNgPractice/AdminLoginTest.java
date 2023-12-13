package TestNgPractice;

import org.testng.annotations.Test;

import com.hms.GenericUtility.BaseClass;

public class AdminLoginTest extends BaseClass {
	@Test(groups = {"Smoke"})
	public void LoginasAdmin()
	{
	System.out.println("----(Smoke1AdminSuccessfully Logged in");
	}
	
@Test(groups = {"Regression"})
public void LogoutasAdmin()
{
	System.out.println("----Admin Regration  Successfully logged out");
}
}
