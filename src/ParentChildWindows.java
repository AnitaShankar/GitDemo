import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ParentChildWindows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "E:\\Automation\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.cssSelector(".blinkingText")).click();
		
		//parentwindow -> childwindow -> parentwindow
		Set<String> windows = driver.getWindowHandles(); //[parentID , childID]
		Iterator<String> ID =windows.iterator();//all the window items store in ID
		String parentID = ID.next();//move to 0th index 
		String childID = ID.next();//move to 1st index
		
		driver.switchTo().window(childID);
		
		
		System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());
		
		driver.findElement(By.cssSelector(".im-para.red")).getText();
		
		String emailID = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];
		
		driver.switchTo().window(parentID);
		driver.findElement(By.id("username")).sendKeys(emailID);

	}

}
