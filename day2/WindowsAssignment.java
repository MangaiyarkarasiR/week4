package week4.day2;

import java.util.ArrayList;
import java.util.Set;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowsAssignment {	public static void main(String[] args) throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.get("http://www.leafground.com/pages/Window.html");
	driver.manage().window().maximize();	
	//click to open home page
	driver.findElement(By.id("home")).click();
	
	//click to open Multiple Windows

	driver.findElement(By.xpath("//section[@class='innerblock']/div[2]/div/div/button")).click();

	Set<String> windowHandles = driver.getWindowHandles();
	//get the number of windows opened 
	System.out.println("Number of Windows: "+windowHandles.size());	
	// close all window except this window
	driver.findElement(By.xpath("//section[@class='innerblock']/div[3]/div/div/button")).click();
	Set<String> allwindows = driver.getWindowHandles();
	ArrayList<String> list = new ArrayList<String>(allwindows);
	for(int i=2;i<list.size();i++)
	{
	driver.switchTo().window(list.get(i));
	driver.close();	
	}
	//switch the control back to main window
	driver.switchTo().window(list.get(1));
	//wait for 5 seconds 
	driver.findElement(By.xpath("//section[@class='innerblock']/div[4]/div/div/button")).click();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
}
}