package com.hms.Objectrepository;



import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static org.testng.Assert.*;

import com.hms.GenericUtility.JavaUtility;
import com.hms.GenericUtility.WebDriverutility;

public class PatientRegistrationPage extends WebDriverutility{
	@FindBy(name="full_name")
	private WebElement FULLNAME;
	
	@FindBy(name="address")
	private WebElement ADDRESS;
	
	@FindBy(name="city")
	private WebElement CITY;
	
	@FindBy(xpath="//label[@for='rg-female']")
	private WebElement RADIOBUTTON;
	
	@FindBy(name="email")
	private WebElement EMAIL;
	
	@FindBy(name="password")
	private WebElement PASSWORD;
	
	@FindBy(name="password_again")
	private WebElement REENTERPASSWORD;
	
	@FindBy(xpath="//label[@for='agree']")
	private WebElement RADIOBTTN;
	
	@FindBy(name="submit")
	private WebElement SUBMIT;
	
	@FindBy(xpath="//i[@class='ti-angle-down']")
	private WebElement LOGOUTDROPDOWN;
	

	@FindBy(linkText="Log Out")
	private WebElement LOGOUT;
	
	//
	
	public PatientRegistrationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//

	public WebElement getFULLNAME() {
		return FULLNAME;
	}

	public WebElement getADDRESS() {
		return ADDRESS;
	}

	public WebElement getCITY() {
		return CITY;
	}

	public WebElement getRADIOBUTTON() {
		return RADIOBUTTON;
	}

	public WebElement getEMAIL() {
		return EMAIL;
	}

	public WebElement getPASSWORD() {
		return PASSWORD;
	}

	public WebElement getREENTERPASSWORD() {
		return REENTERPASSWORD;
	}

	public WebElement getRADIOBTTN() {
		return RADIOBTTN;
	}

	public WebElement getSUBMIT() {
		return SUBMIT;
	}
	
	public WebElement getLOGOUTDROPDOWN() {
		return LOGOUTDROPDOWN;
	}
	public WebElement getLOGOUT() {
		return LOGOUT;
	}

	

	//
	public void Registration(String Fullname, String Address,String City,String Email,String Password , String ReEnter,WebDriver driver ) {
		FULLNAME.sendKeys(Fullname);
		ADDRESS.sendKeys(Address);
		CITY.sendKeys(City);
		RADIOBUTTON.click();
		EMAIL.sendKeys(Email);
		PASSWORD.sendKeys(Password);
		REENTERPASSWORD.sendKeys(ReEnter);
		SUBMIT.click();
		
	}
	
	public void UserLogout(WebDriver driver)
	{
		LOGOUTDROPDOWN.click( );
		Mousehover(driver, LOGOUT);
		
	}
	public void Rigistrstioninfo(WebDriver driver)
	{
		String ConfirmationMessage=("Successfully Registered. You can login now");
		String Message = driver.switchTo().alert().getText();
		assertEquals(ConfirmationMessage, Message);
//		if(Message.contains(ConfirmationMessage))
//		{
//			System.out.println("Rigistration done Successfully");
//		}
//		else {
//			System.out.println("Rigistrion not done succesfully");
//		}
	}
	
	public void Accountcreationinfo(WebDriver driver) 
	{
		 String ConfirmationMessage=("Successfully Registered. You can login now");
			String Message = driver.switchTo().alert().getText();
			assertEquals(ConfirmationMessage, Message);
//			if(Message.contains(ConfirmationMessage))
//			{
//				System.out.println("Account is Created Successfully");
//			}
//			else
//			{
//				System.out.println("Account is not Created succesfully");
//			}
		
	}

	public void UserRigistration(HashMap<String, String> map , WebDriver driver, JavaUtility jlib) {
		
		
		for(Entry<String, String> set:map.entrySet())
		{
			if(set.getKey().contains("email"))
			{
				driver.findElement(By.name(set.getKey())).sendKeys(set.getValue()+jlib.getRandomNo());
			}
			else
			{
				driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
			}
		}
		RADIOBUTTON.click();
		SUBMIT.click();
	}
		
		
	}

	

