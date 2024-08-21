import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EndtoEnd {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "E:\\Automation\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='IXG']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='BLR']")).click();
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(1000);
		
		for(int a=1;a<6;a++)
		{
			driver.findElement(By.id("hrefIncAdt")).click();//2 times
		}
		
		
		
		driver.findElement(By.id("btnclosepaxoption")).click();
		
		driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click();
		
		driver.findElement(By.name("ctl00$mainContent$btn_FindFlights")).click();
		Thread.sleep(1000);
	}
	

}
