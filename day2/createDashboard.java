package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class createDashboard {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Password@123");
		driver.findElement(By.id("Login")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//div[@role='navigation']/button/div")).click();
		driver.findElement(By.xpath("//button[@class='slds-button']")).click();
		String newWindow = driver.getWindowHandle();
		driver.switchTo().window(newWindow);
		WebElement findDashboard = driver.findElement(By.xpath("//div[@class='slds-accordion__content']/slot/ul/li[35]/one-app-launcher-tab-item/a"));
		driver.executeScript("arguments[0].click();", findDashboard);
		driver.findElement(By.xpath("//div[contains(text(),'New Dashboard')]")).click();
		WebElement findfFrame = driver.findElement(By.xpath("//iframe[1]"));
		Thread.sleep(20000);
				driver.switchTo().frame(findfFrame);
		driver.findElement(By.xpath("//input[@id='dashboardNameInput']")).sendKeys("Salesforce Automation by Mangai");
		WebElement button =driver.findElement(By.xpath("//button[@id='submitBtn']"));
		 driver.executeScript("arguments[0].click();", button);
		 String title = driver.getTitle();
		  System.out.println(title); 
		  if(title.contains(title))
		  System.out.println("verified successfully");
		/*WebElement findfFrame2 = driver.findElement(By.xpath("//iframe[1]"));
		driver.switchTo().frame(findfFrame2);
		driver.findElement(By.xpath("//div[@class='slds-button-group']/button")).click();*/
		
		
}}