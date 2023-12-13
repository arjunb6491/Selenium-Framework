package com.hms.Objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminLoginpage {
	//Declaration
	
	@FindBy(name="username")
	private WebElement username;
	
	
	@FindBy(name="password")
	private WebElement password;
	
	@FindBy(name="submit")
	private WebElement SUBMIT;
	//initialization
	
	public AdminLoginpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization

	public WebElement getUSERNAME() {
		return username;
	}

	public WebElement getPASSWORD() {
		return password;
	}

	public WebElement getSUBMIT() {
		return SUBMIT;
	}
	//
	public void Login(String USERNAME ,String PASSWORD)
	{
		username.sendKeys(USERNAME);
		password.sendKeys(PASSWORD);
		SUBMIT.click();
		
		
	}

}
