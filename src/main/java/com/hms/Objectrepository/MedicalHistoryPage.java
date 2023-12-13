package com.hms.Objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static org.testng.Assert.*;

public class MedicalHistoryPage {
	@FindBy(xpath="//span[contains(text(),'Medical History')]")
	private WebElement MedicalInk;
	@FindBy(xpath="//td[text()='1.']/../descendant :: i[@class='fa fa-eye']")
	private WebElement linkElement;
	
	
	public MedicalHistoryPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	public WebElement getMedicalInk() {
		return MedicalInk;
	}


	public WebElement getLinkElement() {
		return linkElement;
	}
	
	public void Medical()
	{
		MedicalInk.click();
		linkElement.click();
	}
	public void Medicalinfo(WebDriver driver)
	{
		String expectedResult = "USERS | MEDICAL HISTORY";
		String actualResult = driver.findElement(By.xpath("//h1[text()='Users | Medical History']")).getText();
		
		assertEquals(actualResult, expectedResult, "Medical History page is displaying");
				
//		if(actualResult.equalsIgnoreCase(expectedResult))
//		{
//			System.out.println("Pass: Medical History page is displaying");
//		}
//		else
//		{
//			System.out.println("Fail: Medical History page is not displaying");
//		}
	}
}


