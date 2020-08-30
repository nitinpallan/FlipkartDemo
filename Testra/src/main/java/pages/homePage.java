package pages;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class homePage extends loginPage{

	public homePage(WebDriver driver) {
		super(driver);
		
	}
//List of WebElements available for HomePage
	@FindBy(how=How.XPATH,using="//input[@type='text' and contains(@title,'Search for')]")
	@CacheLookup
	WebElement searchbox;
	
	@FindBy(how=How.XPATH,using="//button[@type='submit']")
	@CacheLookup
	WebElement searchbutton;
	
	
	@FindBy(how=How.XPATH,using="//a[contains(text(),'Login')]")
	@CacheLookup
	WebElement loginlnk;
	
	@FindBy(how=How.XPATH,using="//div[contains(text(),'My Account')]")
	@CacheLookup
	WebElement myaccount;
	
	//List of Functions/Methods used from Home Page
	
	public void searchProduct(String criteria) {
	try {
	//Thread.sleep(3000);
		if(myaccount.isDisplayed()) {
			searchloop(criteria);
			}
		else {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			if(!myaccount.isDisplayed()) {
				searchloop(criteria);
				}
			else {
			LOG.error("Login not successful");}
		
	}
	
	//Thread.sleep(10000);
	} catch (Exception e) {
	//TODO Auto-generated catch block
	e.printStackTrace();
	}
	
	
	}
	
//This method is a reusable search loop for searching and selecting a criteria	
public void searchloop(String criteria) {
	if(searchbox.isDisplayed() && searchbox.isEnabled()) {
		searchbox.isSelected();
		searchbox.sendKeys(criteria);
		searchbutton.click();
	}
	else {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if(searchbox.isDisplayed() && searchbox.isEnabled()) {
			searchbox.isSelected();
			searchbox.sendKeys(criteria);
			searchbutton.click();
		}
		else {
			LOG.error("Search box not displayed");
		}
	}
	}
	
}


