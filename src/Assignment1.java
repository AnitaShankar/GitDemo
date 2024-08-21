import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class Assignment1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//1.select any checkbox
		//2.grab the label from the selected checkbox //put it to varible
		//3.Select an option in dropdown . Here option to select should come from step 2
		    // do not hard code text , drive it dynamically from step 2
		//4.enter the step 2 grabbed label text in editbox
		//5.Click Alert and then verify if text grabbed from step 2 is present in the
			//pop msg 
		
		System.setProperty("webdriver.chrome.driver", "E:\\Automation\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//1.select any checkbox
		
		driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[2]")).click();
		
		//2.grab the label from the selected checkbox //put it to varible
		
		String opt= driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[2]")).getText();		
		System.out.println(opt);
		
		//Select an option in dropdown . Here option to select should come from step 2
		
		WebElement dropdown = driver.findElement(By.id("dropdown-class-example"));
		Select S = new Select(dropdown);
		S.selectByVisibleText(opt);
		
		//4.enter the step 2 grabbed label text in editbox
		
		driver.findElement(By.id("name")).sendKeys(opt);
		
		//5.Click Alert and then verify if text grabbed from step 2 is present in the
		//pop msg 
		
		driver.findElement(By.id("alertbtn")).click();
		
		String text= driver.switchTo().alert().getText();
		
		if (text.contains(opt))
		{
			System.out.println("Alert message successful");
		}
		else
		{
			System.out.println("incorrect alert message");
		}
		
		

	}

}
