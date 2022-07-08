package week4.assignments.day1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class html1 {
public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.get("https://html.com/tags/table/");
	driver.manage().window().maximize();
	List<WebElement> rows = driver.findElements(By.xpath("//div[@class='render']/table/tbody/tr"));
	System.out.println("Number of Rows "+rows.size());
		WebElement eachRow = rows.get(1);
		List<WebElement> cols = driver.findElements(By.xpath("//div[@class='render']/table/tbody/tr[1]/td"));
		System.out.println("Number of Columns "+cols.size());	
}
}
