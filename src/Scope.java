import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scope {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		System.setProperty("webdriver.chrome.driver", "E:\\Automation\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//count of the links on the page 
		// default tagname fro links is 'a'
		
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		//count of the link on footer page
		
		 WebElement footerPage=driver.findElement(By.id("gf-BIG"));
		 System.out.println(footerPage.findElements(By.tagName("a")).size());
		 
		 
		 //count of the link on 1st column 
		 
		WebElement firstColumn = footerPage.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		
		System.out.println(firstColumn.findElements(By.tagName("a")).size());
		
		
		//click on each link in the column and check pages are opening 
		//opening the links in separate tabs
		
		for(int i=1 ; i<firstColumn.findElements(By.tagName("a")).size();i++) 
		{
			
			//clicking on link and opening in new 
			String  clicktoOpenInNewTab = Keys.chord(Keys.CONTROL,Keys.ENTER);
			
			
			firstColumn.findElements(By.tagName("a")).get(i).sendKeys(clicktoOpenInNewTab);
			
			
		}
			Thread.sleep(5000L);
			
			//getting the title of each tabs 
			
		Set<String>	abc = driver.getWindowHandles(); //all windows 
		Iterator<String> it = abc.iterator();// move to next tabs or next index
		
		while(it.hasNext())
		{
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}
			
			
			
	
		
		 
		 
	}

}
