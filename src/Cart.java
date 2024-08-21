import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Cart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		///SC - Adding the names to Cart 
		
		System.setProperty("webdriver.chrome.driver", "E:\\Automation\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		///Implicit wait 
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		///Explicit wait
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
		
		String[] itemsNeeded= {"Cucumber","Brocolli","Beetroot","Tomato"};
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise");
		addItems(driver,itemsNeeded);
		
		//clicking on cart
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		//Explicit wait
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promocode")));
		driver.findElement(By.cssSelector("input.promocode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		//Explicit wait
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
		
		
	}
	
	
	


	public static void addItems(WebDriver driver, String[] itemsNeeded)
	{
		int j=0;
		//all the veg will store in product
				List<WebElement> product=driver.findElements(By.cssSelector("h4.product-name"));
				//we get - 1 Kg along with veg name 
				
				for(int i=0;i<product.size();i++)
				{
					//need to format to get only veg name
					//Cucumber - 1 Kg --split with hyphen
					//name[0]- Cucumber , name[1] - 1 Kg
				String[] name=product.get(i).getText().split("-");
				
				//need to remove the extra space after the veg name
				String formattedName=name[0].trim();//trim will remove the extra space in right and left 
				
				//converting array to array list for ease search
				//check whether the items extracted are present in a array list or not
				
				List itemsNeededList=Arrays.asList(itemsNeeded);
				
				if(itemsNeededList.contains(formattedName))
				{
					j++;
					//click on Add to Cart
					 driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
					 
					 if(j==itemsNeeded.length) 
					 break;
				}
				}
	}
	

}
