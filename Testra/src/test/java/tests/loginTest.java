package tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import browser.browserConfig;
import configs.setConfigs;
import pages.cartPage;
import pages.homePage;
import pages.loginPage;



public class loginTest extends setConfigs{
	String scroll_str,scroll_end;
	
	@DataProvider
	public static Object[][] ReadExcel() throws IOException
	{
	    	//Reading external excel sheet for input data which include browsers/userid-password and scroll points
			//FileInputStream fileInputStream= new FileInputStream("D:\\Official\\Telstra\\Test\\excel\\inputdata.xlsx"); //Excel sheet file location get mentioned here
			FileInputStream fileInputStream= new FileInputStream(System.getProperty("user.dir")+"\\excel\\inputdata.xlsx"); //Excel sheet file location get mentioned here	
			XSSFWorkbook workbook = new XSSFWorkbook (fileInputStream); //get my workbook 
	        XSSFSheet  worksheet = workbook.getSheet("Sheet1");// get my sheet from workbook
	        XSSFRow Row=worksheet.getRow(0);     //get my Row which start from 0   
	        DataFormatter formatter= new DataFormatter();
	        int RowNum = worksheet.getPhysicalNumberOfRows();// count my number of Rows
	        int ColNum= Row.getLastCellNum(); // get last ColNum 
	         
	        Object Data[][]= new Object[RowNum-1][ColNum]; // pass my  count data in array
	         
	            for(int i=0; i<RowNum-1; i++) //Loop work for Rows
	            {  
	            	XSSFRow row= worksheet.getRow(i+1);
	                 
	                for (int j=0; j<ColNum; j++) //Loop work for colNum
	                {
	                    if(row==null)
	                        Data[i][j]= "";
	                    else
	                    {
	                        XSSFCell cell= row.getCell(j);
	                        if(cell==null)
	                            Data[i][j]= ""; //if it get Null value it pass no data 
	                        else
	                        {
	                            String value=formatter.formatCellValue(cell);
	                            Data[i][j]=value; //This formatter get my all values as string i.e integer, float all type data value
	                        }
	                    }
	                }
	            }
	            
	        return Data;
	    }
	
	@Test
	(dataProvider="ReadExcel")
	public void loadPage(String Browser, String Username, String Password, String Scroll_start, String Scroll_end) throws Exception {
	try {
		//DataSet++;
		System.out.println("Name of the browser:" +Browser);
		System.out.println("Username:" +Username);
		System.out.println("Password:" +Password);
		/*System.out.println("Mouse scroll start value" +Scroll_start);
		scroll_str = Scroll_start;
		System.out.println("Mouse scroll end value:" +Scroll_end);
		scroll_end = Scroll_end;*/
		driver = browserConfig.getDriver(Browser);
		System.out.println("Login to Flipkart");
		driver.get("http://www.flipkart.com/");
		cartPage selcartPage = PageFactory.initElements(driver, cartPage.class);
		selcartPage.loginFlipkart(Username, Password);
		selcartPage.searchProduct("Camera");
		selcartPage.searchRandom(Integer.parseInt(Scroll_start), Integer.parseInt(Scroll_end));
		selcartPage.productDetails();
		selcartPage.gotoCart();
		selcartPage.validateorderandsubmit();
		selcartPage.FlipkartLogout();
		driver.close();
		}
	catch(Exception e){
		System.out.println("Error throwed"+e.getLocalizedMessage());
	}
	}

	
}
		
