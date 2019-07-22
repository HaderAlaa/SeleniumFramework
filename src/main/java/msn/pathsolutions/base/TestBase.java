package msn.pathsolutions.base;

import java.io.File;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;

public class TestBase {

	
	public static Properties prop;
    public static WebDriver driver;
	
    
	@BeforeSuite
	
	//This Method to initialize the browser and open MSN website.
	public static void intialization() {
		// TODO Auto-generated method stub
		    System.setProperty("webdriver.chrome.driver",new File("drivers\\chromedriver.exe").getAbsolutePath());
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.get("https://www.msn.com/ar-eg");
			System.out.println(driver.getTitle());
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			
	}
	
		

}
