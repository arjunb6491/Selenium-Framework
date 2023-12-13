package XpathPractice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlipcartSamsung {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[.='✕']")).click();
		//driver.findElement(By.name("q")).sendKeys("Samsung",Keys.ENTER);
	//	List<WebElement> ele = driver.findElements(By.xpath("//a[@class='s1Q9rs']"));
		//List<WebElement> price = driver.findElements(By.xpath("//div[@class='_30jeq3']"));
//		for(int i=0;i<=ele.size()-1;i++)
//		{
//			System.out.println(ele.get(i).getText()+"---->"+price.get(i).getText());
//		}

	}

}
