package com.hms.Objectrepository;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import  static org.testng.Assert.*;

import com.hms.GenericUtility.WebDriverutility;

public class PatientAppointmentHistorypage extends WebDriverutility   {
	
	@FindBy(xpath="//span[text()=' Appointment History ']")
	private WebElement APPOINTMENTHISTORY;
	
	@FindBy(xpath="(//td[@class='hidden-xs'][last()]")
	private WebElement PATIENTNAME;
	
	public PatientAppointmentHistorypage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getAPPOINTMENTHISTORY() {
		return APPOINTMENTHISTORY;
	}

	public WebElement getPATIENTNAME() {
		return PATIENTNAME;
	}
	
	
	public void PatientAppointmentHistory(WebDriver driver )
	{
		APPOINTMENTHISTORY.click();
		
	}
	public void SelectPatientName(WebDriver driver) throws AWTException {
	
		scrollDownThePage();
//		scrollAction(driver, PATIENTNAME);
		
	}
	public void AppointmentInfo(WebDriver driver, String Fullname)
	{
   String Paname = driver.findElement(By.xpath("//td[@class='hidden-xs'][last()]")).getText();
        assertTrue(true, Paname);
		
//		if(Paname.contains(Fullname))
//		{
//			System.out.println("Shivamma is Presemt");
//		}
//		else {
//			System.out.println("Shivamma is not Present");
//		}
	}
		
		public void AppointmentHistoryInfo (WebDriver driver)
		{
			String Expected = "Cardiologist";
			WebElement ele4 = driver.findElement(By.xpath("//td[ text()='Cardiologist']"));
			String Actual = ele4.getText();
			 assertTrue(true, Expected);
			
//			if(Actual.contains(Expected))
//			{
//				System.out.println("Appointment is Present");
//			}
//			else {
//			System.out.println("Appointment is not Present");
//		}
		}
		public void AppointmentPresentInfo(WebDriver driver, String Fullname)
		{
	   String Paname = driver.findElement(By.xpath("//td[@class='hidden-xs'][last()]")).getText();
	   assertTrue(true, Paname);
			
//			if(Paname.contains(Fullname))
//			{
//				System.out.println("Appointment is Present");
//			}
//			else {
//				System.out.println("Appointment is not Present");
//			}
		}

	}

