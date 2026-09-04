package com.selenium.webdriver.automation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;

public class ExcelLibrary {

    public String getExcelData(String sheetname, int rowNum, int cellNum) throws InvalidFormatException {
        String retVal = null;

        try {
            FileInputStream fis = new FileInputStream("C:\\temp\\adminsample.xls");
            Workbook wb = WorkbookFactory.create(fis);
            Sheet s = wb.getSheet(sheetname);
            Row r = s.getRow(rowNum);
            Cell c = r.getCell(cellNum);
            retVal = c.getStringCellValue();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
            catch (IOException e) {
                e.printStackTrace();
            }

        return (retVal);
    }

    public int getLastRowNumber(String sheetName) throws EncryptedDocumentException, IOException {
        int retVal = 0;
        try {
            FileInputStream fis = new FileInputStream("C:\\temp\\adminsample.xls");
            Workbook wb = WorkbookFactory.create(fis);
            Sheet s = wb.getSheet(sheetName);
            retVal = s.getLastRowNum();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return (retVal);
    }

    public static void main(String[] args) {

    }
}
