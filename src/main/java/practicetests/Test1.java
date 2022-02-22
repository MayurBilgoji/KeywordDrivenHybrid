package practicetests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Test1 {

	public static void main(String[] args) throws InterruptedException 
	{
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Asus\\eclipse-workspace\\JPG\\drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.jio.com");
		driver.findElement(By.xpath("//a[@cust-url='/selfcare/recharge/mobility/']")).click();
		driver.findElement(By.xpath("//input[@name='jioNrInputName']")).sendKeys("8884134076");
		driver.findElement(By.xpath("//button[.='Submit']")).click();
		driver.findElement(By.xpath("(//button[@class='css-r5gb33'])[4]")).click();
		Thread.sleep(3000);
		String title=driver.getTitle();
		System.out.println(title);
	    Assert.assertEquals(title, "My Jio Payment Gateway");
	    driver.close();
	}

}
