package XpathPracticeYouTube;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import net.bytebuddy.asm.Advice.Enter;

public class youTube {
	@Test
	public void InspectuTube() throws AWTException
	{
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\chromedriver.exe");
	ChromeOptions options= new ChromeOptions();
	options.addArguments("--disable-notifications");
	WebDriver driver = new ChromeDriver(options);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	driver.get("https://youtube.com/");
	driver.findElement(By.xpath("//input[@id='search']")).sendKeys("Sparsha Movie Song");
	Robot rb=new Robot();
	rb.keyPress(KeyEvent.VK_ENTER);
	driver.findElement(By.xpath("//*[text()='Bareyada Mounada Kavithe / Sparsha / HD Video / Sudeep / Rekha / Pankaj Udhas / Kavitha']")).click();

}
}