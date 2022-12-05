package seleniumPopUpAlerts;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PopUpAlerts {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		// Simple Alert
		WebElement simpleAlert = driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[1]/button"));
		
		simpleAlert.click();
		
		Alert alert1 = driver.switchTo().alert();
		
		String alertText = alert1.getText();
		System.out.println(alertText);
		
		Thread.sleep(1000);
		alert1.accept();
		
		if(driver.getPageSource().contains("You successfully clicked an alert")) {
			System.out.println("You successfully clicked an alert");
		}
		
		Thread.sleep(1000);
		
		// Confirm Alert
		WebElement confirmAlert = driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[2]/button"));
		confirmAlert.click();
		
		Alert alert2 = driver.switchTo().alert();
		Thread.sleep(1000);
		alert2.dismiss();
		
		if(driver.getPageSource().contains("You clicked: Cancel")) {
			System.out.println("You clicked: Cancel");
		}
		
		Thread.sleep(1000);
		
		// Prompt Alert
		WebElement promptAlert = driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[3]/button"));
		promptAlert.click();
		
		Alert alert3 = driver.switchTo().alert();
		alert3.sendKeys("Hello Mr Tester !!!");
		Thread.sleep(1000);
		alert3.accept();
		
		driver.quit();

	}

}
