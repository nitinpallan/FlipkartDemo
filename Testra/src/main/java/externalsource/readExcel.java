package externalsource;


import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

//This class is used to read from external .xlsx file
public class readExcel {

	private static final String FILE_NAME 
    = "D:\\Official\\Telstra\\Test\\excel\\inputdata.xlsx"; 
	 public static DataFormatter formatter= new DataFormatter();
	

public static void excelread() throws IOException, InvalidFormatException 
{ 
	try {
		
    InputStream inp = new FileInputStream(FILE_NAME); 
    Workbook wb = WorkbookFactory.create(inp); 
    Sheet sheet = wb.getSheetAt(0); 
    Iterator<Row> iterator = sheet.iterator();

   while (iterator.hasNext()) {

        Row currentRow = iterator.next();
        Iterator<Cell> cellIterator = currentRow.iterator();

        while (cellIterator.hasNext()) {

            Cell currentCell = cellIterator.next();
            if(currentCell.getColumnIndex()==1) {
            System.out.println("Username column identified");
            if (currentCell.getCellType()== CellType.STRING) {
                System.out.println("Numeric:"+currentCell.getStringCellValue() + "--");
            } else if (currentCell.getCellType() == CellType.NUMERIC) {
                System.out.println("String"+currentCell.getNumericCellValue() + "--");
            }
            }
            else if(currentCell.getColumnIndex()==2) {
                System.out.println("Password column identified");
                if (currentCell.getCellType()== CellType.STRING) {
                    System.out.println("Numeric:"+currentCell.getStringCellValue() + "--");
                } else if (currentCell.getCellType() == CellType.NUMERIC) {
                    System.out.println("String"+currentCell.getNumericCellValue() + "--");
                }
                }
            else {
            	System.out.println("Outside Index 1");
            	/*if (currentCell.getCellType()== CellType.STRING) {
                    System.out.println("Numeric:"+currentCell.getStringCellValue() + "--");
                } else if (currentCell.getCellType() == CellType.NUMERIC) {
                    System.out.println("String"+currentCell.getNumericCellValue() + "--");
                }
                }*/
                
            }

        } 
        //System.out.println();

    }
    /*for (int rowIndex = 0; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
    	  Row row = sheet.getRow(rowIndex);
    	  if (row != null) {
    	    Cell cell = row.getCell(1);
    	    if (cell != null) {
    	      // Found column and there is value in the cell.
    	      String cellValueMaybeNull = cell.getStringCellValue();
    	      System.out.println("CellValue"+cellValueMaybeNull);
    	    }
    	  }
    	}*/
   inp.close();
    
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
