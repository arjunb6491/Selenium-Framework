package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RmgDatabaseTest {
    String expdata="hms4";
	public static void main(String[] args) throws SQLException {
		String expdata="hms4";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://rmgtestingserver:8084/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[.='Sign in']")).click();
		driver.findElement(By.xpath("//a[text()='Projects']")).click();
		driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys("hms4");
		driver.findElement(By.name("createdBy")).sendKeys("Vijaylakshmi");
		WebElement ele = driver.findElement(By.name("status"));
		
		Select sc = new Select(ele);
		sc.selectByVisibleText("On Gogin");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		Driver driver1 = new Driver();
		DriverManager.registerDriver(driver1);
		Connection con = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");
		Statement state = con.createStatement();
		String query = "select* from project;";
		ResultSet result = state.executeQuery(query);
		boolean flag=false;
		while(result.next()){
			String actual= result.getString(4);
			if(actual.equalsIgnoreCase(expdata))
			{
				flag=true;
				break;
			}
		}
		if(flag)
		{
		 System.out.println("Project created Successfully");
		}
		else
		{
			System.out.println("Project not Created");
		}
		

	}

}
