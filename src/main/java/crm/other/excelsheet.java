package crm.other;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import crm.util.TestUtil;

public class excelsheet {

	public static void main(String[] args) throws InvalidFormatException, FileNotFoundException, IOException {
		 

		ArrayList<ArrayList<String>>  data = new ArrayList<ArrayList<String>>();
		
		data = TestUtil.getExcelData("Contacts");
		
		System.out.println(data.toString());	
		

	}

}
