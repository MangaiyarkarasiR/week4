package week4.assignments.day1;
	import java.util.List;

	import javax.sql.RowSetMetaData;

	import org.apache.commons.collections4.bag.SynchronizedSortedBag;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;

	import io.github.bonigarcia.wdm.WebDriverManager;

	public class html2 {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://html.com/tags/table/");
		driver.manage().window().maximize();
		List<WebElement> rows = driver.findElements(By.xpath("//div[@class='render']/table/tbody/tr"));
		List<WebElement> cols = driver.findElements(By.xpath("//div[@class='render']/table/tbody/tr[1]/td"));
		List<WebElement> findrows = driver.findElements(By.xpath("//div[@class='render']/table/tbody/tr"));
		for(int i=0;i<rows.size();i++)
		{
		int k=i+1;
		String xpath="//div[@class='render']/table/tbody/tr["+k+"]/td";
		List<WebElement> columns = driver.findElements(By.xpath(xpath));
		System.out.println(columns.get(0).getText()+" Values are :");
		for(int j=1;j<cols.size();j++)
		{
			
			System.out.println(columns.get(j).getText());
		}
		
		}
				
	}
	}



