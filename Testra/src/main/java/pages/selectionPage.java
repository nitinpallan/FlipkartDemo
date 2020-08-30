package pages;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class selectionPage extends searchresultPage{
String productdesc;
String price;
	public selectionPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	
	//List of WebElements available for Search Result
			@FindBy(how=How.XPATH,using="//h1/span[contains(text(),' ')]")
			@CacheLookup
			WebElement productdetails;
			@FindBy(how=How.XPATH,using="//div[contains(text(),'₹')][1]")
			@CacheLookup
			WebElement productprice;
			@FindBy(how=How.XPATH,using="//ul/li/button[contains(text(),' ')]")
			@CacheLookup
			WebElement gotocrtbtn;
			
	//List of WebElements in Cart
			
			@FindBy(how=How.XPATH,using="//h1/span[contains(text(),' ')]")
			@CacheLookup
			WebElement cartitemdetails;
			
			@FindBy(how=How.XPATH,using="//a/following-sibling::div/child::span[contains(text(),'₹')][1]")
			@CacheLookup
			WebElement cartprice;
	//List of Functions/Methods used from Selected Page
			public void productDetails() {
				try {
					productdesc = productdetails.getText();
					System.out.println("Camera selected is:"+productdesc);
					price = productprice.getText();
					System.out.println("Price for the selected camera is:"+price);
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
			public void gotoCart() {
					try {
						if(gotocrtbtn.isDisplayed() && gotocrtbtn.isEnabled()) {
							gotocrtbtn.click();
						}
						else {
							driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
							if(gotocrtbtn.isDisplayed() && gotocrtbtn.isEnabled()) {
								gotocrtbtn.click();
							}
							else {
							LOG.error("Go To Cart Button not displayed");
								}
						}
						
					}
					catch(Exception e) {
						System.out.println(e.getMessage());
					}	
			}

}
			

			