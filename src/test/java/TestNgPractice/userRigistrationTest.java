package TestNgPractice;

import org.testng.annotations.Test;

import com.hms.GenericUtility.BaseClass;

public class userRigistrationTest extends BaseClass {
	@Test(groups = {"Smoke"})
	public void RigisterUser()
	{
		System.out.println(".....User(Somke) able in Rigister");
	}
	
	@Test(groups = {"Regression"})
	public void LoginUser()
	{
		System.out.println("----user (Regression) able login---");
	}

}
