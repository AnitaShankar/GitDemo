import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "E:\\Automation\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//handling static dropdown with Select
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(1000);
		
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		
		/*clicking the button for many times (adding count for a button) 
		we can go for while loop or for loop*/
		
		/*int a=1;
		while(a<3)
		{
			driver.findElement(By.id("hrefIncAdt")).click();//2 times
			a++;
		}*/
		
	    
		for(int a=1;a<3;a++)
		{
			driver.findElement(By.id("hrefIncAdt")).click();//2 times
		}
		
		
		
		driver.findElement(By.id("btnclosepaxoption")).click();
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
	}

}
