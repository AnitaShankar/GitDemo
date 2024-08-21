package relativeLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class relative {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "E:\\Automation\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		WebElement nameEditBox=driver.findElement(By.cssSelector("[name='name']"));
		//relative locator	-above
		System.out.println(driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText());
		WebElement dateofBirth=driver.findElement(By.cssSelector("[for='dateofBirth']"));
		//relative locator	-above
		driver.findElement(with(By.tagName("input")).below(dateofBirth)).click();
		WebElement  icecreamLabel= driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
		//relative locator	-toLeftOf
		driver.findElement(with(By.tagName("input")).toLeftOf(icecreamLabel)).click();
		WebElement radioButton=driver.findElement(By.id("inlineRadio1"));
		//relative locator	-toRightOf
		System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(radioButton)).getText());
		
		
		
		

	}

}
