import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class windowActivities {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "E:\\Automation\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//maximizing the window 
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		//navigating to another url
		driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");
		Thread.sleep(2000L);
		
		//taking srcreen shot of the page
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src , new File("F://screeenshot.png"));
		
		
		Thread.sleep(2000L);
		
		
		
		//navigating to the previous url
		driver.navigate().back();
		//navigating to the forword url
		driver.navigate().forward();
		
		
		
		

	}

}
