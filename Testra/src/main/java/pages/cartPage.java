package pages;

import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import org.testng.log4testng.Logger;

public class cartPage extends selectionPage{
	String finalproductdesc;
	String finalprice;
	
	public cartPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	//List of WebElements available for Cart Result
	//@FindBy(how=How.XPATH,using="//div/a[contains(text(),'Sony')  or contains(text(),'Nikon') or contains(text(),'Canon')]")
	@FindBy(how=How.XPATH,using="//*[contains(text(),'Sony')  or contains(text(),'Nikon') or contains(text(),'Canon')][1]")
	@CacheLookup
	WebElement cartprodDetail;
	//@FindBy(how=How.XPATH,using="//span[contains(text(),'₹')][1]")
	@FindBy(how=How.XPATH,using="//div[contains(text(),'₹')][1]")
	@CacheLookup
	WebElement cartproductprice;
	@FindBy(how=How.XPATH,using="//span[contains(text(),'Place Order')]/ancestor::button")
	@CacheLookup
	WebElement placeorderbtn;
	
	
	@FindBy(how=How.XPATH,using="//div[contains(text(),'Remove')]")
	@CacheLookup
	WebElement removebtn;
	
	
	@FindBy(how=How.XPATH,using="//div[contains(text(),'Cancel')]/following-sibling::div[contains(text(),'Remove')]")
	@CacheLookup
	WebElement removepopbtn;
	//Logout
	
	
	@FindBy(how=How.XPATH,using="//div[contains(text(),'Logout')]")
	@CacheLookup
	WebElement logoutbtn;
	
	public void validateorderandsubmit() {
		try {
			Thread.sleep(10000);
			//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			if(cartprodDetail.isDisplayed() && cartproductprice.isDisplayed()) {
				finalproductdesc = cartprodDetail.getText();
				System.out.println("Camera selected displayed in check out page is:"+finalproductdesc);
				finalprice = cartproductprice.getText();
				System.out.println("Price for the selected camera in check out page is:"+finalprice);
			}
			else {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				if(cartprodDetail.isDisplayed() && cartproductprice.isDisplayed()) {
					finalproductdesc = cartprodDetail.getText();
					System.out.println("Camera selected displayed in check out page is:"+finalproductdesc);
					finalprice = cartproductprice.getText();
					System.out.println("Price for the selected camera in check out page is:"+finalprice);
				}
				else {
					LOG.error("Cart not selected properly");
				}
				
			}
			
			/*Assert.assertEquals(productdesc, finalproductdesc);
			Assert.assertEquals(price, finalprice);*/
			//Remove the added item 
			if(removebtn.isDisplayed() && removebtn.isEnabled()) {
				removebtn.click();
				removepopbtn.click();
				} //for grid
			
			else {
				LOG.error("Remove button not displayed");
				
			}
			driver.close();
			driver.switchTo().window(parent);
			//Thread.sleep(10000);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			System.out.println("Switch complete"); 
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public void FlipkartLogout() {
		try {
		
			
		//Logout scenario
		
			if(myaccount.isDisplayed()) {
				Actions a =new Actions(driver);
				a.moveToElement(myaccount).build().perform();
				a.moveToElement(logoutbtn).click().build().perform();
			}
			else {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				if(myaccount.isDisplayed()) {
					Actions a =new Actions(driver);
					a.moveToElement(myaccount).build().perform();
					a.moveToElement(logoutbtn).click().build().perform();
				}
				else {
					LOG.error("My Account button not displayed");
				}
			}
			
				if(loginlnk.isDisplayed()) {
					System.out.println("Logout complete");	
					LOG.info("Logout complete");
				}
				else {
					LOG.error("Logout failed");
				}
				}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	 
	}
	
}
