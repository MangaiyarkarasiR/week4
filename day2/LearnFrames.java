package week4.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;


	public class LearnFrames {
		private static Select select;

		public static void main(String[] args) {
			WebDriverManager.chromedriver().setup();
//			open the browser
			ChromeDriver driver=new ChromeDriver();
//			Maximise the browser window
			driver.manage().window().maximize();
//			Load the URL
			driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
			WebElement findFrame1 = driver.findElement(By.xpath("//iframe[1]"));	
//switch the context to frame1
			driver.switchTo().frame(findFrame1);
//Enter the value for Topic		
			WebElement findTopic = driver.findElement(By.xpath("//input[1]"));
			findTopic.sendKeys("Pet Shop");	
//Switch to nested frame			
			driver.switchTo().frame(0);
//Select the CheckBox			
			WebElement findNestedFrame = driver.findElement(By.xpath("//input[@id='a']"));			
			findNestedFrame.click();
//Verify checkBox is selected or Not			
					if(findNestedFrame.isSelected())
						System.out.println("CheckBox Selected");
					else
						System.out.println("CheckBox not Selected");
//switch back to main page					
			driver.switchTo().defaultContent();
//find frame2and switch context to frame2			
			WebElement findFrame2 = driver.findElement(By.xpath("//iframe[2]"));
			driver.switchTo().frame(findFrame2);
//select the animal from drop down			
			WebElement findDropDown = driver.findElement(By.xpath("//select[@id='animals']"));
			Select animals = new Select(findDropDown);
			animals.selectByIndex(1);
			 
}
	}
