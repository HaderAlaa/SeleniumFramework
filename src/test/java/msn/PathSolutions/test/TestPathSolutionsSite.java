package msn.PathSolutions.test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import msn.pathsolutions.base.TestBase;
import msn.pathsolutions.pages.PathSolutionPage;


public class TestPathSolutionsSite extends TestBase {

	PathSolutionPage PathSolSite;

	@BeforeMethod
	
	public void setup() throws IOException
	{
		PathSolSite = new PathSolutionPage(driver);
	
		}
//----------------------------------------------------------------------------------------------------------------//	
	@Test
	public void OpenPathSolutionsWS () throws InterruptedException{
		
		// start reporters
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extentReports.html");
        
        // create ExtentReports and attach reporter(s)
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        
        // creates a toggle for the given test, adds all log events under it    
        ExtentTest test2 = extent.createTest("Test Case 2", "This Test Case to open Path Solutions web site , assert on it then Go to Contact us link and assert on it");
        
        						//-------------------------------------------//      
		PathSolSite.OpenPathSolSite();
		test2.log(Status.INFO, "User Opened Path Solutions Website");
		
		String title = driver.getTitle();
    	System.out.println("page title:" +title);
    	Assert.assertTrue(title.contains("Islamic Banking Software Provider"));
    	
    	test2.pass("Assertion_1: Title of the Path Solutions page contains Islamic Banking Software Provider ");
    	
    	
    	JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("scrollBy(0,2500)");
        
        PathSolSite.OpenContactUsLnk(); 
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        test2.info("User Opened Contact us link");
        
        String title2 = driver.getTitle();
    	System.out.println("page title:" +title2);
    	Assert.assertTrue(title.contains("Addresses"));
    	
    	Thread.sleep(5000);
    	
    	test2.pass("Assertion_2: Title of the Contact us Page contains Addresses word ");
    	test2.info("Test Case Status: Passed");
    	 
    	
    	// calling flush writes everything to the log file
        extent.flush();
        
	}   
        
//-------------------------------------------------------------------------------------------------------------------//        
    	@AfterMethod
    	public void tearDown()
    	{
    		driver.quit();
    	}
    	
    	
    	
	
    }



