import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class firefox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
System.setProperty("webdriver.gecko.driver", "E:\\Automation\\geckodriver-v0.34.0-win64\\geckodriver.exe");

		WebDriver driver= new FirefoxDriver();
		driver.get("https://www.instagram.com/accounts/login/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		//driver.close();
				

	}

}
