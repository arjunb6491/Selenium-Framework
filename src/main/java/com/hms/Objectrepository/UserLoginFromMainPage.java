package com.hms.Objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserLoginFromMainPage {
	@FindBy(xpath="//a[@href='hms/user-login.php']")
	private WebElement UserLoginFromHome;


//
public UserLoginFromMainPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}


public WebElement getUserLoginFromHome() {
	return UserLoginFromHome;
}


public void UserloginfromMainn(WebDriver driver)
{
	UserLoginFromHome.click();
}
}