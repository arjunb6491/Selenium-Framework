package XpathPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OlympicTest1 {
static String country_Name= "Argentina";
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://olympics.com/en/olympic-games/tokyo-2020/medals");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		WebElement Country_Name = driver.findElement(By.xpath("//span[text()='Argentina']"));
		WebElement GoldMedel = driver.findElement(By.xpath("//span[text()='Argentina']/../following-sibling::div[@title='Gold']"));
		WebElement silver = driver.findElement(By.xpath("//span[text()='Argentina']/../following-sibling::div[@title='Silver']"));
		WebElement bronze  = driver.findElement(By.xpath("//span[text()='Argentina']/../following-sibling::div[@title='Bronze']"));
		WebElement Total = driver.findElement(By.xpath("//span[text()='Argentina']/../following-sibling::div[@data-cy='medal']"));
		System.out.println(Country_Name.getText()+"  "+GoldMedel.getText()+"  "+silver.getText()+" "+bronze.getText()+"  "+Total.getText());
		
	}

}

