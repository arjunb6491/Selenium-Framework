package XpathPractice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.protobuf.Duration;

import io.github.bonigarcia.wdm.WebDriverManager;
public class PhnwithpriceRest {
public static void main(String[] args) throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	WebDriver driver= new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@aria-label='Search Amazon.in']")).sendKeys("i phone",Keys.ENTER);
		List<WebElement> ele = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		List<WebElement> price = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
		for(int i=0;i<=ele.size()-1;i++)
		{
			System.out.println(ele.get(i).getText()+"--->"+price.get(i).getText()+" Rs/-");
		}
}
}
