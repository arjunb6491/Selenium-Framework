package com.hms.Objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static org.testng.Assert.*;

public class UserLoginpage {
	@FindBy(xpath="//a[@href='registration.php']")
	private WebElement CreateAcclink;
	
	@FindBy(name="username")
	private WebElement USERNAME;
	
	@FindBy(name="password")
	private WebElement PASSWORD;
	
	@FindBy(name="submit")
	private WebElement SUMBIT;
	@FindBy(linkText="Log-in")
	private WebElement Loginlink;
	
	public UserLoginpage(WebDriver driver)
	{
		PageFactory.initElements( driver, this);
	}

	public WebElement getCreateAcclink() {
		return CreateAcclink;
	}

	public WebElement getUSERNAME() {
		return USERNAME;
	}

	public WebElement getPASSWORD() {
		return PASSWORD;
	}

	public WebElement getSUMBIT() {
		return SUMBIT;
	}
	
	public WebElement getLoginlink() {
		return Loginlink;
	}

	public void CreateAcclink() {
		CreateAcclink.click();
	}
		
		
		public void Userlogin(String Email, String Password) {
			Loginlink.click();
			USERNAME.sendKeys(Email);
			PASSWORD.sendKeys(Password);
			SUMBIT.click();
			
	}
		
		public void Patientloginfrommain(String Email, String Password) {
			//Loginlink.click();
			USERNAME.sendKeys(Email);
			PASSWORD.sendKeys(Password);
			SUMBIT.click();
			
	}
	public void UserloginInfo(WebDriver driver)
	{
		String Expected = ("USER | DASHBOARD");
		WebElement ele = driver.findElement(By.xpath("//h1[text()='User | Dashboard']"));
		String actual = ele.getText();
		
		assertEquals(actual, Expected);
//		if(actual.contains(Expected))
//		{
//			System.out.println("User ableto login Successfully");
//		}
//		else {
//			System.out.println("User not ableto login Successfully");
//		}
	}
	public void Patientloginfrommainformedical(String Un, String Pwd) {
		USERNAME.sendKeys(Un);
		PASSWORD.sendKeys(Pwd);
		SUMBIT.click();
	}
	

}
