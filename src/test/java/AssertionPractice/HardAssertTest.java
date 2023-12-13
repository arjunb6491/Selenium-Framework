package AssertionPractice;


import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HardAssertTest {
	@Test
	public void AssertTest()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		WebElement ele = driver.findElement(By.linkText("Forgotten password?"));
		String actual = ele.getText();
		assertNotEquals(actual, "Forgotten password?");
		System.out.println("--enter the data--");
		driver.findElement(By.name("email")).sendKeys("Shivamma");
		System.out.println("--enter the data--");
		driver.findElement(By.name("pass")).sendKeys("9945465231");
		System.out.println("--enter the data--");
		driver.findElement(By.name("login")).click();
		
	}
	@Test
	public void AssertpassTest()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		WebElement ele = driver.findElement(By.linkText("Forgotten password?"));
		String actual = ele.getText();
		assertEquals(actual, "Forgotten password?");
		System.out.println("--enter the data--");
		driver.findElement(By.name("email")).sendKeys("Shivamma");
		System.out.println("--enter the data--");
		driver.findElement(By.name("pass")).sendKeys("9945465231");
		System.out.println("--enter the data--");
		driver.findElement(By.name("login")).click();
		
	}
}
