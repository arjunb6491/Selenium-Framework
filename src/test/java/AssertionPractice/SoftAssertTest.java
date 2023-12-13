package AssertionPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SoftAssertTest {
	@Test
	public void AssertTest()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		WebElement ele = driver.findElement(By.linkText("Forgotten password?"));
		String actual = ele.getText();
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(actual, "Forgotten password?");
		driver.findElement(By.name("email")).sendKeys("Shivamma");
		driver.findElement(By.name("pass")).sendKeys("9945465231");
		driver.findElement(By.name("login")).click();
	}
	@Test
	public void AssertfailTest()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		WebElement ele = driver.findElement(By.linkText("Forgotten password?"));
		String actual = ele.getText();
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(actual, "Forgotten password");
		driver.findElement(By.name("email")).sendKeys("Shivamma");
		System.out.println("--enter the data--");
		driver.findElement(By.name("pass")).sendKeys("9945465231");
		System.out.println("---enterthe data---");
		driver.findElement(By.name("login")).click();
		System.out.println("--clicking done successufully--");
		sa.assertAll();
	}
	@Test
	public void AssertfailsTest()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		WebElement ele = driver.findElement(By.linkText("Forgotten password?"));
		String actual = ele.getText();
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(actual, "Forgotten password");
		driver.findElement(By.name("email")).sendKeys("Shivamma");
		System.out.println("--enter the data--");
		driver.findElement(By.name("pass")).sendKeys("9945465231");
		System.out.println("---enterthe data---");
		driver.findElement(By.name("login")).click();
		System.out.println("--clicking done successufully--");

	}

}
