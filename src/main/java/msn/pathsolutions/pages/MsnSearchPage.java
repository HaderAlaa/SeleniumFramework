package msn.pathsolutions.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MsnSearchPage {

    WebDriver driver;
	public MsnSearchPage(WebDriver driver){
	this.driver = driver;
	
	}
	
	
  //lOCATORS
	
	public By Txt_SearchBar = By.id("q");
	public By Btn_Search = By.id("sb_form_go");
	public By Lnk_ResultPage = By.linkText("Path Solutions");
  //public By Lnk_News = By.linkText("الأخبار");
	public By Lnk_News = By.xpath("//a[contains(text(),'الأخبار')]");
	public By Ddm_News = By.xpath("//a[@class='vertical']");
	
	

	
  //Methods "BS"
	
  //This Method to search for specific text in MSN search bar.
	public void Search(By Txt_SearchBar,String SearchText ){
		
		driver.findElement(Txt_SearchBar).sendKeys(SearchText);	
		
		//Waiting Mechanism 
	   	 WebDriverWait wait = new WebDriverWait(driver, 30,250);	
		 wait.until(ExpectedConditions.elementToBeClickable(Btn_Search));
	
	}
	
//-------------------------------------------------------------------------------------------	
  //This Method to click on search button and navigates to search result page
	public void DoSearch(){
		
		driver.findElement(Btn_Search).click();	
		 
		 driver.get("https://www.bing.com/search?q=Path+Solutions&form=PREGAR&httpsmsn=1&refig=e45f9a7547cc4a66a9390c31c097b7d5");
		 
	}
	
//-------------------------------------------------------------------------------------------	
	
  //This Method to select a specific result from the search result page
	public void Selectresult() throws InterruptedException{	
		
		driver.findElement(Lnk_ResultPage).click();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		
	}
	
//-------------------------------------------------------------------------------------------
	
  //This Method to click on news link and assert on the opened page
	public void SelectNewsLnk (){
		
		driver.findElement(Lnk_News).click();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
	}
//-------------------------------------------------------------------------------------------
//This method to select Homepage from the news dropdown menu
	public void BacktoHomePage(int index){
		
		 Select select= new Select(driver.findElement(Ddm_News));
    	 select.selectByIndex(index);
	}
	
	
	

	
	
	
	
	
	
}
