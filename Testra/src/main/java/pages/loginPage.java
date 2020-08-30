package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.log4testng.Logger;

import static org.testng.Assert.fail;

import java.util.Base64;
import java.util.concurrent.TimeUnit;
import java.util.logging.LogManager;



public class loginPage {

WebDriver driver;
//Wait wait = new FluentWait<WebDriver>(driver);

Base64.Decoder decoder = Base64.getDecoder();  
public static final Logger LOG = Logger.getLogger(loginPage.class);


//LogManager.getLogger(loginPage.class);
public loginPage(WebDriver driver){
this.driver=driver;

}

//List of WebElement available under Login Page
//Username
@FindBy(how=How.XPATH,using="//span[contains(text(),'Enter Email/Mobile number')]/ancestor::label/preceding-sibling::input[@type='text']")
@CacheLookup
WebElement username;
//Password
@FindBy(how=How.XPATH,using="//span[contains(text(),'Enter Password')]/ancestor::label/preceding-sibling::input[@type='password']")
@CacheLookup
WebElement password;
//LoginButton
@FindBy(how=How.XPATH,using="//span[contains(text(),'Login')]/ancestor::button[@type='submit']")
@CacheLookup
WebElement lgnbtn;

//List of Functions/Methods from Login Page 
public void loginFlipkart(String use, String pass) {
	if(use != null && pass !=null) {
		try {
	// Decoding encrypted password   
		LOG.warn("Decoding encrypted password");
		String decpass = new String(decoder.decode(pass)); 
	
		if(username.isDisplayed() && username.isEnabled()) {
			username.sendKeys(use);
		}
		else {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			if(username.isDisplayed() && username.isEnabled()) {
				username.sendKeys(use);
			}
			else {
				LOG.error("User name field not displayed");
			}
			
		}
		if(password.isDisplayed() && password.isEnabled()) {
			password.sendKeys(decpass);	
		}else {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			if(password.isDisplayed() && password.isEnabled()) {
				password.sendKeys(decpass);
			}
			else {
				LOG.error("Password field not displayed");
			}
			
		}
		if(lgnbtn.isDisplayed() && lgnbtn.isEnabled()) {
			lgnbtn.click();
		}
		else {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			if(lgnbtn.isDisplayed() && lgnbtn.isEnabled()) {
				lgnbtn.click();
			}
			else {
				LOG.error("Login button not displayed");
			}
			
		}
		//Thread.sleep(3000);
		
		} catch (Exception e) {
		//
		e.printStackTrace();
		LOG.error("Login failure in"+driver);
		}
	} else {
		LOG.error("Null value passed for Username or Password from external file");
	}
	}

}