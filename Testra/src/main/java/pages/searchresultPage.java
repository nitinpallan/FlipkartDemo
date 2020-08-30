package pages;

import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import common.commonActions;


public class searchresultPage extends homePage{
	commonActions cmAction;
	String parent;
	public searchresultPage(WebDriver driver) {
		super(driver);
	 
	}
	//List of WebElements available for Search Result
		@FindBy(how=How.XPATH,using="//span[contains(text(),'Camera')]/ancestor::span[contains(text(),'Showing 1')]")
		@CacheLookup
		WebElement searchresult;
		@FindBy(how=How.XPATH,using="//div[contains(text(),'Sony')  or contains(text(),'Nikon') or contains(text(),'Canon')]//ancestor::a")
		@CacheLookup
		WebElement link;
		//List of Functions/Methods used from Search Result Page
		public void searchRandom(int start, int stop) {
		try {
			int i;
			if(searchresult.isDisplayed()) {
				System.out.println(searchresult.getText());
				
				//Scroll the webpage Javascript Executor
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy("+start+","+stop+")");
				
				//Identifying the links for random selection
				List<WebElement> links = driver.findElements(By.xpath("//div[contains(text(),'Sony')  or contains(text(),'Nikon') or contains(text(),'Canon')]//ancestor::a"));
				//List<WebElement> links = link.findElements(null);
				System.out.println(links.size());
				
				//Random usage for random click
					 Random r=new Random();
					 i = r.nextInt(5);
					 parent=driver.getWindowHandle();
					 links.get(r.nextInt(5)).click();
					 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					 Thread.sleep(3000);
					 Set<String>allWindowHandles=driver.getWindowHandles();
					 System.out.println(links.get(i).getText());
					 for(String handle : allWindowHandles)
					 {
					 System.out.println("Window handle - > " + handle);
					 driver.switchTo().window(handle);
					 
					 }
					 
			}
			
			else {
				LOG.error("Search Result grid not found");
				System.out.println("Search Result not found");
			}
		
		} catch (Exception e) {
		//TODO Auto-generated catch block
		e.printStackTrace();
		}
		}
	}
