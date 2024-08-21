package streams;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class tableSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		///sorting the web table values with java streams in selenium
		
		//1.click on the column 
		//2.capture all the webelements into list
		//3.capture all the text of webelements into new list-->original list
		//4.sort on the new list of step 3 -->sorted list
		//5.compare original list vs sorted list
		
		System.setProperty("webdriver.chrome.driver", "E:\\Automation\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		//step 1
		driver.findElement(By.xpath("//tr/th[1]")).click();
		
		//step 2
		List<WebElement> elements =driver.findElements(By.xpath("//tr/td[1]"));
		
		//step 3
		List<String> originalList=elements.stream().map(s->s.getText()).collect(Collectors.toList());
		
		//step 4
		List<String> sortedList= originalList.stream().sorted().collect(Collectors.toList());
		
		//step 5
		Assert.assertTrue(originalList.equals(sortedList));
		
		
		///getting the price of the items
		
		//scanning the name text with getText -->Beans-print the price 
		
		List<String> price=elements.stream().filter(s->s.getText().contains("Beans"))
				.map(s->getPrice(s)).collect(Collectors.toList());
		price.forEach(s->System.out.println(s));
	
		

	}

	private static String getPrice(WebElement s) {
		// TODO Auto-generated method stub
		
		String priceValue=s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return priceValue;
	}

}
