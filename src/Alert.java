import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alert {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		String text="Anita";
		System.setProperty("webdriver.chrome.driver", "E:\\Automation\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.id("name")).sendKeys(text);
		//css selector using id
		driver.findElement(By.cssSelector("[id='alertbtn']")).click();
		
		System.out.println(driver.switchTo().alert().getText());
		//when you have one option to select i,e. Ok or accept or YES
		driver.switchTo().alert().accept();
		
		driver.findElement(By.cssSelector("[id='confirmbtn']")).click();
		Thread.sleep(1000);
		//when you have to click on cancel or NO or dismiss
		driver.switchTo().alert().dismiss();
		
		
		
		
	}

}
