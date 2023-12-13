package com.hms.Objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hms.GenericUtility.WebDriverutility;

public class DashboardPage extends WebDriverutility
{
	
	@FindBy(xpath="(//a[@href='book-appointment.php'])[2]")
	private WebElement BOOKAPPOINTMENT;

	
	@FindBy(xpath="(//a[@href='appointment-history.php'])[2]")
	private WebElement APPOINTMENTHISTORY;
	
	@FindBy(xpath="(//a[@href='edit-profile.php'])[2]")
	private WebElement EDITPROFILE;
	
	@FindBy(xpath="//p[text()='Your appointment canceled !!								']")
	private WebElement VALIDATE;
	
	@FindBy(xpath="//i[@class='ti-angle-down']")
	private WebElement LOGOUTDROPDOWN;
	
	@FindBy(linkText="Log Out")
	private WebElement LOGOUT;
	
	public DashboardPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getBOOKAPPOINTMENT() {
		return BOOKAPPOINTMENT;
	}

	public WebElement getAPPOINTMENTHISTORY() {
		return APPOINTMENTHISTORY;
	}

	public WebElement getEDITPROFILE() {
		return EDITPROFILE;
	}

	public WebElement getVALIDATE() {
		return VALIDATE;
	}

	public WebElement getLOGOUTDROPDOWN() {
		return LOGOUTDROPDOWN;
	}

	public WebElement getLOGOUT() {
		return LOGOUT;
	}
	public void BookAppointment(WebDriver driver)
	{
		BOOKAPPOINTMENT.click();
		
		//EDITPROFILE.click();
	//	VALIDATE.click();
	
	}
	public void AppointmentHistory(WebDriver driver) {
		APPOINTMENTHISTORY.click();
		
	}
	public void LogoutasUser(WebDriver driver)
	{
		LOGOUTDROPDOWN.click( );
		Mousehover(driver, LOGOUT);
	}
	
	
	
	
}

