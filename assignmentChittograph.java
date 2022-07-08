package week4.assignments.day1;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class assignmentChittograph {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.chittorgarh.com/");
		driver.findElement(By.id("navbtn_stockmarket")).click();
		driver.findElement(By.linkText("NSE Bulk Deals")).click();

		List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered table-condensed table-striped']/tbody/tr"));
		List<String> list = new ArrayList<String>();		
		for(int i=0;i<rows.size();i++) 
		{
		WebElement eachRow = rows.get(i);
			List<WebElement> columns = eachRow.findElements(By.tagName("td"));
			list.add(columns.get(2).getText());			
		}	
		System.out.println("Security Nmaes are :");
		for(int i=0;i<list.size();i++)
		{
			System.out.println(list.get(i));
		}
		//check for Duplicates in Security Names
		
		for(int i=0;i<list.size()-1;i++)
		{
		int count=0;
			for(int j=i+1;j<list.size();j++)
			{
				if(list.get(i)==list.get(j))
				{
					count++;
				}
					
			}
			if(count>0)
			{
			System.out.println("Security Name :"+list.get(i)+" is duplicated");
			}
		}
	}
	}


