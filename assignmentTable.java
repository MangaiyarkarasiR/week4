package week4.assignments.day1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
public class assignmentTable {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/table.html");
		driver.manage().window().maximize();
		WebElement findTable = driver.findElement(By.tagName("table"));
		List<WebElement> rows = driver.findElements(By.tagName("tr"));
		ArrayList<String> leastProgress = new ArrayList<String>();
		System.out.println("Progress Value for Learn to interact with Elements");
		for(int i=2;i<rows.size();i++)
		{
			WebElement eachRow = rows.get(i);
		List<WebElement> columns =  eachRow.findElements(By.tagName("td"));	
		
		String str="Learn to interact with Elements";
		String str2=columns.get(0).getText();
		if(str.equals(str2))
		System.out.println(columns.get(1).getText());	
		leastProgress.add(columns.get(1).getText());
		
		}
		Collections.sort(leastProgress);
		
		System.out.println("Least Progess Value in the Table :"+leastProgress.get(0));
		for(int i=2;i<rows.size();i++)
		{
			WebElement eachRow = rows.get(i);
			List<WebElement> columns =  eachRow.findElements(By.tagName("td"));	
			String str2=columns.get(1).getText();				
				if(leastProgress.get(0).equals(str2))
				{
					WebElement vitalClick = columns.get(2);
					vitalClick.click();
					if(vitalClick.isEnabled())
					{
						System.out.println("Vital task for the Least Progress Value is  Selected");
					}
		}
		}
		
}
}

