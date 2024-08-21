package streams;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class filterTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		///checking the filter functionality for the web tables using java streams 
		
		System.setProperty("webdriver.chrome.driver", "E:\\Automation\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.id("search-field")).sendKeys("Rice");
		List<WebElement> items=driver.findElements(By.xpath("//tr/td[1]"));
		//few items stored in items 
		List<WebElement> filteredList = items.stream().filter(item->item.getText().contains("Rice"))
		.collect(Collectors.toList());
		
		Assert.assertEquals(items.size(), filteredList.size());

	}

}
