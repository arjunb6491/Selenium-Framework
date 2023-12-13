package XpathPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class prokabaddiTest {
	

	public static void main(String[] args) {
		String team_name ="Jaipur Pink Panthers";

		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.prokabaddi.com/standings");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement name = driver.findElement(By.xpath("//p[text()='Jaipur Pink Panthers']"));
		WebElement play = driver.findElement(By.xpath("//p[text()='Jaipur Pink Panthers']/ancestor::div[@class='row-head']/descendant::div[@class='table-data matches-play']"));
		
      WebElement won = driver.findElement(By.xpath("//p[text()='Jaipur Pink Panthers']/ancestor::div[@class='row-head']/descendant::div[@class='table-data matches-won']"));
               WebElement loss = driver.findElement(By.xpath("//p[text()='Jaipur Pink Panthers']/ancestor::div[@class='row-head']/descendant::div[@class='table-data matches-lost']"));
               WebElement draw = driver.findElement(By.xpath("//p[text()='Jaipur Pink Panthers']/ancestor::div[@class='row-head']/descendant::div[@class='table-data matches-draw']"));

      WebElement pts = driver.findElement(By.xpath("//p[text()='Jaipur Pink Panthers']/ancestor::div[@class='row-head']/descendant::div[@class='table-data score-diff']"));
      WebElement data = driver.findElement(By.xpath("//p[text()='Jaipur Pink Panthers']/ancestor::div[@class='row-head']/descendant::div[@class='table-data form']"));
      
System.out.println(name.getText()+"   "+play.getText()+"  "+won.getText()+"  "+loss.getText()+"  "+draw.getText()+"  "+pts.getText()+"  "+data.getText());
	}

}
