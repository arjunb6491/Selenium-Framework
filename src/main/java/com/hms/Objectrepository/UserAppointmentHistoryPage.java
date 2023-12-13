package com.hms.Objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static org.testng.Assert.*;

import com.hms.GenericUtility.WebDriverutility;

public class UserAppointmentHistoryPage extends WebDriverutility {
	@FindBy(xpath="//a[@title='Cancel Appointment']")
	private WebElement Cancel;
	
	@FindBy(xpath="//i[@class='ti-angle-down']")
	private WebElement LOGOUTDROPDOWN;
	

	@FindBy(linkText="Log Out")
	private WebElement LOGOUT;
	
	
	public UserAppointmentHistoryPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);	
	}
	
//
	
	public WebElement getCancel() {
		return Cancel;
	}
	public WebElement getLOGOUTDROPDOWN() {
		return LOGOUTDROPDOWN;
	}

	public WebElement getLOGOUT() {
		return LOGOUT;
	}
	
		public void Cancelappointment(WebDriver driver)
	{
		Cancel.click();
	}
		public void cancelappointmentinfo(WebDriver driver)
		{
			 String Expected = ("Your appointment canceled !!");
		       WebElement ele6 = driver.findElement(By.xpath("//p[text()='Your appointment canceled !!								']"));
		      String Acutual = ele6.getText();
		      assertEquals(Acutual, Expected);
//		      if(Acutual.contains(Expected))
//		      {
//		    	  System.out.println("Appointment Succesfully Cancelled");
//		      }
//		      else {
//				System.out.println("Appointment not Cancelled Successfully");
//			}
		}
}
