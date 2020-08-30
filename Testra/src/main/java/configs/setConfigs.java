package configs;

import java.io.IOException;

import org.apache.commons.mail.EmailException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
 
import browser.*;
import externalsource.*;

public class setConfigs {
	public static WebDriver driver;
	
	public setConfigs(){
	}
	 
	@BeforeSuite
	public void beforeSuite(){
	try {
		//readExcel.excelread();
	} //catch (InvalidFormatException e)
	catch(Exception e){
		// TODO Auto-generated catch block
		e.printStackTrace();
	} /*catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	*/ 
	 
	}
	 
	@BeforeClass
	public void beforeClass(){
	System.out.println("in @BeforeClass");
	}
	 
	@BeforeMethod
	public void beforeMethodClass(){
	System.out.println("in @BeforeMethod");
	//setConfigs.driver = browserConfig.getDriver("chrome");
	//driver = browserConfig.getDriver("chrome");
	//driver = browserConfig.getDriver("firefox");
	//driver = browserConfig.getDriver("IE");
	}
	 
	@AfterMethod
	public void close()
	{
	//this.driver.close();
	}
	 
	@AfterClass
	public void afterClass(){
	 
	}
	 
	@AfterSuite
	public void afterSuite() throws IOException, EmailException{
	 
	driver.quit();
	}
	}