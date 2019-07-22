package msn.PathSolutions.test;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import msn.pathsolutions.base.TestBase;
import msn.pathsolutions.pages.MsnSearchPage;




public class SearchForText extends TestBase {

	MsnSearchPage PathSolutionsSearch;
	
	@BeforeMethod
	public void setup() throws IOException
	{
		PathSolutionsSearch = new MsnSearchPage(driver);
	
	}
	
//--------------------------------------------------------------------------------------------------------------//
	
	@Test
	public void SearchForPathsolutions () throws InterruptedException{
		
		// start reporters
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extentReports.html");
        
        // create ExtentReports and attach reporter(s)
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        
        // creates a toggle for the given test, adds all log events under it    
        ExtentTest test1 = extent.createTest("Test Case 1", "This Test Case to validate that users can use Msn search bar to search for Path Solutions website");
        
                                //-------------------------------------------//
        
		PathSolutionsSearch.Search(PathSolutionsSearch.Txt_SearchBar, "Path Solutions");
		PathSolutionsSearch.DoSearch();
		
		test1.log(Status.INFO, "User Searched for Path Solutions Text");
		
    	String title = driver.getTitle();
    	System.out.println("page title:" +title);
    	Assert.assertTrue(title.contains("Solutions"));
    	
//		PathSolutionsSearch.Selectresult();
    	
    	test1.pass("Assertion_1: Title of the Page contains Solutions word ");
    	
    	test1.info("Test Case Status: Passed ");
    	
		Thread.sleep(5000);
	
		// calling flush writes everything to the log file
        extent.flush();
	
	}
	
	
//-----------------------------------------------------------------------------------------------------------------//	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
	
	
	
	
	
}
