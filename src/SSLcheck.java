import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class SSLcheck {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		
		//proxy 
		
		Proxy proxy = new Proxy();
		proxy.setHttpProxy("ipaddress : port number");
		options.setCapability("proxy", proxy);
		System.setProperty("webdriver.chrome.driver", "E:\\Automation\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());
		
		
		
		//broken URL
		//step 1 is to get the all urls tied up to the links using selenium
		//Java methods will call URLs and gets the status code 
		//if status code is >400 then that url is not working - link which tied to url is broken 
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		
		//getting the status of all the links 
		List<WebElement>  links = driver.findElements(By.cssSelector("li[class ='gf-li'] a"));
		
		SoftAssert a = new SoftAssert();
		
		for(WebElement link:links)
		{
			String url = link.getAttribute("href");
			
			HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
			connection.setRequestMethod("HEAD");
			connection.connect();
			int responseCode = connection.getResponseCode();
			System.out.println(responseCode);
			a.assertTrue(responseCode<400, "The link with Text "+link.getText()+" is broken with code "+responseCode);
			
			/*if(responseCode>400)
			{
				
				System.out.println("The link with Text "+link.getText()+" is broken with code "+responseCode);
				Assert.assertTrue(true);
			}*/
		}
		
		a.assertAll();
		
		
		
		
		
		
		//getting the status of single link 
		/*String url = driver.findElement(By.cssSelector("a[href*='soapui']")).getAttribute("href");	
		
		HttpURLConnection  conn = (HttpURLConnection) new URL(url).openConnection();
		conn.setRequestMethod("HEAD");
		conn.connect();
		int respCode=conn.getResponseCode();
		System.out.println(respCode);*/
		
		/*String url1 = driver.findElement(By.cssSelector("a[href*='brokenlink']")).getAttribute("href");	
		
		HttpURLConnection  conn1 = (HttpURLConnection) new URL(url1).openConnection();
		conn1.setRequestMethod("HEAD");
		conn1.connect();
		int respCode1=conn1.getResponseCode();
		System.out.println(respCode1);*/
		
		
		
	
	
	}

}
