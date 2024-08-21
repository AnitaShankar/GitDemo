import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class microsoftedge {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.edge.driver", "E:\\Automation\\edgedriver_win64\\msedgedriver.exe");

		WebDriver driver = new EdgeDriver();
		
		driver.get("https://www.instagram.com/accounts/login/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		//driver.close();
		


	}

}
