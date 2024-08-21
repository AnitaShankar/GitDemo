import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Demo2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
	String name="Anita";
		
		System.setProperty("webdriver.chrome.driver", "E:\\Automation\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//global method to wait for some seconds for each methods 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//calling the static method 
		String password=getpasswordtext(driver);
		//Open the page and print the title and URL
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
		//perform actions using locators with method
		driver.findElement(By.id("inputUsername")).sendKeys(name);
		driver.findElement(By.name("inputPassword")).sendKeys(password);
		driver.findElement(By.className("signInBtn")).click();
		Thread.sleep(2000);
		//css tagname
		System.out.println(driver.findElement(By.tagName("p")).getText());
		
		//to validate the test case with actual result and expected result
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
		
		Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(), "Hello "+name+",");   
		
		//xpath using button text
		driver.findElement(By.xpath("//*[text()='Log Out']")).click();
		
		Thread.sleep(1000);
		
		driver.close();
		
	}
	
	public static String getpasswordtext(WebDriver driver) throws InterruptedException
	
	{
	
	driver.get("https://rahulshettyacademy.com/locatorspractice/");
	driver.findElement(By.linkText("Forgot your password?")).click();
	Thread.sleep(1000);
	driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
	String passwordText= driver.findElement(By.cssSelector("form p")).getText();
	//Please use temporary password 'rahulshettyacademy' to Login.
	String[] passwordArray=passwordText.split("'");
	//0th index - Please use temporary password
	//1st index - rahulshettyacademy' to Login.
	String password=passwordArray[1].split("'")[0];
	// String[] passwordArray2 = passwordArray[1].split("'");
	// passwordArray2[0]
	//0th index - rahulshettyacademy
	//1st index - to Login.
	
	return password;


	}
	

	

}
