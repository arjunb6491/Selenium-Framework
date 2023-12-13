package XpathPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OlympicTest {
static String country_Name= "Argentina";
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://olympics.com/en/olympic-games/tokyo-2020/medals");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		WebElement Country_Name = driver.findElement(By.xpath("//span[text()='Argentina']"));
		Thread.sleep(2000);
		WebElement GoldMedel = driver.findElement(By.xpath("//span[text()='Argentina']/../following-sibling::div[@data-medal-id='gold-medals-row-1']"));
		Thread.sleep(2000);
		WebElement silver = driver.findElement(By.xpath("//span[text()='Argentina']/../following-sibling::div[@data-medal-id='silver-medals-row-1']"));
		Thread.sleep(2000);
		WebElement bronze  = driver.findElement(By.xpath("//span[text()='Argentina']/../following-sibling::div[@data-medal-id='bronze-medals-row-1']"));
		Thread.sleep(2000);
		WebElement Total = driver.findElement(By.xpath("//span[text()='Argentina']/../following-sibling::div[@data-medal-id='total-medals-row-1']"));
		Thread.sleep(2000);
		System.out.println(Country_Name.getText()+"  "+GoldMedel.getText()+"  "+silver.getText()+" "+bronze.getText()+"  "+Total.getText());
		
	}

}
