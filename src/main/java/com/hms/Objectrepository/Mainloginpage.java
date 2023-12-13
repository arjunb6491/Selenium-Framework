package com.hms.Objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Mainloginpage {
	
	//Declaration
	@FindBy(xpath="//a[@href='hms/admin']")
	private WebElement adminloginlink;
	
	@FindBy(xpath="//a[@href='hms/doctor']")
	private WebElement Doctorsloginlink;
	
	@FindBy(xpath="//a[@href='hms/user-login.php']")
	private WebElement Usersloginlink;
	
	@FindBy(linkText="Click Here")
	private WebElement ClicktoRegisterpage;
	
	//@FindBy(xpath="//a[href='hms/user-login.php']")
	//private WebElement UserLoginFromHome;

	//initialization
	public Mainloginpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	//Utilization

	public WebElement getAdminloginlink() {
		return adminloginlink;
	}

	public WebElement getDoctorsloginlink() {
		return Doctorsloginlink;
	}

	public WebElement getUsersloginlink() {
		return Usersloginlink;
	}

	public WebElement getClicktoRegisterpage() {
		return ClicktoRegisterpage;
	}
	
	public void Mainlogin()
	{
		ClicktoRegisterpage.click();
	}


	public void adminloginlink(WebDriver driver) 
	{
		adminloginlink.click();	
	
	}
	public void userloginlink()
	{
		Usersloginlink.click();
	}
	
	
	
	
	

	
	
	

}
