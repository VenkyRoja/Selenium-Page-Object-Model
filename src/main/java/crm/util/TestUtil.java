package crm.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;//
import org.openqa.selenium.support.ui.WebDriverWait;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import crm.base.TestBase;

public class TestUtil extends TestBase {
	
	public static long PAGE_LOAD_TIMEOUT = 120;
	public static long IMPLICIT_WAIT = 120;
	public static long ELEMENT_CLICK_WAIT = 20;
	public static int PAGE_LOAD_TIMEOUT_MILLISECONDS = 5000;

	static Workbook book;
	static Sheet sheet;	
	
	//---------------1-----------------explicit wait and click-----------
	public static void clickOn(WebDriver driver, WebElement we) {
		
		new WebDriverWait(driver, ELEMENT_CLICK_WAIT).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(we));
		we.click();
	
	}	
	
	//---------------2-----------------click using JavaScript Executor-----------
	public static void clickElementByJs(WebDriver d, WebElement we)  {
		
		JavascriptExecutor js =  ((JavascriptExecutor) d);
		
		js.executeScript("arguments[0].click(); ", we);
		
	}
	
	
	//---------------3-----------------take screenshot-----------
	public static void takeScreenshot(WebDriver d, String filename)  {

		try {
			File scrshot = ((TakesScreenshot) d).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrshot, new File(System.getProperty("user.dir") + "/src/screenshots/" + filename));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//---------------4-----------------take screenshot-----------
	public static void waitforPageLoad(WebDriver d, int timeout)  {

		new WebDriverWait(d, timeout).until(webDriver -> ((JavascriptExecutor) d).executeScript("return document.readyState").equals("complete"));

	}
	
	
	//---------------5a-----------------get data from excel sheet 1-----------
	public static ArrayList<ArrayList<String>> getExcelData(String sheetName)  {
		
		ArrayList<ArrayList<String>>  data = new ArrayList<ArrayList<String>>();
		
		try {
			
			String Excelsheet_Path = System.getProperty("user.dir") + "/src/main/java/crm/testdata/";
			String Excelsheet_Name = "CRMData.xlsx";	
			String datapath = Excelsheet_Path + Excelsheet_Name;	
			FileInputStream file = new FileInputStream(new File(datapath));
            Workbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheet(sheetName);
            
            for (Row theRow: sheet) { 	
            	ArrayList<String> myrow = new ArrayList<String>();
            	for (Cell cell: theRow) {
            		String cellvalue = "";
            		if (cell.getCellType() == CellType.STRING) {	
            			cellvalue = cell.getStringCellValue();
            		} else if (cell.getCellType() == CellType.NUMERIC) {	
            			cellvalue = String.valueOf(cell.getNumericCellValue());
            		}
            		myrow.add(cellvalue);
            		//System.out.print(cellvalue + " --- ");
               }
            	
               data.add(myrow);
               //System.out.println();
           }
           workbook.close(); 

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
		return data;	
		
	}

	//---------------5b-----------------get data from excel sheet 2-----------
	public static Object[][] getDataFromExcel(String sheetName) {
		Object[][] data =  null;
		
		try {	
			
			String Excelsheet_Path = System.getProperty("user.dir") + "/src/main/java/crm/testdata/";
			String Excelsheet_Name = "CRMData.xlsx";	
			String datapath = Excelsheet_Path + Excelsheet_Name;	
			FileInputStream file = new FileInputStream(datapath);
		
			book = WorkbookFactory.create(file);
			sheet = book.getSheet(sheetName);
			
			int R = sheet.getLastRowNum();
			int C = sheet.getRow(0).getLastCellNum();
			
			data = new Object[R][C];
			
			System.out.println("# of rows = " + R  + "\n# of columns = " + C);
			
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
					//System.out.print(data[i][j] + " ---- ");
				}
				//System.out.println();
			}
		
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
		return data;
	}
	
	//---------------6-----------------get current time stamp string-----------
	public static String getCurrentTimestampString() {
			
		String currenttmestamp = "";
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM_dd_yyyy_HH_mm_ss");
		LocalDateTime date  =  LocalDateTime.now();
		currenttmestamp = dtf.format(date);
			
		return currenttmestamp;

	}
	
	
	//------------------------------------------------------------------------------

}
