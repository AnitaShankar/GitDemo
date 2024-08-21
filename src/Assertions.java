import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Assertions {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "E:\\Automation\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		//validation on assert true and flase
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
		
		driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click();
		
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
		
		//getting the count of all the check box present in page
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
		
		
		//validation on assertequals
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(1000);
		
		for(int a=1;a<3;a++)
		{
			driver.findElement(By.id("hrefIncAdt")).click();//2 times
		}
		

		driver.findElement(By.id("btnclosepaxoption")).click();
		
	Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "3 Adult");
		//System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		
	}


}
