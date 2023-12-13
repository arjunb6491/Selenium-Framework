package com.hms.Objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static org.testng.Assert.*;

import com.hms.GenericUtility.WebDriverutility;

public class UserbookAppointmentpage extends WebDriverutility {

	@FindBy(name="Doctorspecialization")
	private WebElement Doctorspecialization;
	
	@FindBy(name="doctor")
	private WebElement Doctor;
	
	@FindBy(xpath="//input[@name='appdate']")
	private WebElement Date;
	
	@FindBy(xpath="//th[text()='August 2023']/ancestor::div[@class='datepicker-days']/descendant::td/../following-sibling::tr[4]/td[.='3']")
	private WebElement SelectDate;
	
	@FindBy(name="submit")
	private WebElement SUBMIT;
	
	
	@FindBy(xpath="//i[@class='ti-angle-down']")
	private WebElement LOGOUTDROPDOWN;
	

	@FindBy(linkText="Log Out")
	private WebElement LOGOUT;
	
	public UserbookAppointmentpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	
	//buisness Libraries
	
	public WebElement getDoctorspecialization() {
		return Doctorspecialization;
	}



	public WebElement getDoctor() {
		return Doctor;
	}



	public WebElement getDate() {
		return Date;
	}



	public WebElement getSelectDate() {
		return SelectDate;
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



	public void UserbookAppointment(String text,String name,WebDriver driver)
	{
		select(Doctorspecialization, text);
		select(name, Doctor);
		Date.click();
		SelectDate.click();
		SUBMIT.click();
		
	}
	public void UserbookAppointmentinfo(WebDriver driver)
	{
		String String1 = driver.switchTo().alert().getText();
		String Cof = ("Your appointment successfully booked");
		assertEquals(String1, Cof);
//		if(String1.contains(Cof))
//		{
//			System.out.println("Appointment Booked Successfully");
//		}
//		else {
//			
//			System.out.println("not able to book Appointment");
//		}
	}
	
	
}

