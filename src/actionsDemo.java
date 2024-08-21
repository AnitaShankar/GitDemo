import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class actionsDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "E:\\Automation\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//WebDriverWait w=new WebDriverWait(driver , Duration.ofSeconds(10));
		
		driver.get("https://www.flipkart.com/");
		//w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='_2GaeWJ']")));
		//Thread.sleep(5000);
		Actions a = new Actions(driver);
		
		//mouse over on element and right click on the element
		a.moveToElement(driver.findElement(By.cssSelector("div[class='_2GaeWJ']"))).contextClick().build().perform();
		
		//writing text on searchbar and selecting the text
		a.moveToElement(driver.findElement(By.cssSelector("input.Pke_EE"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();

	
	}

}
