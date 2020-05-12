package com.OrangeHRM.utility;


import java.io.FileInputStream;

import java.io.IOException;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class TestUtil {
public static final int PAGE_LOAD_TIMEOUT = 20;
public static final int IMPLICIT_WAIT = 20;
public static String TEST_DATA_SHEET_PATH = "E:\\Selenium Projects\\POMOrangeHRMTest\\src\\main\\java\\com\\OrangeHRM\\Testdata\\DataTesting.xlsx";

static XSSFWorkbook book;
static XSSFSheet sheet;

public static Object[][] getTestData(int  Sheetumber){
	try {
		FileInputStream fis = new FileInputStream(TEST_DATA_SHEET_PATH);
		XSSFWorkbook book = new XSSFWorkbook(fis);
		
	}
	 catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	XSSFSheet sheet = book.getSheetAt(Sheetumber);
	
	Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	for (int i = 0; i < sheet.getLastRowNum(); i++) {
		for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
			data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
			// System.out.println(data[i][k]);
		}
	}
	return data;
}

}