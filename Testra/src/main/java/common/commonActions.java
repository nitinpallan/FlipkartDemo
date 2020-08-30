package common;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import browser.browserConfig;
import configs.setConfigs;

public class commonActions extends setConfigs{
	Wait wait = new FluentWait<WebDriver>(driver);
	public void scrollpage(int start, int stop){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy("+start+","+stop+")");
	}
	public void isExist() {
	
	}
	public boolean isElementPresent(By locatorKey) {
	    try {
	        driver.findElement(locatorKey);
	        return true;
	    } catch (org.openqa.selenium.NoSuchElementException e) {
	        return false;
	    }
	}
	
	/*public void waituntil(By byval) {
		wait.until(ExpectedConditions.visibilityOfElementLocated((By) byval));
		
	}*/
}


