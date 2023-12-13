package XpathPractice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlipkartSamsungTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.flipkart.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("samsung"+Keys.ENTER);
		Thread.sleep(2000);
		List<WebElement> sum = driver.findElements(By.xpath("//a[contains(text(),'SAMSUNG ')]"));
		Thread.sleep(2000);
		List<WebElement> price = driver.findElements(By.xpath("//a[contains(text(),'SAMSUNG ')]/../..//div[@class='_30jeq3']"));
		Thread.sleep(2000);
		
		int count = sum.size();
		System.out.println(count);
		for(int i=0;i<count;i++)
		{
		String Name = sum.get(i).getText();
		String Phoneprice = price.get(i).getText();
		String Price1 = Phoneprice.replace(",","");
		Integer ActualPrice = Integer.valueOf(Price1);
		System.out.println(Name+"------->"+ActualPrice);
	}
	}
	
	
}



