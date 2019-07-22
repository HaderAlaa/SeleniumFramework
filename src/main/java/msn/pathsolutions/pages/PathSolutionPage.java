package msn.pathsolutions.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class PathSolutionPage {

    WebDriver driver;
	
	public PathSolutionPage(WebDriver driver){
		
		this.driver = driver;
	}
	
	
  //lOCATORS
	public By Lnk_ContactUs = By.linkText("Contact Us");


//-------------------------------------------------------------------------------------------------------	
	
  //Methods "BS"

  //This Method to open path solutions web site.
	public void OpenPathSolSite(){
		
		driver.get("http://www.path-solutions.com/");
	
		//Waiting Mechanism 
		WebDriverWait wait = new WebDriverWait(driver, 30,250);	
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(Lnk_ContactUs)));
	
	}
	
//-------------------------------------------------------------------------------------------------------
	
  //This Method to open the Contact us link
	public void OpenContactUsLnk(){
		
		driver.findElement(Lnk_ContactUs).click();
	}


	
	
	
}
