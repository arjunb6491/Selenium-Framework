package com.hms.Objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hms.GenericUtility.WebDriverutility;

public class AdminDashboardPage extends WebDriverutility {
	@FindBy(xpath="//span[.=' Users ']")
	private WebElement Usersdropdown;
	
	@FindBy(xpath="//span[text()=' Manage Users ']")
	private WebElement ManageUsers;
	
	
	@FindBy(xpath="//i[@class='ti-angle-down']")
	private WebElement AdminLogout;
	
	
	@FindBy(linkText="Log Out")
	private WebElement LOGOUT;
	
	public AdminDashboardPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	public WebElement getUsersdropdown() {
		return Usersdropdown;
	}
	public WebElement getManageUsers() {
		return ManageUsers;
	}	
	public WebElement getAdminLogout() {
		return AdminLogout;
	}
	public WebElement getLOGOUT() {
		return LOGOUT;
	}


	public void AdminDashboard()
	{
		Usersdropdown.click();
		ManageUsers.click();
	}
public void AdminLogout(WebDriver driver)
{
    AdminLogout.click();
	Mousehover(driver, LOGOUT);
}

	
}
