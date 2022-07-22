package week4.day2;

import java.time.Duration;
import java.lang.Thread;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditDashboard {
	public static void main(String[] args) throws InterruptedException   {
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
		driver.findElement(By.xpath("//div[@class='slds-grid']/div[2]/div/div/input")).sendKeys("Mangai");
		Thread.sleep(10000);	
		driver.findElement(By.xpath("//table/tbody/tr/td[6]")).click();
		driver.findElement(By.xpath("//lightning-menu-item[@class='slds-dropdown__item'][2]/a/span")).click();
		Thread.sleep(20000);
		WebElement findfFrame = driver.findElement(By.xpath("//iframe[1]"));
		Thread.sleep(20000);
		driver.switchTo().frame(findfFrame);
		driver.findElement(By.xpath("//div[@class='commandControls']/button[3]")).click();
		driver.findElement(By.xpath("//input[@id='dashboardDescriptionInput']")).sendKeys("SalesForce");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@id='submitBtn']")).click();
		driver.switchTo().defaultContent();
		WebElement findfFrame2 = driver.findElement(By.xpath("//iframe[1]"));
		driver.switchTo().frame(findfFrame2);
		driver.findElement(By.xpath("//div[@class='slds-button-group']/button")).click();
		driver.findElement(By.xpath("//div[@class='toolbarActions']/button")).click();
		driver.switchTo().defaultContent();
		WebElement findfFrame3 = driver.findElement(By.xpath("//iframe[1]"));
		driver.switchTo().frame(findfFrame3);
		driver.findElement(By.xpath("//footer[@class='slds-modal__footer']/button[3]")).click();
		driver.switchTo().defaultContent();
		WebElement findfFrame4 = driver.findElement(By.xpath("//iframe[1]"));
		driver.switchTo().frame(findfFrame4);
		WebElement findDesc = driver.findElement(By.xpath("//p[@class='slds-page-header__info']"));
		if(findDesc.getText().equals("SalesForce"))
		System.out.println("Dashboard Edit Successfull");
		else
			System.out.println("Dashboard Edit Unsuccessful");
}
}
