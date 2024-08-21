import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		System.setProperty("webdriver.chrome.driver", "E:\\Automation\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//global method to wait for some seconds for each methods 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//Open the page and print the title and URL
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
		//perform actions using locators with method
		driver.findElement(By.id("inputUsername")).sendKeys("Anita");
		driver.findElement(By.name("inputPassword")).sendKeys("Hello123");
		driver.findElement(By.className("signInBtn")).click();
		
		//using CSS selector -> tagname.classname
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		//click on link using link text
		driver.findElement(By.linkText("Forgot your password?")).click();
		
		Thread.sleep(1000);
		
		//using Xpath
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Anita");
		
		//using css selector customize syntax 
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("anita@asm.com");
		
		//clearing the written text using xpath index
		driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
		
		//writing the text using CSS selector index 
		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("anitamareppanavar18@gmail.com");
		
		//writing the text using xpath parent to child 
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("8970474518");
		
		//css selector using .value of classname 
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		
		//writing the text using css selector parent to child 
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());
		
		//xpath using parent[with syntax] to child with index
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
		
		Thread.sleep(1000);
		
		//css selector using tagname#id 
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("Anita");
		
		//css selector syntax with regular expression
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");

		driver.findElement(By.id("chkboxOne")).click();
		
		//Xpath syntax with regular expression
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
	}

}
