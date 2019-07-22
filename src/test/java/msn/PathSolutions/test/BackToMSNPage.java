package msn.PathSolutions.test;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import junit.framework.Assert;
import msn.pathsolutions.base.TestBase;
import msn.pathsolutions.pages.MsnSearchPage;

public class BackToMSNPage extends TestBase {
	
	
	MsnSearchPage MsnPage;
	
	@BeforeMethod
	public void setup() throws IOException
	{
		MsnPage = new MsnSearchPage(driver);
	
	}
//--------------------------------------------------------------------------------------------------------------//
	
	@Test
	public void BackToMsnPage(){
		
		// start reporters
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extentReports.html");
        
        // create ExtentReports and attach reporter(s)
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        
        // creates a toggle for the given test, adds all log events under it    
        ExtentTest test3 = extent.createTest("Test Case 3", "This Test Case to Go to news link via Msn page then return to home Page");
        
                                //-------------------------------------------//
        
		MsnPage.SelectNewsLnk();
		test3.log(Status.INFO, "User goes to News page");
		
		Assert.assertEquals(true, driver.findElement(MsnPage.Ddm_News).isDisplayed());
		test3.pass("Assertion_1: News Drop down menu displayed");
		
		MsnPage.BacktoHomePage(1);
		test3.info("User go back to the home page ");
		
		String title = driver.getTitle();
    	System.out.println("page title:" +title);
    	Assert.assertTrue(title.contains("MSN"));
		
        test3.pass("Assertion_2: Title of the Page contains MSN word ");
    	test3.info("Test Case Status: Passed ");
    	
    	
		// calling flush writes everything to the log file
        extent.flush();
	
	}
	
	
//--------------------------------------------------------------------------------------------------------------//	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
		
		
	}
	
	
